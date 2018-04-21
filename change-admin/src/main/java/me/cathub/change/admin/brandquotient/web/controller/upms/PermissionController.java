package me.cathub.change.admin.brandquotient.web.controller.upms;

import me.cathub.change.api.rpc.server.upms.PermissionRpcServer;
import me.cathub.change.upms.bean.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionRpcServer permissionRpcServer;

    @RequestMapping("/insert")
    @ResponseBody
    public boolean insert(Permission permission) throws Exception {
        return permissionRpcServer.insert(permission);
    }

    @RequestMapping("/deleteL")
    @ResponseBody
    public boolean deleteL(Permission permission) throws Exception {
        return permissionRpcServer.deleteL(permission);
    }

    @RequestMapping("/deleteP")
    @ResponseBody
    public boolean deleteP(Permission permission) throws Exception {
        return permissionRpcServer.deleteP(permission);
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean update(Permission permission) throws Exception {
        return permissionRpcServer.update(permission);
    }

    @RequestMapping("/select")
    @ResponseBody
    public Permission select(Permission permission) throws Exception {
        return permissionRpcServer.select(permission);
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Permission> list(int page, int count) throws Exception {
        return permissionRpcServer.list(page, count, 0);
    }


}