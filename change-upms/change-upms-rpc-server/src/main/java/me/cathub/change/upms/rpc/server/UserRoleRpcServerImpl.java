package me.cathub.change.upms.rpc.server;

import me.cathub.change.api.dao.upms.UserRoleDao;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.api.rpc.server.upms.UserRoleRpcServer;
import me.cathub.change.api.rpc.server.user.UserSelectRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.common.bean.User;
import me.cathub.change.upms.bean.Role;
import me.cathub.change.upms.bean.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 用户角色Rpc服务实现类
 *
 * @author cheng
 */
@Service
public class UserRoleRpcServerImpl extends BaseRpcServerImpl<UserRole, UserRoleDao> implements UserRoleRpcServer {

    @Autowired
    private RoleRpcServer roleRpcServer;

    @Autowired
    private UserSelectRpcServer userSelectRpcServer;

    @Override
    public List<UserRole> listByUserId(long userId, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByUserId(userId, page, count, tableIndex);
        } else {
            return dao.listByUserId(userId, count, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
    }

    @Override
    public int countByUserId(long userId, int tableIndex) throws Exception {
        return dao.countByUserId(userId, tableIndex);
    }

    @Override
    public List<UserRole> listByRoleId(long roleId, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByRoleId(roleId, page, count, tableIndex);
        } else {
            return dao.listByRoleId(roleId, count, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
    }

    @Override
    public int countByRoleId(long roleId, int tableIndex) throws Exception {
        return dao.countByRoleId(roleId, tableIndex);
    }

    @Override
    public UserRole fill(UserRole bean) {

        try {
            Role role = roleRpcServer.select(new Role(bean.getRoleId()), true);
            User user = userSelectRpcServer.select(bean.getUserId(), true, bean.getType());

            bean.setRole(role);
            bean.setUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
