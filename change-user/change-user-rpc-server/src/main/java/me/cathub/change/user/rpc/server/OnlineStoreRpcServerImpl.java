package me.cathub.change.user.rpc.server;

import me.cathub.change.api.dao.user.OnlineStoreDao;
import me.cathub.change.api.rpc.server.user.OnlineStoreRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.user.bean.OnlineStore;
import me.cathub.change.user.bean.Shopkeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 网店Rpc服务实现类
 *
 * @author cheng
 */
@Service
public class OnlineStoreRpcServerImpl extends BaseRpcServerImpl<OnlineStore, OnlineStoreDao> implements OnlineStoreRpcServer {

    @Autowired
    private ShopkeeperRpcServer shopkeeperRpcServer;

    @Override
    public List<OnlineStore> listByShopkeeperId(long shopkeeperId, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByShopkeeperId(shopkeeperId, page, count, tableIndex);
        } else {
            return dao.listByShopkeeperId(shopkeeperId, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
        }
    }

    @Override
    public int countByShopkeeperId(long shopkeeperId, int tableIndex) throws Exception {
        return dao.countByShopkeeperId(shopkeeperId, tableIndex);
    }

    @Override
    public OnlineStore fill(OnlineStore bean) {
        try {
            Shopkeeper shopkeeper = shopkeeperRpcServer.select(new Shopkeeper(bean.getShopkeeperId()), true);

            bean.setShopkeeper(shopkeeper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
