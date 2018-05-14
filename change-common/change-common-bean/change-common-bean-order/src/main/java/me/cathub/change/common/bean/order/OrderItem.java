package me.cathub.change.common.bean.order;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import me.cathub.change.common.bean.product.Product;
import me.cathub.change.common.tool.LongJsonSerializer;

import java.io.Serializable;

/**
 * 订单项
 */
public class OrderItem implements Serializable {
    @JsonSerialize(using = LongJsonSerializer.class)
    private long id;

    /**
     * 单价
     */
    private float unitPrice;

    /**
     * 数量
     */
    private int count;

    /**
     * 总价
     */
    private float totalPrice;

    /**
     * 第三方平台返回的item Id
     */
    private float itemId;
    private int tableIndex;

    @JsonSerialize(using = LongJsonSerializer.class)
    private long product_id;
    @JsonSerialize(using = LongJsonSerializer.class)
    private long order_id;

    private Product product;    // 买的哪个产品?
    private Order order;        // 属于哪个总订单?

    public OrderItem() {
    }

    public OrderItem(long id) {
        this.id = id;
    }

    public float getItemId() {
        return itemId;
    }

    public void setItemId(float itemId) {
        this.itemId = itemId;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderItem{");
        sb.append("id=").append(id);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", count=").append(count);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", itemId=").append(itemId);
        sb.append(", tableIndex=").append(tableIndex);
        sb.append(", product_id=").append(product_id);
        sb.append(", order_id=").append(order_id);
        sb.append(", product=").append(product);
        sb.append(", order=").append(order);
        sb.append('}');
        return sb.toString();
    }
}
