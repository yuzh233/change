package me.cathub.change.db.bean;

import me.cathub.change.common.bean.product.Product;

public class ProductImage {
    public static final int TYPE_COVER = 0;
    public static final int TYPE_SHOW = 1;
    public static final int TYPE_INFO = 2;

    private String url;
    private int type;

    private long product_id;

    private Product product;

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    @Override
    public String toString() {
        return "ProductImage{" +
                "url='" + url + '\'' +
                ", type=" + type +
                '}';
    }
}
