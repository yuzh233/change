package me.cathub.change.product.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import me.cathub.change.user.bean.BrandQuotient;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品
 */
public class Product implements Serializable {
    public static final int STATUS_PRESELL = 0;         // 运输中, 国内发货 国外仓库未收到货 可预售
    public static final int STATUS_IN_STOCK = 1;        // 国外仓收到货 可正常借卖

    private long id;
    private String name;
    private String subTitle;
    private float price;
    private String description;
    private int status;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date updateDate;
    private int tableIndex;

    private long productCategory_id;
    private long brandQuotient_id;

    private ProductCategory productCategory;
    private BrandQuotient brandQuotient;

    public long getProductCategory_id() {
        return productCategory_id;
    }

    public Product() {
    }

    public Product(long id) {
        this.id = id;
    }

    public void setProductCategory_id(long productCategory_id) {
        this.productCategory_id = productCategory_id;
    }

    public long getBrandQuotient_id() {
        return brandQuotient_id;
    }

    public void setBrandQuotient_id(long brandQuotient_id) {
        this.brandQuotient_id = brandQuotient_id;
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

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public BrandQuotient getBrandQuotient() {
        return brandQuotient;
    }

    public void setBrandQuotient(BrandQuotient brandQuotient) {
        this.brandQuotient = brandQuotient;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", tableIndex=" + tableIndex +
                ", productCategory_id=" + productCategory_id +
                ", brandQuotient_id=" + brandQuotient_id +
                ", productCategory=" + productCategory +
                ", brandQuotient=" + brandQuotient +
                '}';
    }
}
