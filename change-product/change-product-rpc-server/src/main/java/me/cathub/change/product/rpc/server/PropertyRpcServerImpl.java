package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.PropertyCrud;
import me.cathub.change.api.rpc.server.product.ProductCategoryRpcServer;
import me.cathub.change.api.rpc.server.product.PropertyRpcServer;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.product.bean.ProductCategory;
import me.cathub.change.product.bean.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PropertyRpcServerImpl implements PropertyRpcServer {

    @Autowired
    private PropertyCrud propertyDao;

    @Autowired
    private ProductCategoryRpcServer productCategoryRpcServer;

    @Autowired
    private Sequence sequence;

    @Override
    public boolean insert(Property bean) throws Exception {
        bean.setId(sequence.nextId());
        return propertyDao.insert(bean);
    }

    @Override
    public boolean deleteL(Property bean) throws Exception {
        return propertyDao.deleteL(bean);
    }

    @Override
    public boolean restore(Property bean) throws Exception {
        return propertyDao.restore(bean);
    }

    @Override
    public boolean deleteP(Property bean) throws Exception {
        return propertyDao.deleteP(bean);
    }

    @Override
    public boolean update(Property bean) throws Exception {
        return propertyDao.update(bean);
    }

    @Override
    public Property select(Property bean) throws Exception {
        return fill(propertyDao.select(bean));
    }

    @Override
    public List<Property> list(int page, int count, int tableIndex) throws Exception {
        return propertyDao.list(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public long count(int tableIndex) throws Exception {
        return propertyDao.count(tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return propertyDao.count(tableIndex);
    }

    @Override
    public Property fill(Property bean) {
        try {
            ProductCategory productCategory = productCategoryRpcServer.select(new ProductCategory(bean.getProductCategory_id()));

            bean.setProductCategory(productCategory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
