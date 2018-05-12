package me.cathub.change.common.bean.product;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品图片
 */
public class ProductImage implements Serializable {

    /**
     * 封面图片 (位于产品列表:入口)
     */
    public static final int TYPE_COVER = 0;

    /**
     * 展示图片 (位于左边:可以按上去放大的那种)
     */
    public static final int TYPE_SHOW = 1;

    /**
     * 信息图片 (位于详细描述)
     */
    public static final int TYPE_INFO = 2;

    private long id;
    private String url;
    private int type;
    private Date createDate;
    private Date updateDate;
    private int tableIndex;

    private long product_id;

    /**
     * 哪个产品的图片?
     */
    private Product product;

    public ProductImage() {
    }

    public ProductImage(long id) {
        this.id = id;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductImage{");
        sb.append("id=").append(id);
        sb.append(", url='").append(url).append('\'');
        sb.append(", type=").append(type);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", tableIndex=").append(tableIndex);
        sb.append(", product_id=").append(product_id);
        sb.append(", product=").append(product);
        sb.append('}');
        return sb.toString();
    }
}
