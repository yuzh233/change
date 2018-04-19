package me.cathub.change.order.bean;

import me.cathub.change.product.bean.Product;

import java.io.Serializable;

/**
 * 订单项
 */
public class OrderItem implements Serializable {
    private long id;
    private float unitPrice;
    private int count;
    private float totalPrice;
    private int tableIndex;

    private long product_id;
    private long order_id;

    private Product product;
    private Order order;

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
        return "OrderItem{" +
                "id=" + id +
                ", unitPrice=" + unitPrice +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                ", tableIndex=" + tableIndex +
                ", product_id=" + product_id +
                ", order_id=" + order_id +
                ", product=" + product +
                ", order=" + order +
                '}';
    }
}
