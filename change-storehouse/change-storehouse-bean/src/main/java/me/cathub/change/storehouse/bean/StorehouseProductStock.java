package me.cathub.change.storehouse.bean;

import me.cathub.change.product.bean.Product;

import java.io.Serializable;
import java.util.Date;

/**
 * 仓库产品库存
 */
public class StorehouseProductStock implements Serializable {
    private long id;
    private int stock;
    private float price;
    private Date createDate;
    private Date updateDate;
    private int tableIndex;

    private long product_id;
    private long storehouse_id;

    private Product product;
    private Storehouse storehouse;

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
        return "StorehouseProductStock{" +
                "id=" + id +
                ", stock=" + stock +
                ", price=" + price +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", tableIndex=" + tableIndex +
                ", product_id=" + product_id +
                ", storehouse_id=" + storehouse_id +
                ", product=" + product +
                ", storehouse=" + storehouse +
                '}';
    }
}
