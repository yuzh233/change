package me.cathub.change.user.rpc.server;

import me.cathub.change.api.dao.user.ShopkeeperDao;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.user.bean.Shopkeeper;
import org.springframework.stereotype.Service;

/**
 * B2C店主Rpc服务实现类
 *
 * @author cheng
 */
@Service
public class ShopkeeperRpcServerImpl extends BaseRpcServerImpl<Shopkeeper, ShopkeeperDao> implements ShopkeeperRpcServer {

    @Override
    public Shopkeeper selectByName(String name, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.selectByName(name, tableIndex);
        } else {
            return fill(dao.selectByName(name, tableIndex));
        }
    }

    @Override
    public Shopkeeper fill(Shopkeeper bean) {
        return bean;
    }
}
