package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.PropertyValueCrud;
import me.cathub.change.api.rpc.server.product.ProductRpcRpcServer;
import me.cathub.change.api.rpc.server.product.PropertyRpcRpcServer;
import me.cathub.change.api.rpc.server.product.PropertyValueRpcRpcServer;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.Property;
import me.cathub.change.product.bean.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PropertyValueRpcRpcServerImpl implements PropertyValueRpcRpcServer {

    @Autowired
    private PropertyValueCrud propertyValueDao;

    @Autowired
    private PropertyRpcRpcServer propertyRpcServer;

    @Autowired
    private ProductRpcRpcServer productRpcServer;

    @Autowired
    private Sequence sequence;

    @Override
    public boolean insert(PropertyValue bean) throws Exception {
        bean.setId(sequence.nextId());
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
            Property property = propertyRpcServer.select(new Property(bean.getProduct_id()));
            Product product = productRpcServer.select(new Product(bean.getProduct_id()));

            bean.setProperty(property);
            bean.setProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
