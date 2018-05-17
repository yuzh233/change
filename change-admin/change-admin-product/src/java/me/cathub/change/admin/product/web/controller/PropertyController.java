package me.cathub.change.admin.product.web.controller;

import me.cathub.change.api.rpc.server.product.ProductCategoryRpcServer;
import me.cathub.change.api.rpc.server.product.PropertyRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.product.bean.ProductCategory;
import me.cathub.change.product.bean.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 产品模块 - 属性
 *
 * @author zhang
 */
@Controller
@RequestMapping("/property")
public class PropertyController extends BaseControllerImpl<Property, PropertyRpcServer> {

    @Autowired
    private ProductCategoryRpcServer productCategoryRpcServer;

    @RequestMapping("/restores")
    @ResponseBody
    @Override
    public int restores(long[] ids) throws Exception {
        return rpcService.restores(ids, new Property());
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean del_flag) throws Exception {
        return rpcService.deletes(ids, new Property(), !del_flag);
    }


    @RequestMapping("/insert")
    @ResponseBody
    @Override
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
