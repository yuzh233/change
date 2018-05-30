package me.cathub.change.admin.user.web.controller;

import me.cathub.change.api.rpc.server.user.AdminRpcServer;
import me.cathub.change.common.base.BaseAdminControllerImpl;
import me.cathub.change.common.bean.PageResult;
import me.cathub.change.user.bean.Admin;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 用户模块 - 管理员
 *
 * @author zhangYu
 */
@Controller
@RequestMapping("/admin")
public class AdminManagerController extends BaseAdminControllerImpl<Admin, AdminRpcServer> {

    @RequestMapping("/restores")
    @ResponseBody
    @Override
    public int restores(long[] ids) throws Exception {
        return rpcService.restores(ids, new Admin());
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int deletes(@RequestParam("ids[]")long[] ids, @RequestParam(value = "del_flag",required = false)boolean delFlag) throws Exception {
        return rpcService.deletes(ids, new Admin(), !delFlag);
    }

    @ModelAttribute
    @Override
    public void updateModelAttribute(@RequestParam(value = "id",required = false)Long id, Map<String, Object> map) throws Exception {
        if(id!=null) {
            Admin admin = new Admin();
            admin.setId(id);
            admin = select(admin);
            //关联角色对象
            map.put("admin", admin);
        }
    }
}
