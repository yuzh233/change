package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.PropertyValueDao;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.api.rpc.server.product.PropertyRpcServer;
import me.cathub.change.api.rpc.server.product.PropertyValueRpcServer;
import me.cathub.change.common.tool.Sequence;
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

    @Autowired
    private Sequence sequence;

    @Override
    public long insert(PropertyValue bean) throws Exception {
        bean.setId(sequence.nextId());
        return propertyValueDao.insert(bean) ? bean.getId() : -1;
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
    public PropertyValue select(PropertyValue bean, boolean flag) throws Exception {
        if (flag)
            return propertyValueDao.select(bean);
        else
            return fill(propertyValueDao.select(bean));
    }

    @Override
    public List<PropertyValue> list(int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return propertyValueDao.list(page, count, tableIndex);
        else
            return propertyValueDao.list(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return propertyValueDao.count(tableIndex);
    }

    @Override
    public List<PropertyValue> listByDel(int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return propertyValueDao.listByDel(page, count, tableIndex);
        else
            return propertyValueDao.listByDel(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByDel(int tableIndex) throws Exception {
        return propertyValueDao.countByDel(tableIndex);
    }

    @Override
    public int clear(int tableIndex) throws Exception {
        return propertyValueDao.count(tableIndex);
    }

    @Override
    public List<PropertyValue> listByProductId(long product_id, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return propertyValueDao.listByProductId(product_id, page, count, tableIndex);
        else
            return propertyValueDao.listByProductId(product_id, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByProductId(long product_id, int tableIndex) throws Exception {
        return propertyValueDao.countByDel(tableIndex);
    }

    @Override
    public PropertyValue fill(PropertyValue bean) {
        try {
            Property property = propertyRpcServer.select(new Property(bean.getProduct_id()), true);
            Product product = productRpcServer.select(new Product(bean.getProduct_id()), true);

            bean.setProperty(property);
            bean.setProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
