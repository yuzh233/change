package me.cathub.change.db.bean;

public class Property {
    private String property;
    private String value;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Property{" +
                "property='" + property + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
