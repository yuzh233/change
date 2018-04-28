package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.ProductReviewDao;
import me.cathub.change.api.rpc.server.product.ProductReviewRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.ProductReview;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ProductReviewRpcServerImpl implements ProductReviewRpcServer {

    @Autowired
    private ProductReviewDao productReviewDao;

    @Autowired
    private ProductRpcServer productRpcServer;

    @Autowired
    private Sequence sequence;

    @Override
    public long insert(ProductReview bean) throws Exception {
        bean.setId(sequence.nextId());
        return productReviewDao.insert(bean) ? bean.getId() : -1;
    }

    @Override
    public boolean deleteL(ProductReview bean) throws Exception {
        return productReviewDao.deleteL(bean);
    }

    @Override
    public boolean restore(ProductReview bean) throws Exception {
        return productReviewDao.restore(bean);
    }

    @Override
    public boolean deleteP(ProductReview bean) throws Exception {
        return productReviewDao.deleteP(bean);
    }

    @Override
    public boolean update(ProductReview bean) throws Exception {
        return productReviewDao.update(bean);
    }

    @Override
    public ProductReview select(ProductReview bean) throws Exception {
        return fill(productReviewDao.select(bean));
    }

    @Override
    public List<ProductReview> list(int page, int count, int tableIndex) throws Exception {
        return productReviewDao.list(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return productReviewDao.count(tableIndex);
    }

    @Override
    public List<ProductReview> listByDel(int page, int count, int tableIndex) throws Exception {
        return productReviewDao.listByDel(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByDel(int tableIndex) throws Exception {
        return productReviewDao.countByDel(tableIndex);
    }

    @Override
    public int clear(int tableIndex) throws Exception {
        return productReviewDao.clear(tableIndex);
    }

    @Override
    public List<ProductReview> listByProductId(long product_id, int page, int count, int tableIndex) throws Exception {
        return productReviewDao.listByProductId(product_id, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByProductId(long product_id, int tableIndex) throws Exception {
        return productReviewDao.countByProductId(product_id, tableIndex);
    }

    @Override
    public ProductReview fill(ProductReview bean) {
        try {
            Product product = productRpcServer.select(new Product(bean.getProduct_id()));

            bean.setProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
