package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.ProductImageDao;
import me.cathub.change.api.rpc.server.product.ProductImageRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 产品图片Rpc服务实现类
 *
 * @author cheng
 */
public class ProductImageRpcServerImpl extends BaseRpcServerImpl<ProductImage, ProductImageDao> implements ProductImageRpcServer {

    @Autowired
    private ProductRpcServer productRpcServer;

    @Override
    public List<ProductImage> listByProductIdAndImageType(long productId, int type, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByProductIdAndImageType(productId, type, page, count, tableIndex);
        } else {
            return dao.listByProductIdAndImageType(productId, type, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
        }
    }

    @Override
    public int countByProductIdAndImageType(long productId, int type, int tableIndex) throws Exception {
        return dao.countByProductIdAndImageType(productId, type, tableIndex);
    }

    @Override
    public ProductImage selectByProductIdCover(long productId, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.selectByProductIdCover(productId, tableIndex);
        } else {
            return fill(dao.selectByProductIdCover(productId, tableIndex));
        }
    }

    @Override
    public ProductImage fill(ProductImage bean) {
        try {
            Product product = productRpcServer.select(new Product(bean.getProductId()), true);

            bean.setProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
