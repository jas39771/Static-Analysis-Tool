package ast;

public class ClassField {
    private String fieldName;
    // public or private or protected
    private String modifier;

    public ClassField(String fieldName, String modifier) {
        this.fieldName = fieldName;
        this.modifier = modifier;
    }

    public String getModifier() {
        return modifier;
    }

    public String getFieldName() {
        return fieldName;
    }
}
