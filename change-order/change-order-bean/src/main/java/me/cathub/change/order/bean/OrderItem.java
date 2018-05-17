package me.cathub.change.order.bean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import me.cathub.change.common.util.json.LongJsonSerializer;
import me.cathub.change.product.bean.Product;

import java.io.Serializable;

/**
 * 订单项
 *
 * @author cheng
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
     * 推送B2C平台成功后返回的标识ID
     */
    private float returnId;

    private int tableIndex;

    @JsonSerialize(using = LongJsonSerializer.class)
    private long productId;
    @JsonSerialize(using = LongJsonSerializer.class)
    private long orderId;

    /**
     * 买的哪个产品?
     */
    private Product product;

    /**
     * 属于哪个总订单?
     */
    private Order order;

    public OrderItem() {
    }

    public OrderItem(long id) {
        this.id = id;
    }

    public float getReturnId() {
        return returnId;
    }

    public void setReturnId(float returnId) {
        this.returnId = returnId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
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
        sb.append(", $count=").append(count);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", returnId=").append(returnId);
        sb.append(", tableIndex=").append(tableIndex);
        sb.append(", productId=").append(productId);
        sb.append(", orderId=").append(orderId);
        sb.append(", product=").append(product);
        sb.append(", order=").append(order);
        sb.append('}');
        return sb.toString();
    }
}
