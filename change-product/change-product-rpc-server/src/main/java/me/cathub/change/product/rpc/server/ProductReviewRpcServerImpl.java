package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.ProductReviewDao;
import me.cathub.change.api.rpc.server.product.ProductReviewRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.ProductReview;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ProductReviewRpcServerImpl extends BaseRpcServerImpl<ProductReview, ProductReviewDao> implements ProductReviewRpcServer {

    @Autowired
    private ProductRpcServer productRpcServer;

    @Override
    public List<ProductReview> listByProductId(long product_id, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return dao.listByProductId(product_id, page, count, tableIndex);
        else
            return dao.listByProductId(product_id, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByProductId(long product_id, int tableIndex) throws Exception {
        return dao.countByProductId(product_id, tableIndex);
    }

    @Override
    public ProductReview fill(ProductReview bean) {
        try {
            Product product = productRpcServer.select(new Product(bean.getProduct_id()), true);

            bean.setProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
