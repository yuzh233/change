package me.cathub.change.admin.brandquotient.web.controller.product;

import me.cathub.change.api.rpc.server.product.PropertyRpcRpcServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyRpcRpcServer propertyRpcServer;
}
