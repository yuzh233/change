package me.cathub.change.common.bean.product;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品图片
 */
public class ProductImage implements Serializable {
    public static final int TYPE_COVER = 0;
    public static final int TYPE_SHOW = 1;
    public static final int TYPE_INFO = 2;

    private long id;
    private String url;
    private int type;
    private Date createDate;
    private Date updateDate;
    private int tableIndex;

    private long product_id;

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
        return "ProductImage{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", type=" + type +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", tableIndex=" + tableIndex +
                ", product_id=" + product_id +
                ", product=" + product +
                '}';
    }
}
