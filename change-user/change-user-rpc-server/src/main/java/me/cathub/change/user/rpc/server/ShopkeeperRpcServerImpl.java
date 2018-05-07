package me.cathub.change.user.rpc.server;

import me.cathub.change.api.dao.user.ShopkeeperDao;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.common.bean.upms.Role;
import me.cathub.change.common.bean.user.Shopkeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShopkeeperRpcServerImpl extends BaseRpcServerImpl<Shopkeeper, ShopkeeperDao> implements ShopkeeperRpcServer {

    @Autowired
    private RoleRpcServer roleRpcServer;

    @Override
    public Shopkeeper selectByName(String name, int tableIndex) throws Exception {
        if (false)
            return dao.selectByName(name, tableIndex);
        else
            return fill(dao.selectByName(name, tableIndex));
    }

    @Override
    public Shopkeeper fill(Shopkeeper bean) {
        try {
            Role role = roleRpcServer.select(new Role(bean.getRole_id()), true);

            bean.setRole(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
