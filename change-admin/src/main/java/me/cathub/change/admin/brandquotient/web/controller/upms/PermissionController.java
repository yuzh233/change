package me.cathub.change.admin.brandquotient.web.controller.upms;

import me.cathub.change.api.rpc.server.upms.PermissionRpcServer;
import me.cathub.change.upms.bean.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionRpcServer permissionRpcServer;

    @RequestMapping("/select")
    @ResponseBody
    public Permission select(Permission permission) throws Exception {
        return permissionRpcServer.select(permission);
    }
}
