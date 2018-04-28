package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.ProductImageDao;
import me.cathub.change.api.rpc.server.product.ProductImageRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.common.tool.Sequence;
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

    @Autowired
    private Sequence sequence;

    @Override
    public long insert(ProductImage bean) throws Exception {
        bean.setId(sequence.nextId());
        return productImageDao.insert(bean) ? bean.getId() : -1;
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
    public int count(int tableIndex) throws Exception {
        return productImageDao.count(tableIndex);
    }

    @Override
    public List<ProductImage> listByDel(int page, int count, int tableIndex) throws Exception {
        return productImageDao.listByDel(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByDel(int tableIndex) throws Exception {
        return productImageDao.countByDel(tableIndex);
    }

    @Override
    public int clear(int tableIndex) throws Exception {
        return productImageDao.clear(tableIndex);
    }

    @Override
    public List<ProductImage> listByProductIdAndImageType(long product_id, int type, int page, int count, int tableIndex) throws Exception {
        return productImageDao.listByProductIdAndImageType(product_id, type, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByProductIdAndImageType(long product_id, int type, int tableIndex) throws Exception {
        return productImageDao.countByProductIdAndImageType(product_id, type, tableIndex);
    }

    @Override
    public ProductImage selectByProductIdHead(long product_id, int tableIndex) throws Exception {
        return fill(productImageDao.selectByProductIdHead(product_id, tableIndex));
    }

    @Override
    public ProductImage fill(ProductImage bean) {
        try {
            Product product = productRpcServer.select(new Product(bean.getProduct_id()));

            bean.setProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
