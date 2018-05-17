package me.cathub.change.admin.upms.web.controller;

import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.upms.bean.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 权限模块 - 角色操作
 *
 * @author zhangYu
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseControllerImpl<Role, RoleRpcServer> {

    @RequestMapping("/restores")
    @ResponseBody
    @Override
    public int restores(long[] ids) throws Exception {
        return rpcService.restores(ids, new Role());
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]")long[] ids, @RequestParam(value = "del_flag",required = false) boolean del_flag) throws Exception {
        return rpcService.deletes(ids, new Role(), !del_flag);
    }

    @ModelAttribute
    @Override
    public void updateModelAttribute(@RequestParam(value = "id",required = false)Long id, Map<String, Object> map) throws Exception {
        if(id!=null) {
            Role role = new Role();
            role.setId(id);
            role = select(role);
            map.put("role", role);
        }
    }
}
