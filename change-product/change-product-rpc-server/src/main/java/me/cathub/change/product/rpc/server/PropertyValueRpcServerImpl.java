package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.PropertyValueDao;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.api.rpc.server.product.PropertyRpcServer;
import me.cathub.change.api.rpc.server.product.PropertyValueRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.Property;
import me.cathub.change.product.bean.PropertyKeyValue;
import me.cathub.change.product.bean.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 属性值Rpc服务实现类
 *
 * @author cheng
 */
@Service
public class PropertyValueRpcServerImpl extends BaseRpcServerImpl<PropertyValue, PropertyValueDao> implements PropertyValueRpcServer {

    @Autowired
    private PropertyRpcServer propertyRpcServer;

    @Autowired
    private ProductRpcServer productRpcServer;

    @Override
    public List<PropertyValue> listByProductId(long productId, int page, int count, int tableIndex, boolean flag) throws Exception {
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
        return dao.countByDel(tableIndex);
    }

    @Override
    public List<PropertyKeyValue> keyValueList(long productId, int tableIndex) throws Exception {
        return dao.listByProductId(productId, 0, Integer.MAX_VALUE, tableIndex).stream()
                .map(bean -> {
                    PropertyKeyValue keyValue = new PropertyKeyValue();
                    try {
                        String key = propertyRpcServer.select(new Property(bean.getPropertyId()), true).getName();
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
            Property property = propertyRpcServer.select(new Property(bean.getPropertyId()), true);
            Product product = productRpcServer.select(new Product(bean.getProductId()), true);

            bean.setProperty(property);
            bean.setProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
