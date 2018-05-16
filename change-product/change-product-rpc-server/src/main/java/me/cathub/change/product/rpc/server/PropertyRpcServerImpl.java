package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.PropertyDao;
import me.cathub.change.api.rpc.server.product.ProductCategoryRpcServer;
import me.cathub.change.api.rpc.server.product.PropertyRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.product.bean.ProductCategory;
import me.cathub.change.product.bean.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 属性Rpc服务实现类
 *
 * @author cheng
 */
@Service
public class PropertyRpcServerImpl extends BaseRpcServerImpl<Property, PropertyDao> implements PropertyRpcServer {

    @Autowired
    private ProductCategoryRpcServer productCategoryRpcServer;

    @Override
    public Property selectByName(String name, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.selectByName(name, tableIndex);
        } else {
            return fill(dao.selectByName(name, tableIndex));
        }
    }

    @Override
    public List<Property> listByProductCategoryId(long productCategoryId, int page, int count, int tableIndex, boolean flag) throws Exception {
        return dao.listByProductCategoryId(productCategoryId, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByProductCategoryId(long productCategoryId, int tableIndex) throws Exception {
        return dao.countByProductCategoryId(productCategoryId, tableIndex);
    }

    @Override
    public Property selectByNameAndProductCategory(String name, long productCategoryId, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.selectByNameAndProductCategory(name, productCategoryId, tableIndex);
        } else {
            return fill(dao.selectByNameAndProductCategory(name, productCategoryId, tableIndex));
        }
    }

    @Override
    public Property fill(Property bean) {
        try {
            ProductCategory productCategory = productCategoryRpcServer.select(new ProductCategory(bean.getProductCategoryId()), true);

            bean.setProductCategory(productCategory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
