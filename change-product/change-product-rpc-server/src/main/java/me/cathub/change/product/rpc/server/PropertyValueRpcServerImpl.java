package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.PropertyValueDao;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.api.rpc.server.product.PropertyRpcServer;
import me.cathub.change.api.rpc.server.product.PropertyValueRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.common.bean.product.Product;
import me.cathub.change.common.bean.product.Property;
import me.cathub.change.common.bean.product.PropertyKeyValue;
import me.cathub.change.common.bean.product.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PropertyValueRpcServerImpl extends BaseRpcServerImpl<PropertyValue, PropertyValueDao> implements PropertyValueRpcServer {

    @Autowired
    private PropertyRpcServer propertyRpcServer;

    @Autowired
    private ProductRpcServer productRpcServer;

    @Override
    public List<PropertyValue> listByProductId(long product_id, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return dao.listByProductId(product_id, page, count, tableIndex);
        else
            return dao.listByProductId(product_id, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByProductId(long product_id, int tableIndex) throws Exception {
        return dao.countByDel(tableIndex);
    }

    @Override
    public List<PropertyKeyValue> keyValueList(long product_id, int tableIndex) throws Exception {
        return dao.listByProductId(product_id, 0, Integer.MAX_VALUE, tableIndex).stream()
                .map(bean -> {
                    PropertyKeyValue keyValue = new PropertyKeyValue();
                    try {
                        String key = propertyRpcServer.select(new Property(bean.getProperty_id()), true).getName();
                        keyValue.setKey(key);
                        keyValue.setVal(bean.getValue());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return keyValue;
                })
                .collect(toList());
    }

    @Override
    public PropertyValue fill(PropertyValue bean) {
        try {
            Property property = propertyRpcServer.select(new Property(bean.getProperty_id()), true);
            Product product = productRpcServer.select(new Product(bean.getProduct_id()), true);

            bean.setProperty(property);
            bean.setProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
