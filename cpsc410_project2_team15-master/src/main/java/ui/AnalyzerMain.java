package ui;

import ast.AnalysisEvaluator;
import ast.ClassNode;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.printer.YamlPrinter;
import com.github.javaparser.utils.SourceRoot;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AnalyzerMain {
    public static void main(String[] args) throws IOException {
//        try {
//            CompilationUnit program = StaticJavaParser.parse(Files.newInputStream(Paths.get("src/main/resources/test.java")));
//            program.findAll(ClassOrInterfaceDeclaration.class).stream().forEach(c -> {
//                System.out.println(c.getNameAsString());
//            });
//        } catch (IOException e){
//            e.printStackTrace();
//        }
           // -----------
//        ArrayList<CompilationUnit> astRoots = new ArrayList<>();
//        final ProjectRoot projectRoot = new ParserCollectionStrategy().collect(new File("src/main/resources").toPath());
//        projectRoot.getSourceRoots().forEach(root -> {
//            try {
//                astRoots.add(StaticJavaParser.parse((root.getRoot())));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
            // ------------
        SourceRoot sourceRoot = new SourceRoot(Paths.get("src/main/resources"));
        sourceRoot.tryToParse();
        List<CompilationUnit> compilationUnits = sourceRoot.getCompilationUnits();
        YamlPrinter printer = new YamlPrinter(true);
        System.out.println(printer.output(compilationUnits.get(1)));
//        System.out.println(compilationUnits.get(1));
        List<ClassNode> classNodes = new ArrayList<>();
        for(CompilationUnit cu : compilationUnits) {
            cu.findAll(ClassOrInterfaceDeclaration.class).forEach(c -> {
                 String className = c.getNameAsString();
                 List<FieldDeclaration> classFields = c.getFields();
                 List<MethodDeclaration> methods = c.getMethods();
                 List<String> methodNames = new ArrayList<>();
                 for (MethodDeclaration m : methods) {
                     String methodName = m.getNameAsString();
                     methodNames.add(methodName);
                 }
                 ClassNode classNode = new ClassNode(className, methodNames, c, methods, classFields);
                 classNodes.add(classNode);
            });
        }
        AnalysisEvaluator analysisEvaluator = new AnalysisEvaluator();
        analysisEvaluator.runAnalysis(classNodes);

        System.out.println(classNodes.get(1));

    }
}
