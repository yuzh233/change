package me.cathub.change.admin.upms.web.controller;

import me.cathub.change.api.rpc.server.upms.ApplyRpcServer;
import me.cathub.change.api.rpc.server.upms.PermissionRpcServer;
import me.cathub.change.common.base.BaseAdminControllerImpl;
import me.cathub.change.upms.bean.Apply;
import me.cathub.change.upms.bean.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 权限模块 - 权限操作
 *
 * @author z.yu
 */
@Controller
@RequestMapping("/permission")
public class PermissionAdminController extends BaseAdminControllerImpl<Permission, PermissionRpcServer> {

    Logger logger = LoggerFactory.getLogger(PermissionAdminController.class);

    @Autowired
    private ApplyRpcServer applyRpcServer;

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
        //根据应用id、父级权限id查找对象
        if (permission.getApply() != null) {
            Apply apply = applyRpcServer.select(new Apply(permission.getApply().getId()), true);
            if (apply == null) {
                return false;
            }
            permission.setApply(apply);
        }
        if (permission.getParent() != null) {
            Permission parent = rpcService.select(new Permission(permission.getParent().getId()), true);
            permission.setParent(parent);
        }
        return rpcService.insert(permission) != -1;
    }

    @ModelAttribute
    @Override
    public void updateModelAttribute(@RequestParam(value = "id", required = false) Long id, Map<String, Object> map) throws Exception {
        if (id != null) {
            Permission permission = rpcService.select(new Permission(id), false);
            map.put("permission", permission);
        }
    }
}