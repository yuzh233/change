package me.cathub.change.admin.upms.web.controller;

import me.cathub.change.api.rpc.server.upms.PermissionRpcServer;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.common.base.BaseAdminControllerImpl;
import me.cathub.change.upms.bean.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 权限模块 - 权限操作
 *
 * @author zhangYu
 */
@Controller
@RequestMapping("/permission")
public class PermissionAdminController extends BaseAdminControllerImpl<Permission, PermissionRpcServer> {

    @Autowired
    private RoleRpcServer roleRpcServer;

    @RequestMapping("/restores")
    @ResponseBody
    @Override
    public int restores(long[] ids) throws Exception {
        return rpcService.restores(ids, new Permission());
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean del_flag) throws Exception {
        return rpcService.deletes(ids, new Permission(), !del_flag);
    }

    @RequestMapping("/insert")
    @ResponseBody
    @Override
    public boolean insert(Permission permission) throws Exception {
        return false;
    }
}