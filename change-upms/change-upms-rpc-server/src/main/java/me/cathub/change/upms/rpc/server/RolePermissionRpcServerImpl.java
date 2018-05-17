package me.cathub.change.upms.rpc.server;

import me.cathub.change.api.dao.upms.RolePermissionDao;
import me.cathub.change.api.rpc.server.upms.ApplyRpcServer;
import me.cathub.change.api.rpc.server.upms.PermissionRpcServer;
import me.cathub.change.api.rpc.server.upms.RolePermissionRpcServer;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.upms.bean.Apply;
import me.cathub.change.upms.bean.Permission;
import me.cathub.change.upms.bean.Role;
import me.cathub.change.upms.bean.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 角色权限Rpc服务实现类
 *
 * @author cheng
 */
@Service
public class RolePermissionRpcServerImpl extends BaseRpcServerImpl<RolePermission, RolePermissionDao> implements RolePermissionRpcServer {

    @Autowired
    private PermissionRpcServer permissionRpcServer;

    @Autowired
    private RoleRpcServer roleRpcServer;

    @Autowired
    private ApplyRpcServer applyRpcServer;

    @Override
    public List<RolePermission> listByRoleIdAndApplyId(long roleId, long applyId, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByRoleIdAndApplyId(roleId, applyId, page, count, tableIndex);
        } else {
            return dao.listByRoleIdAndApplyId(roleId, applyId, page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
    }

    @Override
    public int countByRoleIdAndApplyId(long roleId, long applyId, int tableIndex) throws Exception {
        return dao.countByRoleIdAndApplyId(roleId, applyId, tableIndex);
    }

    @Override
    public List<RolePermission> listByRoleId(long roleId, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByRoleId(roleId, page, count, tableIndex);
        } else {
            return dao.listByRoleId(roleId, page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
    }

    @Override
    public int countByRoleId(long roleId, int tableIndex) throws Exception {
        return dao.countByRoleId(roleId, tableIndex);
    }

    @Override
    public RolePermission fill(RolePermission bean) {
        try {
            Role role = roleRpcServer.select(new Role(bean.getRoleId()), true);
            Apply apply = applyRpcServer.select(new Apply(bean.getApplyId()), true);
            Permission permission = permissionRpcServer.select(new Permission(bean.getPermissionId()), true);

            bean.setRole(role);
            bean.setApply(apply);
            bean.setPermission(permission);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
