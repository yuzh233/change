package me.cathub.change.admin.user.web.controller;

import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.api.rpc.server.user.AdminRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.common.bean.upms.Role;
import me.cathub.change.common.bean.user.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 用户模块下的管理crud
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseControllerImpl<Admin, AdminRpcServer> {
    @Autowired
    private RoleRpcServer roleRpcServer;

    /**
     * 删除/批量删除
     * @param ids
     * @param del_flag true 逻辑删除 false 物理删除
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]")long[] ids, @RequestParam(value = "del_flag",required = false)boolean del_flag) throws Exception {
//        Admin bean = null;
//        for (long id : ids) {
//            bean = new Admin();
//            bean.setId(id);
//            rpcService.deleteL(bean);//逻辑删除
//        }
//        return 0;
        return rpcService.deletes(ids, new Admin(), !del_flag);
    }

    @Override
    public int restores(long[] ids) throws Exception {
        return rpcService.restores(ids, new Admin());
    }

    @ModelAttribute
    @Override
    public void update_modelAttribute(@RequestParam(value = "id",required = false)Long id, Map<String, Object> map) throws Exception {
        if(id!=null) {
            Admin admin = new Admin();
            admin.setId(id);
            admin = select(admin);
            //关联角色对象
            admin.setRole(roleRpcServer.select(new Role(admin.getRole_id()),true));
            map.put("admin", admin);
        }
    }
}
