package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.PropertyValueDao;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.api.rpc.server.product.PropertyRpcServer;
import me.cathub.change.api.rpc.server.product.PropertyValueRpcServer;
import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.Property;
import me.cathub.change.product.bean.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PropertyValueRpcServerImpl implements PropertyValueRpcServer {

    @Autowired
    private PropertyValueDao propertyValueDao;

    @Autowired
    private PropertyRpcServer propertyRpcServer;

    @Autowired
    private ProductRpcServer productRpcServer;

    @Override
    public boolean insert(PropertyValue bean) throws Exception {
        return propertyValueDao.insert(bean);
    }

    @Override
    public boolean deleteL(PropertyValue bean) throws Exception {
        return propertyValueDao.deleteL(bean);
    }

    @Override
    public boolean restore(PropertyValue bean) throws Exception {
        return propertyValueDao.restore(bean);
    }

    @Override
    public boolean deleteP(PropertyValue bean) throws Exception {
        return propertyValueDao.deleteP(bean);
    }

    @Override
    public boolean update(PropertyValue bean) throws Exception {
        return propertyValueDao.update(bean);
    }

    @Override
    public PropertyValue select(PropertyValue bean) throws Exception {
        return fill(propertyValueDao.select(bean));
    }

    @Override
    public List<PropertyValue> list(int page, int count, int tableIndex) throws Exception {
        return propertyValueDao.list(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public long count(int tableIndex) throws Exception {
        return propertyValueDao.count(tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return propertyValueDao.count(tableIndex);
    }

    @Override
    public PropertyValue fill(PropertyValue bean) {
        try {
            bean.setProperty(propertyRpcServer.select(new Property(bean.getProduct_id())));
            bean.setProduct(productRpcServer.select(new Product(bean.getProduct_id())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
