package me.cathub.change.user.rpc.server;

import me.cathub.change.api.dao.user.OnlineStoreDao;
import me.cathub.change.api.rpc.server.user.OnlineStoreRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.common.bean.user.OnlineStore;
import me.cathub.change.common.bean.user.Shopkeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class OnlineStoreRpcServerImpl extends BaseRpcServerImpl<OnlineStore, OnlineStoreDao> implements OnlineStoreRpcServer {

    @Autowired
    private ShopkeeperRpcServer shopkeeperRpcServer;

    @Override
    public List<OnlineStore> listByShopkeeperId(long shopkeeper_id, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return dao.listByShopkeeperId(shopkeeper_id, page, count, tableIndex);
        else
            return dao.listByShopkeeperId(shopkeeper_id, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByShopkeeperId(long shopkeeper_id, int tableIndex) throws Exception {
        return dao.countByShopkeeperId(shopkeeper_id, tableIndex);
    }

    @Override
    public OnlineStore fill(OnlineStore bean) {
        try {
            Shopkeeper shopkeeper = shopkeeperRpcServer.select(new Shopkeeper(bean.getShopkeeper_id()), true);

            bean.setShopkeeper(shopkeeper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
