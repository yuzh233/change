package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.ProductImageDao;
import me.cathub.change.api.rpc.server.product.ProductImageRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.common.bean.product.Product;
import me.cathub.change.common.bean.product.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ProductImageRpcServerImpl extends BaseRpcServerImpl<ProductImage, ProductImageDao> implements ProductImageRpcServer {

    @Autowired
    private ProductRpcServer productRpcServer;

    @Override
    public List<ProductImage> listByProductIdAndImageType(long product_id, int type, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return dao.listByProductIdAndImageType(product_id, type, page, count, tableIndex);
        else
            return dao.listByProductIdAndImageType(product_id, type, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByProductIdAndImageType(long product_id, int type, int tableIndex) throws Exception {
        return dao.countByProductIdAndImageType(product_id, type, tableIndex);
    }

    @Override
    public ProductImage selectByProductIdCover(long product_id, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return dao.selectByProductIdCover(product_id, tableIndex);
        else
            return fill(dao.selectByProductIdCover(product_id, tableIndex));
    }

    @Override
    public ProductImage fill(ProductImage bean) {
        try {
            Product product = productRpcServer.select(new Product(bean.getProduct_id()), true);

            bean.setProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
