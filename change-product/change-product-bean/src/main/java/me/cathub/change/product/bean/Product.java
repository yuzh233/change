package me.cathub.change.product.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import me.cathub.change.common.util.json.LongJsonSerializer;
import me.cathub.change.user.bean.BrandQuotient;
import me.cathub.change.user.bean.Company;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品
 *
 * @author cheng
 */
public class Product implements Serializable {

    /**
     * 状态为:运输中, 国内发货 国外仓库未收到货 可预售
     */
    public static final int STATUS_PRE_SELL = 0;

    /**
     * 状态为:国外仓收到货 可正常借卖
     */
    public static final int STATUS_IN_STOCK = 1;

    @JsonSerialize(using = LongJsonSerializer.class)
    private long id;
    private String name;

    /**
     * 小标题
     */
    private String subTitle;
    private float price;

    /**
     * 描述(存放富文本渲染后的HTML代码)
     */
    private String description;
    private int status;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date updateDate;
    private int tableIndex;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private long productCategoryId;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private long companyId;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private long brandQuotientId;

    /**
     * 属于哪个分类?
     */
    private ProductCategory productCategory;

    /**
     * 属于哪个企业?
     */
    private Company company;

    /**
     * 企业哪个账户发布的?
     */
    private BrandQuotient brandQuotient;

    public Product() {
    }

    public long getProductCategoryId() {
        return productCategoryId;
    }

    public Product(long id) {
        this.id = id;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setProductCategoryId(long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public long getBrandQuotientId() {
        return brandQuotientId;
    }

    public void setBrandQuotientId(long brandQuotientId) {
        this.brandQuotientId = brandQuotientId;
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
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", subTitle='").append(subTitle).append('\'');
        sb.append(", price=").append(price);
        sb.append(", description='").append(description).append('\'');
        sb.append(", status=").append(status);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", tableIndex=").append(tableIndex);
        sb.append(", productCategoryId=").append(productCategoryId);
        sb.append(", companyId=").append(companyId);
        sb.append(", brandQuotientId=").append(brandQuotientId);
        sb.append(", productCategory=").append(productCategory);
        sb.append(", company=").append(company);
        sb.append(", brandQuotient=").append(brandQuotient);
        sb.append('}');
        return sb.toString();
    }
}
