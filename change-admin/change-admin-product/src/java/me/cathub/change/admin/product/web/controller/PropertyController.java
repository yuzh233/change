package me.cathub.change.admin.product.web.controller;

import me.cathub.change.api.rpc.server.product.ProductCategoryRpcServer;
import me.cathub.change.api.rpc.server.product.PropertyRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.common.bean.product.ProductCategory;
import me.cathub.change.common.bean.product.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 产品模块 - 属性
 */
@Controller
@RequestMapping("/property")
public class PropertyController extends BaseControllerImpl<Property, PropertyRpcServer> {
    @Autowired
    private ProductCategoryRpcServer productCategoryRpcServer;

    @Override
    public int restores(long[] ids) throws Exception {
        return 0;
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean del_flag) throws Exception {
        return rpcService.deletes(ids, new Property(), !del_flag);
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean update(@RequestBody Property property) throws Exception {
        Property bean = property;
        property = rpcService.select(property, false);
        if (bean.getName() != null) {
            property.setName(bean.getName());
        }
        //关联产品分类对象
        if (bean.getProductCategory() != null) {
            ProductCategory productCategory = productCategoryRpcServer.selectByName(bean.getProductCategory().getName(), 0, true);
            property.setProductCategory(productCategory);
        }
        return rpcService.update(property);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public boolean insert(Property property) throws Exception {
        if (property.getProductCategory() != null) {
            ProductCategory productCategory = productCategoryRpcServer.selectByName(property.getProductCategory().getName(), 0, true);
            if (productCategory != null) {
                property.setProductCategory(productCategory);
            }else {
                return false;
            }
        }
        return rpcService.insert(property) != -1;
    }
}
