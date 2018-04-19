package me.cathub.change.common.base;

import java.io.Serializable;

/**
 * 属性值
 */
public class PropertyAndValue implements Serializable {
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
        return "PropertyAndValue{" +
                "property='" + property + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}