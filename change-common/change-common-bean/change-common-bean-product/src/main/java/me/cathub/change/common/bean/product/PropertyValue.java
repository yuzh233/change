package me.cathub.change.common.bean.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import me.cathub.change.common.tool.LongJsonSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 属性值
 */
public class PropertyValue implements Serializable {
    @JsonSerialize(using = LongJsonSerializer.class)
    private long id;
    private String value;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;
    private int tableIndex;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private long property_id;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private long product_id;

    /**
     * 哪个属性的值?
     */
    private Property property;

    /**
     * 属于哪个产品?
     */
    private Product product;

    public PropertyValue() {
    }

    public PropertyValue(long id) {
        this.id = id;
    }

    public long getProperty_id() {
        return property_id;
    }

    public void setProperty_id(long property_id) {
        this.property_id = property_id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public int getTableIndex() {
        return tableIndex;
    }

    public void setTableIndex(int tableIndex) {
        this.tableIndex = tableIndex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PropertyValue{");
        sb.append("id=").append(id);
        sb.append(", value='").append(value).append('\'');
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", tableIndex=").append(tableIndex);
        sb.append(", property_id=").append(property_id);
        sb.append(", product_id=").append(product_id);
        sb.append(", property=").append(property);
        sb.append(", product=").append(product);
        sb.append('}');
        return sb.toString();
    }
}
