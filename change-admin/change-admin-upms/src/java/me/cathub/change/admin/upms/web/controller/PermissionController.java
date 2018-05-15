package me.cathub.change.admin.upms.web.controller;

import me.cathub.change.api.rpc.server.upms.PermissionRpcServer;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.common.bean.upms.Permission;
import me.cathub.change.common.bean.upms.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 权限模块 - 权限操作
 */
@Controller
@RequestMapping("/permission")
public class PermissionController extends BaseControllerImpl<Permission, PermissionRpcServer> {

    @Autowired
    private RoleRpcServer roleRpcServer;

    @Override
    public int restores(long[] ids) throws Exception {
        return 0;
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]") long[] ids, @RequestParam(value = "del_flag", required = false) boolean del_flag) throws Exception {
        return rpcService.deletes(ids, new Permission(), !del_flag);
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean update(@RequestBody Permission bean) throws Exception {
        //暂存角色对象
        Role role = bean.getRole();
        //数据库获取完整数据
        Permission p2 = rpcService.select(bean,true);
        if(bean.getName()!=null){
            //覆盖数据库中字段
            p2.setName(bean.getName());
        }
        if(role!=null){
            //如果用户填写了角色字段 -> 根据角色名查找到角色对象赋值到需要修改的权限对象
            role = roleRpcServer.selectByName(role.getName(),0,true);
            p2.setRole(role);
        }else if(p2.getRole_id()!=0){
            //如果用户没有填写角色字段 -> 根据数据库中查找到的权限对象中的 role_id 字段查找原来的角色对象并重新赋值到需要修改的权限对象
            role = roleRpcServer.select(new Role(p2.getRole_id()),true);
            p2.setRole(role);
        }
        return rpcService.update(p2);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public boolean insert(Permission permission) throws Exception {
        //查询对应的角色是否存在
        String roleName = permission.getRole().getName();
        Role role = roleRpcServer.selectByName(roleName, 0, true);
        if (role != null) {
            permission.setRole(role);
            return rpcService.insert(permission) != -1;
        }
        return false;
    }
}