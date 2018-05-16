package me.cathub.change.upms.rpc.server;

import me.cathub.change.api.dao.upms.RoleDao;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.upms.bean.Role;
import org.springframework.stereotype.Service;

/**
 * 角色Rpc服务实现类
 *
 * @author cheng
 */
@Service
public class RoleRpcServerImpl extends BaseRpcServerImpl<Role, RoleDao> implements RoleRpcServer {

    @Override
    public Role selectByName(String name, int tableIndex, boolean flag) throws Exception {
        return dao.selectByName(name, tableIndex);
    }

    @Override
    public Role fill(Role bean) {
        return bean;
    }
}