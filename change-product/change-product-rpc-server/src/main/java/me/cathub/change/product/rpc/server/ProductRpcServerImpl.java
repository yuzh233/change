package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.ProductDao;
import me.cathub.change.api.rpc.server.product.ProductCategoryRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.ProductCategory;
import me.cathub.change.user.bean.BrandQuotient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 产品Rpc服务实现类
 *
 * @author cheng
 */
@Service
public class ProductRpcServerImpl extends BaseRpcServerImpl<Product, ProductDao> implements ProductRpcServer {

    @Autowired
    private ProductCategoryRpcServer productCategoryRpcServer;

    @Autowired
    private BrandQuotientRpcServer brandQuotientRpcServer;


    @Override
    public List<Product> listByBrandQuotientId(long brandQuotientId, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByBrandQuotientId(brandQuotientId, page, count, tableIndex);
        } else {
            return dao.listByBrandQuotientId(brandQuotientId, page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
    }

    @Override
    public int countByBrandQuotientId(long brandQuotientId, int tableIndex) throws Exception {
        return dao.countByBrandQuotientId(brandQuotientId, tableIndex);
    }

    @Override
    public List<Product> listByCompanyId(long companyId, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByCompanyId(companyId, page, count, tableIndex);
        } else {
            return dao.listByCompanyId(companyId, page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
    }

    @Override
    public int countByCompanyId(long companyId, int tableIndex) throws Exception {
        return dao.countByCompanyId(companyId, tableIndex);
    }

    @Override
    public List<Product> listByProductCategoryIdAndCompanyId(long productCategoryId, long companyId, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByProductCategoryIdAndCompanyId(productCategoryId, companyId, page, count, tableIndex);
        } else {
            return dao.listByProductCategoryIdAndCompanyId(productCategoryId, companyId, page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
    }

    @Override
    public int countByProductCategoryIdAndCompanyId(long productCategoryId, long companyId, int tableIndex) throws Exception {
        return dao.countByProductCategoryIdAndCompanyId(productCategoryId, companyId, tableIndex);
    }

    @Override
    public List<Product> listByProductCategoryId(long productCategoryId, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByProductCategoryId(productCategoryId, page, count, tableIndex);
        } else {
            return dao.listByProductCategoryId(productCategoryId, page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
    }

    @Override
    public int countByProductCategoryId(long productCategoryId, int tableIndex) throws Exception {
        return dao.countByProductCategoryId(productCategoryId, tableIndex);
    }

    @Override
    public List<Product> listByName(String name, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByName(name, page, count, tableIndex);
        } else {
            return dao.listByName(name, page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
    }

    @Override
    public int countByName(String name, int tableIndex) throws Exception {
        return dao.countByName(name ,tableIndex);
    }

    @Override
    public List<Product> listBySearch(String keyName, float minPrice, float maxPrice, String[] sorts, boolean desc, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listBySearch(keyName, minPrice, maxPrice, sorts, desc, page, count, tableIndex);
        } else {
            return dao.listBySearch(keyName, minPrice, maxPrice, sorts, desc, page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
    }

    @Override
    public int countBySearch(String keyName, float minPrice, float maxPrice, int tableIndex) throws Exception {
        return dao.countBySearch(keyName, minPrice, maxPrice, tableIndex);
    }

    @Override
    public Product fill(Product bean) {
        try {
            ProductCategory productCategory = productCategoryRpcServer.select(new ProductCategory(bean.getProductCategoryId()), true);
            BrandQuotient brandQuotient = brandQuotientRpcServer.select(new BrandQuotient(bean.getBrandQuotientId()), true);

            bean.setProductCategory(productCategory);
            bean.setBrandQuotient(brandQuotient);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
