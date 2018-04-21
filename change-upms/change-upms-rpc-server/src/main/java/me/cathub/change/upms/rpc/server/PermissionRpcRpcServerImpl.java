package me.cathub.change.upms.rpc.server;

import me.cathub.change.api.dao.upms.PermissionCrud;
import me.cathub.change.api.rpc.server.upms.PermissionRpcRpcServer;
import me.cathub.change.api.rpc.server.upms.RoleRpcRpcServer;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.upms.bean.Permission;
import me.cathub.change.upms.bean.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PermissionRpcRpcServerImpl implements PermissionRpcRpcServer {

    @Autowired
    private PermissionCrud permissionDao;

    @Autowired
    private RoleRpcRpcServer roleRpcServer;

    @Autowired
    private Sequence sequence;

    @Override
    public boolean insert(Permission bean) throws Exception {
        bean.setId(sequence.nextId());
        return permissionDao.insert(bean);
    }

    @Override
    public boolean deleteL(Permission bean) throws Exception {
        return permissionDao.deleteL(bean);
    }

    @Override
    public boolean restore(Permission bean) throws Exception {
        return permissionDao.restore(bean);
    }

    @Override
    public boolean deleteP(Permission bean) throws Exception {
        return permissionDao.deleteP(bean);
    }

    @Override
    public boolean update(Permission bean) throws Exception {
        return permissionDao.update(bean);
    }

    @Override
    public Permission select(Permission bean) throws Exception {
        return fill(permissionDao.select(bean));
    }

    @Override
    public List<Permission> list(int page, int count, int tableIndex) throws Exception {
        return permissionDao.list(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public long count(int tableIndex) throws Exception {
        return permissionDao.count(tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return permissionDao.count(tableIndex);
    }

    @Override
    public Permission fill(Permission bean) {
        try {
            Role role = roleRpcServer.select(new Role(bean.getRole_id()));
            bean.setRole(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
