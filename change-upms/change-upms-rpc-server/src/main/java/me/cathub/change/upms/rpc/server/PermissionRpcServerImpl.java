package me.cathub.change.upms.rpc.server;

import me.cathub.change.api.dao.upms.PermissionDao;
import me.cathub.change.api.rpc.server.upms.ApplyRpcServer;
import me.cathub.change.api.rpc.server.upms.PermissionRpcServer;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.upms.bean.Apply;
import me.cathub.change.upms.bean.Permission;
import me.cathub.change.upms.bean.Role;
import org.springframework.beans.AbstractPropertyAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 授权Rpc服务实现类
 *
 * @author cheng
 */
@Service
public class PermissionRpcServerImpl extends BaseRpcServerImpl<Permission, PermissionDao> implements PermissionRpcServer {

    @Autowired
    private ApplyRpcServer applyRpcServer;

    @Override
    public Permission selectByName(String name, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.selectByName(name, tableIndex);
        } else {
            return fill(dao.selectByName(name, tableIndex));
        }
    }

    @Override
    public List<Permission> listByApplyId(long applyId, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByApplyId(applyId, page, count, tableIndex);
        } else {
            return dao.listByApplyId(applyId, page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
    }

    @Override
    public int countByApplyId(long applyId, int tableIndex) throws Exception {
        return dao.countByApplyId(applyId, tableIndex);
    }

    @Override
    public List<Permission> childListById(long id, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.childListById(id, page, count, tableIndex);
        } else {
            return dao.childListById(id, page, count, tableIndex).stream()
                    .map(bean -> fill(bean))
                    .collect(toList());
        }
    }

    @Override
    public int childCountById(long id, int tableIndex) throws Exception {
        return dao.childCountById(id, tableIndex);
    }

    @Override
    public Permission fill(Permission bean) {
        try {
            Apply apply = applyRpcServer.select(new Apply(bean.getApplyId()), true);
            Permission parent = select(new Permission(bean.getParentId()), true);

            bean.setApply(apply);
            bean.setParent(parent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
