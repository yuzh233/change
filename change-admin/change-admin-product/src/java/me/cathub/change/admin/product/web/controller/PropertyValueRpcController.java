package me.cathub.change.admin.product.web.controller;

import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.api.rpc.server.product.PropertyRpcServer;
import me.cathub.change.api.rpc.server.product.PropertyValueRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.common.bean.product.Product;
import me.cathub.change.common.bean.product.Property;
import me.cathub.change.common.bean.product.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 产品模块 - 属性值
 */
@Controller
@RequestMapping("/propertyValue")
public class PropertyValueRpcController extends BaseControllerImpl<PropertyValue, PropertyValueRpcServer> {
    @Autowired
    private ProductRpcServer productRpcServer;
    @Autowired
    private PropertyRpcServer propertyRpcServer;

    @Override
    public int restores(long[] ids) throws Exception {
        return 0;
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean del_flag) throws Exception {
        return rpcService.deletes(ids, new PropertyValue(), !del_flag);
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean update(@RequestBody PropertyValue propertyValue) throws Exception {
        PropertyValue bean = propertyValue;
        propertyValue = rpcService.select(propertyValue, false);
        if (bean.getValue() != null) {
            propertyValue.setValue(bean.getValue());
        }
        if (bean.getProduct() != null) {
            Product product = productRpcServer.select(new Product(bean.getProduct().getId()), true);
            if (product == null) {
                return false;
            }
            propertyValue.setProduct(product);
        }
        if (bean.getProperty() != null) {
            Property property = propertyRpcServer.select(new Property(bean.getProperty().getId()), true);
            if (property == null) {
                return false;
            }
            propertyValue.setProperty(property);
        }
        return rpcService.update(propertyValue);
    }
}
