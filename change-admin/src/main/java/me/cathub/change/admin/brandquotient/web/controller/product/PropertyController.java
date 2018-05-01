package me.cathub.change.admin.brandquotient.web.controller.product;

import me.cathub.change.api.rpc.server.product.PropertyRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.product.bean.Property;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 产品模块 - 属性
 */
@Controller
@RequestMapping("/property")
public class PropertyController extends BaseControllerImpl<Property, PropertyRpcServer> {
    @Override
    public boolean delete(long[] ids) throws Exception {

        return false;
    }

    @Override
    public void update_modelAttribute(Long id, Map<String, Object> map) throws Exception {

    }
}
