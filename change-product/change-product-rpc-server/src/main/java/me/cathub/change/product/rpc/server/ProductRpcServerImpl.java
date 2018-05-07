package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.ProductDao;
import me.cathub.change.api.rpc.server.product.ProductCategoryRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.common.bean.product.Product;
import me.cathub.change.common.bean.product.ProductCategory;
import me.cathub.change.common.bean.user.BrandQuotient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ProductRpcServerImpl extends BaseRpcServerImpl<Product, ProductDao> implements ProductRpcServer {

    @Autowired
    private ProductCategoryRpcServer productCategoryRpcServer;

    @Autowired
    private BrandQuotientRpcServer brandQuotientRpcServer;

    @Override
    public Product selectByName(String name, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return dao.selectByName(name, tableIndex);
        else
            return fill(dao.selectByName(name, tableIndex));
    }

    @Override
    public List<Product> listByBrandQuotientId(long brandQuotient_id, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return dao.listByBrandQuotientId(brandQuotient_id, page, count, tableIndex);
        else
            return dao.listByBrandQuotientId(brandQuotient_id, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByBrandQuotientId(long brandQuotient_id, int tableIndex) throws Exception {
        return dao.countByBrandQuotientId(brandQuotient_id, tableIndex);
    }

    @Override
    public List<Product> listByProductCategoryIdAndBrandQuotientId(long productCategory_id, long brandQuotient_id, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return dao.listByProductCategoryIdAndBrandQuotientId(productCategory_id, brandQuotient_id, page, count, tableIndex);
        else
            return dao.listByProductCategoryIdAndBrandQuotientId(productCategory_id, brandQuotient_id, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByProductCategoryIdAndBrandQuotientId(long productCategory_id, long brandQuotient_id, int tableIndex) throws Exception {
        return dao.countByProductCategoryIdAndBrandQuotientId(productCategory_id, brandQuotient_id, tableIndex);
    }

    @Override
    public List<Product> listByProductCategoryId(long productCategory_id, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return dao.listByProductCategoryId(productCategory_id, page, count, tableIndex);
        else
            return dao.listByProductCategoryId(productCategory_id, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByProductCategoryId(long productCategory_id, int tableIndex) throws Exception {
        return dao.countByProductCategoryId(productCategory_id, tableIndex);
    }

    @Override
    public Product fill(Product bean) {
        try {
            ProductCategory productCategory = productCategoryRpcServer.select(new ProductCategory(bean.getProductCategory_id()), true);
            BrandQuotient brandQuotient = brandQuotientRpcServer.select(new BrandQuotient(bean.getBrandQuotient_id()), true);

            bean.setProductCategory(productCategory);
            bean.setBrandQuotient(brandQuotient);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
