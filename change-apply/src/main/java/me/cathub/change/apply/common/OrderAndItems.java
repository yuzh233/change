package me.cathub.change.apply.common;

import me.cathub.change.order.bean.Order;
import me.cathub.change.order.bean.OrderItem;

import java.io.Serializable;
import java.util.List;

/**
 * No blood ! No bone！ No ash！
 *
 * @Author: cchangee
 * @Date: 2018/5/23
 * @Time: 20:49
 * </p>
 */
public class OrderAndItems extends Order implements Serializable {

    private List<OrderItem> orderItems;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
