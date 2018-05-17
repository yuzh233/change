package me.cathub.change.product.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import me.cathub.change.common.util.json.LongJsonSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 属性值
 *
 * @author cheng
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
    private long propertyId;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private long productId;

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

    public long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
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
        sb.append(", propertyId=").append(propertyId);
        sb.append(", productId=").append(productId);
        sb.append(", property=").append(property);
        sb.append(", product=").append(product);
        sb.append('}');
        return sb.toString();
    }
}
