package ast;

public class ClassMethod {
    private String methodName;
    private String modifier;

    public ClassMethod(String methodName, String modifier){
        this.methodName = methodName;
        this.modifier = modifier;
    }

    public String getModifier() {
        return modifier;
    }

    public String getMethodName() {
        return methodName;
    }
}
