package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.ProductReviewDao;
import me.cathub.change.api.rpc.server.product.ProductReviewRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.ProductReview;
import me.cathub.change.user.bean.Shopkeeper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 产品评论Rpc服务实现类
 *
 * @author cheng
 */
public class ProductReviewRpcServerImpl extends BaseRpcServerImpl<ProductReview, ProductReviewDao> implements ProductReviewRpcServer {

    @Autowired
    private ProductRpcServer productRpcServer;

    @Autowired
    private ShopkeeperRpcServer shopkeeperRpcServer;

    @Override
    public List<ProductReview> listByProductId(long productId, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByProductId(productId, page, count, tableIndex);
        } else {
            return dao.listByProductId(productId, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
        }
    }

    @Override
    public int countByProductId(long productId, int tableIndex) throws Exception {
        return dao.countByProductId(productId, tableIndex);
    }

    @Override
    public ProductReview fill(ProductReview bean) {
        try {
            Product product = productRpcServer.select(new Product(bean.getProductId()), true);
            Shopkeeper shopkeeper = shopkeeperRpcServer.select(new Shopkeeper(bean.getShopkeeperId()), true);

            bean.setProduct(product);
            bean.setShopkeeper(shopkeeper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
