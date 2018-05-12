package me.cathub.change.common.bean.product;

/**
 * 属性键值对
 */
public class PropertyKeyValue {
    private String key;
    private String val;

    public PropertyKeyValue() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "PropertyKeyValue{" +
                "key='" + key + '\'' +
                ", val='" + val + '\'' +
                '}';
    }
}
