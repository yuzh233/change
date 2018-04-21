package me.cathub.change.admin.brandquotient.web.controller.upms;

import me.cathub.change.api.rpc.server.upms.RoleRpcRpcServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleRpcRpcServer roleRpcServer;
}
