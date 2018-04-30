package me.cathub.change.admin.brandquotient.web.controller.product;

import me.cathub.change.api.rpc.server.product.PropertyValueRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.product.bean.PropertyValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 产品模块 - 属性值
 */
@Controller
@RequestMapping("/propertyValue")
public class PropertyValueRpcController extends BaseControllerImpl<PropertyValue, PropertyValueRpcServer> {
}
