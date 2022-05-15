package ast;

import java.util.List;

public class GraphNode {

    // TRUE if implementing any interfaces
    private boolean implementing;
    private List<String> interfacesImplemented;
    // TRUE if extending a class
    private boolean extending;
    private String extendedClass;
    private List<ClassField> fields;
    private List<ClassMethod> methods;

    public GraphNode(List<ClassField> fields, List<ClassMethod> methods, String extendedClass,
                     List<String> interfacesImplemented){
        this.fields = fields;
        this.methods = methods;
        if (!extendedClass.equals("")) {
            this.extending = true;
            this.extendedClass = extendedClass;
        }
        if (!interfacesImplemented.isEmpty()) {
            this.implementing = true;
            this.interfacesImplemented = interfacesImplemented;
        }
    }

    public List<ClassMethod> getMethods() {
        return methods;
    }

    public List<ClassField> getFields() {
        return fields;
    }

    public String getExtendedClass() {
        return extendedClass;
    }

    public boolean isExtending() {
        return extending;
    }

    public List<String> getInterfacesImplemented() {
        return interfacesImplemented;
    }

    public boolean isImplementing() {
        return implementing;
    }
}
