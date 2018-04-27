package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.ProductDao;
import me.cathub.change.api.rpc.server.product.ProductCategoryRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.common.tool.Sequence;
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

    @Autowired
    private Sequence sequence;

    @Override
    public boolean insert(Product bean) throws Exception {
        bean.setId(sequence.nextId());
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
    public int count(int tableIndex) throws Exception {
        return productDao.count(tableIndex);
    }

    @Override
    public List<Product> listByDel(int page, int count, int tableIndex) throws Exception {
        return productDao.listByDel(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByDel(int tableIndex) throws Exception {
        return productDao.countByDel(tableIndex);
    }

    @Override
    public int clear(int tableIndex) throws Exception {
        return productDao.count(tableIndex);
    }

    @Override
    public Product selectByName(String name, int tableIndex) throws Exception {
        return fill(productDao.selectByName(name, tableIndex));
    }

    @Override
    public List<Product> listByBrandQuotientId(long brandQuotient_id, int page, int count, int tableIndex) throws Exception {
        return productDao.listByBrandQuotientId(brandQuotient_id, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByBrandQuotientId(long brandQuotient_id, int tableIndex) throws Exception {
        return productDao.countByBrandQuotientId(brandQuotient_id, tableIndex);
    }

    @Override
    public List<Product> listByProductCategoryIdAndBrandQuotientId(long productCategory_id, long brandQuotient_id, int page, int count, int tableIndex) throws Exception {
        return productDao.listByProductCategoryIdAndBrandQuotientId(productCategory_id, brandQuotient_id, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByProductCategoryIdAndBrandQuotientId(long productCategory_id, long brandQuotient_id, int tableIndex) throws Exception {
        return productDao.countByProductCategoryIdAndBrandQuotientId(productCategory_id, brandQuotient_id, tableIndex);
    }

    @Override
    public List<Product> listByProductCategoryId(long productCategory_id, int page, int count, int tableIndex) throws Exception {
        return productDao.listByProductCategoryId(productCategory_id, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByProductCategoryId(long productCategory_id, int tableIndex) throws Exception {
        return productDao.countByProductCategoryId(productCategory_id, tableIndex);
    }

    @Override
    public Product fill(Product bean) {
        try {
            ProductCategory productCategory = productCategoryRpcServer.select(new ProductCategory(bean.getProductCategory_id()));
            BrandQuotient brandQuotient = brandQuotientRpcServer.select(new BrandQuotient(bean.getBrandQuotient_id()));

            bean.setProductCategory(productCategory);
            bean.setBrandQuotient(brandQuotient);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
