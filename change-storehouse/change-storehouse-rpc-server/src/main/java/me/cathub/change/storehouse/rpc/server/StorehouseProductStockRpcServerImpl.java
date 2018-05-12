package me.cathub.change.storehouse.rpc.server;

import me.cathub.change.api.dao.storehouse.StorehouseProductStockDao;
import me.cathub.change.api.rpc.server.product.ProductCategoryRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseProductStockRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseRpcServer;
import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.common.bean.product.Product;
import me.cathub.change.common.bean.product.ProductCategory;
import me.cathub.change.common.bean.storehouse.Storehouse;
import me.cathub.change.common.bean.storehouse.StorehouseProductStock;
import me.cathub.change.common.bean.user.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

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
    public StorehouseProductStock selectByStorehouseIdAndProductId(long storehouse_id, long product_id, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return dao.selectByStorehouseIdAndProductId(storehouse_id, product_id, tableIndex);
        else
            return fill(dao.selectByStorehouseIdAndProductId(storehouse_id, product_id, tableIndex));
    }

    @Override
    public List<StorehouseProductStock> listByStorehouseId(long storehouse_id, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return dao.listByStorehouseId(storehouse_id, page, count, tableIndex);
        else
            return dao.listByStorehouseId(storehouse_id, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByStorehouseId(long storehouse_id, int tableIndex) throws Exception {
        return dao.countByStorehouseId(storehouse_id, tableIndex);
    }

    @Override
    public StorehouseProductStock fill(StorehouseProductStock bean) {
        try {
            Product product = productRpcServer.select(new Product(bean.getProduct_id()), true);
            Storehouse storehouse = storehouseRpcServer.select(new Storehouse(bean.getStorehouse_id()), true);
            ProductCategory productCategory = productCategoryRpcServer.select(new ProductCategory(bean.getProductCategory_id()), true);
            Company company = companyRpcServer.select(new Company(bean.getCompany_id()), true);

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
