package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.ProductImageDao;
import me.cathub.change.api.rpc.server.product.ProductImageRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ProductImageRpcServerImpl implements ProductImageRpcServer {

    @Autowired
    private ProductImageDao productImageDao;

    @Autowired
    private ProductRpcServer productRpcServer;

    @Override
    public boolean insert(ProductImage bean) throws Exception {
        return productImageDao.insert(bean);
    }

    @Override
    public boolean deleteL(ProductImage bean) throws Exception {
        return productImageDao.deleteL(bean);
    }

    @Override
    public boolean restore(ProductImage bean) throws Exception {
        return productImageDao.restore(bean);
    }

    @Override
    public boolean deleteP(ProductImage bean) throws Exception {
        return productImageDao.deleteP(bean);
    }

    @Override
    public boolean update(ProductImage bean) throws Exception {
        return productImageDao.update(bean);
    }

    @Override
    public ProductImage select(ProductImage bean) throws Exception {
        return fill(productImageDao.select(bean));
    }

    @Override
    public List<ProductImage> list(int page, int count, int tableIndex) throws Exception {
        return productImageDao.list(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public long count(int tableIndex) throws Exception {
        return productImageDao.count(tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return productImageDao.clear(tableIndex);
    }

    @Override
    public ProductImage fill(ProductImage bean) {
        try {
            bean.setProduct(productRpcServer.select(new Product(bean.getProduct_id())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
