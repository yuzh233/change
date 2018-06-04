package me.cathub.change.apply.common;

import me.cathub.change.order.bean.Order;
import me.cathub.change.order.bean.OrderItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @Author: YouJie
 * @Date: 2018/5/23
 * @Time: 20:49
 * </p>
 */
public class OrderAndItems extends Order implements Serializable {

    private List<OrderItem> orderItems;

    private List<OrderItemP> orderItemsP = new ArrayList<>();

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public List<OrderItemP> getOrderItemsP() {
        return orderItemsP;
    }

    public void setOrderItemsP(List<OrderItemP> orderItemsP) {
        this.orderItemsP = orderItemsP;
    }
}
