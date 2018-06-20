package me.cathub.change.apply.common;

import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.ProductImage;
import me.cathub.change.storehouse.bean.StorehouseProductStock;

/**
 * @Author: z.yu
 * @Date: 2018/05/31 11:02
 * @Description:
 */
public class ProductPageResult {
    private Product product;
    private ProductImage productImage;

    public ProductPageResult() {
    }

    public ProductPageResult(Product product, ProductImage productImage) {
        this.product = product;
        this.productImage = productImage;
    }



    @Override
    public String toString() {
        return "ProductPageResult{" +
                "product=" + product +
                ", productImage=" + productImage +
                '}';
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductImage getProductImage() {
        return productImage;
    }

    public void setProductImage(ProductImage productImage) {
        this.productImage = productImage;
    }
}
