package me.cathub.change.common.bean.order;

import me.cathub.change.common.bean.storehouse.Storehouse;
import me.cathub.change.common.bean.user.BrandQuotient;
import me.cathub.change.common.bean.user.Shopkeeper;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单
 */
public class Order implements Serializable {
    private long id;
    private String orderCode;
    private float totalPrice;
    private String message;
    private Date createDate;
    private Date updateDate;
    private int tableIndex;

    private long storehouse_id;
    private long shopkeeper_id;
    private long brandQuotient_id;

    private Storehouse storehouse;
    private Shopkeeper shopkeeper;
    private BrandQuotient brandQuotient;

    public Order() {
    }

    public Order(long id) {
        this.id = id;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public long getStorehouse_id() {
        return storehouse_id;
    }

    public void setStorehouse_id(long storehouse_id) {
        this.storehouse_id = storehouse_id;
    }

    public long getShopkeeper_id() {
        return shopkeeper_id;
    }

    public void setShopkeeper_id(long shopkeeper_id) {
        this.shopkeeper_id = shopkeeper_id;
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

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Shopkeeper getShopkeeper() {
        return shopkeeper;
    }

    public void setShopkeeper(Shopkeeper shopkeeper) {
        this.shopkeeper = shopkeeper;
    }

    public BrandQuotient getBrandQuotient() {
        return brandQuotient;
    }

    public void setBrandQuotient(BrandQuotient brandQuotient) {
        this.brandQuotient = brandQuotient;
    }

    public Storehouse getStorehouse() {
        return storehouse;
    }

    public void setStorehouse(Storehouse storehouse) {
        this.storehouse = storehouse;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderCode='" + orderCode + '\'' +
                ", totalPrice=" + totalPrice +
                ", message='" + message + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", tableIndex=" + tableIndex +
                ", storehouse_id=" + storehouse_id +
                ", shopkeeper_id=" + shopkeeper_id +
                ", brandQuotient_id=" + brandQuotient_id +
                ", storehouse=" + storehouse +
                ", shopkeeper=" + shopkeeper +
                ", brandQuotient=" + brandQuotient +
                '}';
    }
}
