package me.cathub.change.apply.common;

import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.ProductImage;

import java.io.Serializable;

/**
 * @Author: YouJie
 * @Date: 2018/5/31
 * @Time: 11:04
 */
public class ProductPacking extends Product implements Serializable{

    private ProductImage img;

    public ProductImage getImg() {
        return img;
    }

    public void setImg(ProductImage img) {
        this.img = img;
    }
}
