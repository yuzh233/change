package me.cathub.change.product.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import me.cathub.change.common.util.json.LongJsonSerializer;
import me.cathub.change.user.bean.Shopkeeper;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品评论
 *
 * @author cheng
 */
public class ProductReview implements Serializable {

    @JsonSerialize(using = LongJsonSerializer.class)
    private long id;
    private String content;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;
    private int tableIndex;

    @JsonSerialize(using = LongJsonSerializer.class)
    private long shopkeeperId;
    @JsonSerialize(using = LongJsonSerializer.class)
    private long productId;

    /**
     * 谁评论的?
     */
    private Shopkeeper shopkeeper;

    /**
     * 评论的哪个产品?
     */
    private Product product;

    public ProductReview() {
    }

    public ProductReview(long id) {
        this.id = id;
    }

    public long getShopkeeperId() {
        return shopkeeperId;
    }

    public void setShopkeeperId(long shopkeeperId) {
        this.shopkeeperId = shopkeeperId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Shopkeeper getShopkeeper() {
        return shopkeeper;
    }

    public void setShopkeeper(Shopkeeper shopkeeper) {
        this.shopkeeper = shopkeeper;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductReview{");
        sb.append("id=").append(id);
        sb.append(", content='").append(content).append('\'');
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", tableIndex=").append(tableIndex);
        sb.append(", shopkeeperId=").append(shopkeeperId);
        sb.append(", productId=").append(productId);
        sb.append(", shopkeeper=").append(shopkeeper);
        sb.append(", product=").append(product);
        sb.append('}');
        return sb.toString();
    }
}
