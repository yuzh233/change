package me.cathub.change.order.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import me.cathub.change.common.util.json.LongJsonSerializer;
import me.cathub.change.storehouse.bean.Storehouse;
import me.cathub.change.user.bean.BrandQuotient;
import me.cathub.change.user.bean.Shopkeeper;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单
 *
 * @author cheng
 */
public class Order implements Serializable {

    @JsonSerialize(using = LongJsonSerializer.class)
    private long id;

    /**
     * 订单号(目前是弃用状态, id当作订单号在用)
     */
    private String orderCode;

    /**
     * 订单总金额
     */
    private float totalPrice;

    /**
     * 备注信息
     */
    private String message;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;
    private int tableIndex;

    @JsonSerialize(using = LongJsonSerializer.class)
    private long storehouseId;
    @JsonSerialize(using = LongJsonSerializer.class)
    private long shopkeeperId;
    @JsonSerialize(using = LongJsonSerializer.class)
    private long brandQuotientId;

    /**
     * 在哪个仓库买的?
     */
    private Storehouse storehouse;

    /**
     * 买家是谁?
     */
    private Shopkeeper shopkeeper;

    /**
     * 卖家是谁?
     */
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

    public long getStorehouseId() {
        return storehouseId;
    }

    public void setStorehouseId(long storehouseId) {
        this.storehouseId = storehouseId;
    }

    public long getShopkeeperId() {
        return shopkeeperId;
    }

    public void setShopkeeperId(long shopkeeperId) {
        this.shopkeeperId = shopkeeperId;
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
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", orderCode='").append(orderCode).append('\'');
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", message='").append(message).append('\'');
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", tableIndex=").append(tableIndex);
        sb.append(", storehouseId=").append(storehouseId);
        sb.append(", shopkeeperId=").append(shopkeeperId);
        sb.append(", brandQuotientId=").append(brandQuotientId);
        sb.append(", storehouse=").append(storehouse);
        sb.append(", shopkeeper=").append(shopkeeper);
        sb.append(", brandQuotient=").append(brandQuotient);
        sb.append('}');
        return sb.toString();
    }
}
