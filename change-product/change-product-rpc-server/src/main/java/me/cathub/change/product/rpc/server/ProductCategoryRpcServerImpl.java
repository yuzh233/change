package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.ProductCategoryDao;
import me.cathub.change.api.rpc.server.product.ProductCategoryRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.common.bean.product.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryRpcServerImpl extends BaseRpcServerImpl<ProductCategory, ProductCategoryDao> implements ProductCategoryRpcServer {

    @Override
    public ProductCategory selectByName(String name, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return dao.selectByName(name, tableIndex);
        else
            return fill(dao.selectByName(name, tableIndex));
    }

    @Override
    public List<ProductCategory> childListById(long id, int page, int count, int tableIndex, boolean flag) throws Exception {
        return dao.childListById(id, page, count, tableIndex);
    }

    @Override
    public int childCountById(long id, int tableIndex) throws Exception {
        return dao.childCountById(id, tableIndex);
    }

    @Override
    public ProductCategory fill(ProductCategory bean) {
        return bean;
    }
}
