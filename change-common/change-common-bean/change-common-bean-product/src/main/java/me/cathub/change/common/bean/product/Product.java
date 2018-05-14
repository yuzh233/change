package me.cathub.change.common.bean.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import me.cathub.change.common.bean.user.BrandQuotient;
import me.cathub.change.common.bean.user.Company;
import me.cathub.change.common.tool.LongJsonSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品
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
    private long productCategory_id;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private long company_id;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private long brandQuotient_id;

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

    public long getProductCategory_id() {
        return productCategory_id;
    }

    public Product(long id) {
        this.id = id;
    }

    public long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(long company_id) {
        this.company_id = company_id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
        sb.append(", productCategory_id=").append(productCategory_id);
        sb.append(", company_id=").append(company_id);
        sb.append(", brandQuotient_id=").append(brandQuotient_id);
        sb.append(", productCategory=").append(productCategory);
        sb.append(", company=").append(company);
        sb.append(", brandQuotient=").append(brandQuotient);
        sb.append('}');
        return sb.toString();
    }
}
