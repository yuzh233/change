package me.cathub.change.admin.upms.web.controller;

import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.api.rpc.server.upms.UserRoleRpcServer;
import me.cathub.change.api.rpc.server.user.UserSelectRpcServer;
import me.cathub.change.common.base.BaseAdminControllerImpl;
import me.cathub.change.common.bean.User;
import me.cathub.change.upms.bean.Role;
import me.cathub.change.upms.bean.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: z.yu
 * @DateTime: 2018/05/20 0:04
 * @Description:
 */
@Controller
@RequestMapping("/userRole")
public class UserRoleAdminController extends BaseAdminControllerImpl<UserRole, UserRoleRpcServer> {

    @Autowired
    private UserSelectRpcServer userSelectRpcServer;

    @Autowired
    private RoleRpcServer roleRpcServer;

    @RequestMapping("/insert")
    @ResponseBody
    @Override
    public boolean insert(UserRole userRole) throws Exception {
        //根据用户ID、角色ID关联对象
        if (userRole.getUser() != null) {
            User user = userSelectRpcServer.select(userRole.getUser().getId(),true, 0, userRole.getType());
            if (user == null) {
                return false;
            }
            userRole.setUser(user);
        }
        if (userRole.getRole() != null) {
            Role role = roleRpcServer.select(new Role(userRole.getRole().getId()), true);
            if (role == null) {
                return false;
            }
            userRole.setRole(role);
        }
        return rpcService.insert(userRole) != -1;
    }

    @RequestMapping("/update")
    @ResponseBody
    @Override
    public boolean update(@RequestBody UserRole userRole) throws Exception {
        UserRole bean = rpcService.select(userRole, false);
        if (userRole.getUser() != null) {
            User user = userSelectRpcServer.select(userRole.getUser().getId(), true, 0, userRole.getType());
            if(user == null){
                return false;
            }
            bean.setUser(user);
        }
        if (userRole.getRole() != null) {
            bean.setRole(roleRpcServer.select(new Role(userRole.getRole().getId()), true));
        }
        if ((Integer) userRole.getType() != null) {
            bean.setType(userRole.getType());
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
        return rpcService.deletes(ids, new UserRole(), !delFlag);
    }
}
