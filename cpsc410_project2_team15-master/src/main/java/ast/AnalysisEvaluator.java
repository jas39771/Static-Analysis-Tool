package ast;

import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.SimpleName;

import javax.xml.transform.ErrorListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalysisEvaluator {
    public AnalysisEvaluator(){}
    private Map<String, List<String>> methodsByClass = new HashMap<>();
    private Map<String, List<String>> fieldsByClass = new HashMap<>();
    // Nested Hashmap that contains altered fields in each method in each class
    private Map<String, Map<String, List<String>>> fieldsByMethodByClass = new HashMap<>();
    public List<GraphNode> runAnalysis(List<ClassNode> classNodes){
        buildDatabase(classNodes);
        for (ClassNode c : classNodes) {

        }
        return null;
    }

    private void buildDatabase(List<ClassNode> classNodes) {
        for (ClassNode c : classNodes) {
            List<String> methodNames = c.getMethodNames();
            methodsByClass.put(c.getClassName(), methodNames);
            extractAndStoreFields(c);
            Map<String, List<String>> alteredFieldsInMethods = getAlteredFieldsInMethods(c);
            fieldsByMethodByClass.put(c.getClassName(), alteredFieldsInMethods);
        }
    }

    private Map<String, List<String>> getAlteredFieldsInMethods(ClassNode c) {
        Map<String, List<String>> alteredFieldsInMethods = new HashMap<>();
        List<MethodDeclaration> cMethods = c.getMethods();
        for (MethodDeclaration m : cMethods) {
            List<String> alteredFields = new ArrayList<>();
            List<AssignExpr> changedVars = m.findAll(AssignExpr.class);
            for (AssignExpr a : changedVars) {
                Expression target = a.getTarget();
                if (target.isNameExpr()) {
                    NameExpr targetNameExpr = target.asNameExpr();
                    String targetVar = targetNameExpr.getNameAsString();
                    if (fieldsByClass.get(c.getClassName()).contains(targetVar)) {
                        alteredFields.add(targetVar);
                    }
                }
            }
            alteredFieldsInMethods.put(m.getNameAsString(), alteredFields);
        }
        return alteredFieldsInMethods;
    }

    private void extractAndStoreFields(ClassNode c) {
        List<String> fields = new ArrayList<>();
        for (FieldDeclaration f : c.getFields()) {
            for (VariableDeclarator v : f.getVariables()) {
                fields.add(v.getNameAsString());
            }
        }
        fieldsByClass.put(c.getClassName(), fields);
    }
}
