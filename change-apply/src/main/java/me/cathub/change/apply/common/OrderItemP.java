package me.cathub.change.apply.common;

import me.cathub.change.order.bean.OrderItem;

import java.io.Serializable;

/**
 * @Author: YouJie
 * @Date: 2018/6/2
 * @Time: 15:50
 */
public class OrderItemP extends OrderItem implements Serializable{

    private ProductPacking productPacking;

    public ProductPacking getProductPacking() {
        return productPacking;
    }

    public void setProductPacking(ProductPacking productPacking) {
        this.productPacking = productPacking;
    }
}
