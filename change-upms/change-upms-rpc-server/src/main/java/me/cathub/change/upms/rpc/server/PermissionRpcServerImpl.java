package me.cathub.change.upms.rpc.server;

import me.cathub.change.api.dao.upms.PermissionDao;
import me.cathub.change.api.rpc.server.upms.PermissionRpcServer;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.upms.bean.Permission;
import me.cathub.change.upms.bean.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PermissionRpcServerImpl extends BaseRpcServerImpl<Permission, PermissionDao> implements PermissionRpcServer {

    @Autowired
    private RoleRpcServer roleRpcServer;

    @Override
    public Permission selectByName(String name, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return dao.selectByName(name, tableIndex);
        else
            return fill(dao.selectByName(name, tableIndex));
    }

    @Override
    public List<Permission> listByRoleId(long role_id, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return dao.listByRoleId(role_id, page, count, tableIndex);
        else
            return dao.listByRoleId(role_id, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByRoleId(long role_id, int tableIndex) throws Exception {
        return dao.countByRoleId(role_id, tableIndex);
    }

    @Override
    public Permission fill(Permission bean) {
        try {
            Role role = roleRpcServer.select(new Role(bean.getRole_id()), true);
            bean.setRole(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
