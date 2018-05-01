package me.cathub.change.admin.brandquotient.web.controller.user;

import me.cathub.change.api.rpc.server.user.AdminRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.user.bean.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
public class AdminController extends BaseControllerImpl<Admin, AdminRpcServer>{

    /**
     * 删除/批量删除
     * @param ids 前台传入的数组对象，注意：这里要用long[] 接受 ，id太长了int[]接会报错。
     * @throws Exception
     */
    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestParam("ids[]") long[] ids) throws Exception {
        boolean flag = true;
        for (long id : ids) {
            Admin admin = new Admin();
            admin.setId(id);
            admin = getRpcService().select(admin,true);
            flag = getRpcService().deleteL(admin);//逻辑删除
        }
        return flag;
    }

    @Override
    public void update_modelAttribute(@RequestParam(value = "id",required = false)Long id, Map<String, Object> map) throws Exception {
        if(id!=null) {
            Admin admin = new Admin();
            admin.setId(id);
            admin = select(admin);
            map.put("admin", admin);
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean update(@ModelAttribute("admin") Admin bean) throws Exception {
        System.out.println(bean);
        return getRpcService().update(bean);
    }

}
