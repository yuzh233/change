package me.cathub.change.apply.common;

import java.io.Serializable;

/**
 * 下单
 * @author cheng
 * @date 2018/5/26
 * @time 12:17
 */
public class PlaceAnOrder implements Serializable {
    private long productId;
    private long count;
    private long storehouseId;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getStorehouseId() {
        return storehouseId;
    }

    public void setStorehouseId(long storehouseId) {
        this.storehouseId = storehouseId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlaceAnOrder{");
        sb.append("productId=").append(productId);
        sb.append(", count=").append(count);
        sb.append(", storehouseId=").append(storehouseId);
        sb.append('}');
        return sb.toString();
    }
}
