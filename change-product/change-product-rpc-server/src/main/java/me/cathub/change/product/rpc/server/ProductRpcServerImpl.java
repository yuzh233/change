package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.ProductDao;
import me.cathub.change.api.rpc.server.product.ProductCategoryRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.ProductCategory;
import me.cathub.change.user.bean.BrandQuotient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ProductRpcServerImpl implements ProductRpcServer {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductCategoryRpcServer productCategoryRpcServer;

    @Autowired
    private BrandQuotientRpcServer brandQuotientRpcServer;

    @Override
    public boolean insert(Product bean) throws Exception {
        return productDao.insert(bean);
    }

    @Override
    public boolean deleteL(Product bean) throws Exception {
        return productDao.deleteL(bean);
    }

    @Override
    public boolean restore(Product bean) throws Exception {
        return productDao.restore(bean);
    }

    @Override
    public boolean deleteP(Product bean) throws Exception {
        return productDao.deleteP(bean);
    }

    @Override
    public boolean update(Product bean) throws Exception {
        return productDao.update(bean);
    }

    @Override
    public Product select(Product bean) throws Exception {
        return fill(productDao.select(bean));
    }

    @Override
    public List<Product> list(int page, int count, int tableIndex) throws Exception {
        return productDao.list(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public long count(int tableIndex) throws Exception {
        return productDao.count(tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return productDao.count(tableIndex);
    }

    @Override
    public Product fill(Product bean) {
        try {
            bean.setProductCategory(productCategoryRpcServer.select(new ProductCategory(bean.getProductCategory_id())));
            bean.setBrandQuotient(brandQuotientRpcServer.select(new BrandQuotient(bean.getBrandQuotient_id())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
