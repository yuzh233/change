package me.cathub.change.common.bean.storehouse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import me.cathub.change.common.bean.product.Product;
import me.cathub.change.common.bean.product.ProductCategory;
import me.cathub.change.common.bean.user.Company;
import me.cathub.change.common.tool.LongJsonSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 仓库产品库存
 */
public class StorehouseProductStock implements Serializable {
    @JsonSerialize(using = LongJsonSerializer.class)
    private long id;

    /**
     * 库存量
     */
    private int stock;

    /**
     * 价格
     */
    private float price;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;
    private int tableIndex;
    @JsonSerialize(using = LongJsonSerializer.class)
    private long product_id;
    @JsonSerialize(using = LongJsonSerializer.class)
    private long storehouse_id;
    @JsonSerialize(using = LongJsonSerializer.class)
    private long productCategory_id;
    @JsonSerialize(using = LongJsonSerializer.class)
    private long company_id;

    /**
     * 哪个仓库?
     */
    private Storehouse storehouse;

    /**
     * 哪个产品?
     */
    private Product product;

    /**
     * 产品所属分类
     */
    private ProductCategory productCategory;

    /**
     * 产品所属企业
     */
    private Company company;

    public StorehouseProductStock() {
    }

    public StorehouseProductStock(long id) {
        this.id = id;
    }

    public long getProductCategory_id() {
        return productCategory_id;
    }

    public void setProductCategory_id(long productCategory_id) {
        this.productCategory_id = productCategory_id;
    }

    public long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(long company_id) {
        this.company_id = company_id;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public long getStorehouse_id() {
        return storehouse_id;
    }

    public void setStorehouse_id(long storehouse_id) {
        this.storehouse_id = storehouse_id;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Storehouse getStorehouse() {
        return storehouse;
    }

    public void setStorehouse(Storehouse storehouse) {
        this.storehouse = storehouse;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StorehouseProductStock{");
        sb.append("id=").append(id);
        sb.append(", stock=").append(stock);
        sb.append(", price=").append(price);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", tableIndex=").append(tableIndex);
        sb.append(", product_id=").append(product_id);
        sb.append(", storehouse_id=").append(storehouse_id);
        sb.append(", productCategory_id=").append(productCategory_id);
        sb.append(", company_id=").append(company_id);
        sb.append(", storehouse=").append(storehouse);
        sb.append(", product=").append(product);
        sb.append(", productCategory=").append(productCategory);
        sb.append(", company=").append(company);
        sb.append('}');
        return sb.toString();
    }
}
