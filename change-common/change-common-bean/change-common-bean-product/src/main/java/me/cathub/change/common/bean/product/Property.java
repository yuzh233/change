package me.cathub.change.common.bean.product;

import java.io.Serializable;
import java.util.Date;

/**
 * 属性
 */
public class Property implements Serializable {
    private long id;
    private String name;
    private Date createDate;
    private Date updateDate;
    private int tableIndex;

    private long productCategory_id;

    private ProductCategory productCategory;

    public Property() {
    }

    public Property(long id) {
        this.id = id;
    }

    public long getProductCategory_id() {
        return productCategory_id;
    }

    public void setProductCategory_id(long productCategory_id) {
        this.productCategory_id = productCategory_id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", tableIndex=" + tableIndex +
                ", productCategory_id=" + productCategory_id +
                ", productCategory=" + productCategory +
                '}';
    }
}
