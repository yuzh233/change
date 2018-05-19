package me.cathub.change.admin.product.web.controller;

import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.api.rpc.server.product.PropertyRpcServer;
import me.cathub.change.api.rpc.server.product.PropertyValueRpcServer;
import me.cathub.change.common.base.BaseAdminControllerImpl;
import me.cathub.change.product.bean.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 产品模块 - 属性值
 *
 * @author zhang
 */
@Controller
@RequestMapping("/propertyValue")
public class PropertyValueRpcAdminController extends BaseAdminControllerImpl<PropertyValue, PropertyValueRpcServer> {

    @Autowired
    private ProductRpcServer productRpcServer;

    @Autowired
    private PropertyRpcServer propertyRpcServer;

    @RequestMapping("/restores")
    @ResponseBody
    @Override
    public int restores(long[] ids) throws Exception {
        return rpcService.restores(ids, new PropertyValue());
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean del_flag) throws Exception {
        return rpcService.deletes(ids, new PropertyValue(), !del_flag);
    }
}
