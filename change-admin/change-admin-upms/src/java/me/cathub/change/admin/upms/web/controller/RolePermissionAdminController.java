package me.cathub.change.admin.upms.web.controller;

import me.cathub.change.api.rpc.server.upms.ApplyRpcServer;
import me.cathub.change.api.rpc.server.upms.PermissionRpcServer;
import me.cathub.change.api.rpc.server.upms.RolePermissionRpcServer;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.common.base.BaseAdminControllerImpl;
import me.cathub.change.upms.bean.Apply;
import me.cathub.change.upms.bean.Permission;
import me.cathub.change.upms.bean.Role;
import me.cathub.change.upms.bean.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: z.yu
 * DateTime: 2018-05-19 23:33
 * Description: 角色权限控制器
 */
@Controller
@RequestMapping("/rolePermission")
public class RolePermissionAdminController extends BaseAdminControllerImpl<RolePermission, RolePermissionRpcServer> {

    @Autowired
    private RoleRpcServer roleRpcServer;

    @Autowired
    private ApplyRpcServer applyRpcServer;

    @Autowired
    private PermissionRpcServer permissionRpcServer;

    @RequestMapping("/insert")
    @ResponseBody
    @Override
    public boolean insert(RolePermission rolePermission) throws Exception {
        //根据角色ID、应用ID、权限ID关联对象
        if (rolePermission.getRole() != null) {
            Role role = roleRpcServer.select(new Role(rolePermission.getRole().getId()), true);
            if (role == null) {
                return false;
            }
            rolePermission.setRole(role);
        }
        if (rolePermission.getApply() != null) {
            Apply apply = applyRpcServer.select(new Apply(rolePermission.getApply().getId()), true);
            if (apply == null) {
                return false;
            }
            rolePermission.setApply(apply);
        }
        if (rolePermission.getPermission() != null) {
            Permission permission = permissionRpcServer.select(new Permission(rolePermission.getPermission().getId()), true);
            if (permission == null) {
                return false;
            }
            rolePermission.setPermission(permission);
        }
        return rpcService.insert(rolePermission) != -1;
    }

    @RequestMapping("/update")
    @ResponseBody
    @Override
    public boolean update(@RequestBody RolePermission rolePermission) throws Exception {
        RolePermission bean = rpcService.select(rolePermission, false);
        if (rolePermission.getRole() != null) {
            bean.setRole(roleRpcServer.select(new Role(rolePermission.getRole().getId()), true));
        }
        if (rolePermission.getApply() != null) {
            bean.setApply(applyRpcServer.select(new Apply(rolePermission.getApply().getId()), true));
        }
        if (rolePermission.getPermission() != null) {
            bean.setPermission(permissionRpcServer.select(new Permission(rolePermission.getPermission().getId()), true));
        }
        return rpcService.update(bean);
    }

    @Override
    public int restores(long[] ids) throws Exception {
        return 0;
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean delFlag) throws Exception {
        return rpcService.deletes(ids, new RolePermission(), !delFlag);
    }
}
