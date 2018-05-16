package me.cathub.change.storehouse.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import me.cathub.change.common.util.json.LongJsonSerializer;
import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.ProductCategory;
import me.cathub.change.user.bean.Company;

import java.io.Serializable;
import java.util.Date;

/**
 * 仓库产品库存
 *
 * @author cheng
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
    private long productId;
    @JsonSerialize(using = LongJsonSerializer.class)
    private long storehouseId;
    @JsonSerialize(using = LongJsonSerializer.class)
    private long productCategoryId;
    @JsonSerialize(using = LongJsonSerializer.class)
    private long companyId;

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

    public long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
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

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getStorehouseId() {
        return storehouseId;
    }

    public void setStorehouseId(long storehouseId) {
        this.storehouseId = storehouseId;
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
        sb.append(", productId=").append(productId);
        sb.append(", storehouseId=").append(storehouseId);
        sb.append(", productCategoryId=").append(productCategoryId);
        sb.append(", companyId=").append(companyId);
        sb.append(", storehouse=").append(storehouse);
        sb.append(", product=").append(product);
        sb.append(", productCategory=").append(productCategory);
        sb.append(", company=").append(company);
        sb.append('}');
        return sb.toString();
    }
}
