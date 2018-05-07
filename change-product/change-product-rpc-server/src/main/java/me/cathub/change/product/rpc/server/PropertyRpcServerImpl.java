package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.PropertyDao;
import me.cathub.change.api.rpc.server.product.ProductCategoryRpcServer;
import me.cathub.change.api.rpc.server.product.PropertyRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.common.bean.product.ProductCategory;
import me.cathub.change.common.bean.product.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PropertyRpcServerImpl extends BaseRpcServerImpl<Property, PropertyDao> implements PropertyRpcServer {

    @Autowired
    private ProductCategoryRpcServer productCategoryRpcServer;

    @Override
    public Property selectByName(String name, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return dao.selectByName(name, tableIndex);
        else
            return fill(dao.selectByName(name, tableIndex));
    }

    @Override
    public List<Property> listByProductCategoryId(long productCategory_id, int page, int count, int tableIndex, boolean flag) throws Exception {
        return dao.listByProductCategoryId(productCategory_id, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByProductCategoryId(long productCategory_id, int tableIndex) throws Exception {
        return dao.countByProductCategoryId(productCategory_id, tableIndex);
    }

    @Override
    public Property fill(Property bean) {
        try {
            ProductCategory productCategory = productCategoryRpcServer.select(new ProductCategory(bean.getProductCategory_id()), true);

            bean.setProductCategory(productCategory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
