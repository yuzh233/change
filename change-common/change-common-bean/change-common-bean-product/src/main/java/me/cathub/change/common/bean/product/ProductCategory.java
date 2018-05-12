package me.cathub.change.common.bean.product;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品分类
 */
public class ProductCategory implements Serializable {

    private long id;
    private String name;

    /**
     * 所在层数
     */
    private int storey;
    private Date createDate;
    private Date updateDate;
    private int tableIndex;

    private long parent_id;

    /**
     * 父级分类
     */
    private ProductCategory parent;

    public ProductCategory() {
    }

    public ProductCategory(long id) {
        this.id = id;
    }

    public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
    }

    public long getParent_id() {
        return parent_id;
    }

    public void setParent_id(long parent_id) {
        this.parent_id = parent_id;
    }

    public ProductCategory getParent() {
        return parent;
    }

    public void setParent(ProductCategory parent) {
        this.parent = parent;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductCategory{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", storey=").append(storey);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", tableIndex=").append(tableIndex);
        sb.append(", parent_id=").append(parent_id);
        sb.append(", parent=").append(parent);
        sb.append('}');
        return sb.toString();
    }
}
