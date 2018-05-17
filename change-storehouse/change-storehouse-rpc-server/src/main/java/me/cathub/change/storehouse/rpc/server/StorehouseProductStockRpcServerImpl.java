package me.cathub.change.storehouse.rpc.server;

import me.cathub.change.api.dao.storehouse.StorehouseProductStockDao;
import me.cathub.change.api.rpc.server.product.ProductCategoryRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseProductStockRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseRpcServer;
import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.ProductCategory;
import me.cathub.change.storehouse.bean.Storehouse;
import me.cathub.change.storehouse.bean.StorehouseProductStock;
import me.cathub.change.user.bean.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 仓库产品库存Rpc服务实现类
 *
 * @author cheng
 */
@Service
public class StorehouseProductStockRpcServerImpl extends BaseRpcServerImpl<StorehouseProductStock, StorehouseProductStockDao> implements StorehouseProductStockRpcServer {

    @Autowired
    private ProductRpcServer productRpcServer;

    @Autowired
    private StorehouseRpcServer storehouseRpcServer;

    @Autowired
    private ProductCategoryRpcServer productCategoryRpcServer;

    @Autowired
    private CompanyRpcServer companyRpcServer;

    @Override
    public StorehouseProductStock selectByStorehouseIdAndProductId(long storehouseId, long productId, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.selectByStorehouseIdAndProductId(storehouseId, productId, tableIndex);
        } else {
            return fill(dao.selectByStorehouseIdAndProductId(storehouseId, productId, tableIndex));
        }
    }

    @Override
    public List<StorehouseProductStock> listByStorehouseId(long storehouseId, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByStorehouseId(storehouseId, page, count, tableIndex);
        } else {
            return dao.listByStorehouseId(storehouseId, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
        }
    }

    @Override
    public int countByStorehouseId(long storehouseId, int tableIndex) throws Exception {
        return dao.countByStorehouseId(storehouseId, tableIndex);
    }

    @Override
    public List<StorehouseProductStock> listByProductId(long productId, int page, int count, int tableIndex, boolean flag) throws Exception {
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
    public List<StorehouseProductStock> listByStorehouseIdAndProductCategoryId(long storehouseId, long productCategoryId, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByStorehouseIdAndProductCategoryId(storehouseId, productCategoryId, page, count, tableIndex);
        } else {
            return dao.listByStorehouseIdAndProductCategoryId(storehouseId, productCategoryId, page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
    }

    @Override
    public int countByStorehouseIdAndProductCategoryId(long storehouseId, long productCategoryId, int tableIndex) throws Exception {
        return dao.countByStorehouseIdAndProductCategoryId(storehouseId, productCategoryId, tableIndex);
    }

    @Override
    public List<StorehouseProductStock> listByStorehouseIdAndCompanyId(long storehouseId, long companyId, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByStorehouseIdAndCompanyId(storehouseId, companyId, page, count, tableIndex);
        } else {
            return dao.listByStorehouseIdAndCompanyId(storehouseId, companyId, page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
    }

    @Override
    public int countByStorehouseIdAndCompanyId(long storehouseId, long companyId, int tableIndex) throws Exception {
        return dao.countByStorehouseIdAndCompanyId(storehouseId, companyId, tableIndex);
    }

    @Override
    public StorehouseProductStock fill(StorehouseProductStock bean) {
        try {
            Product product = productRpcServer.select(new Product(bean.getProductId()), true);
            Storehouse storehouse = storehouseRpcServer.select(new Storehouse(bean.getStorehouseId()), true);
            ProductCategory productCategory = productCategoryRpcServer.select(new ProductCategory(bean.getProductCategoryId()), true);
            Company company = companyRpcServer.select(new Company(bean.getCompanyId()), true);

            bean.setProduct(product);
            bean.setStorehouse(storehouse);
            bean.setProductCategory(productCategory);
            bean.setCompany(company);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
