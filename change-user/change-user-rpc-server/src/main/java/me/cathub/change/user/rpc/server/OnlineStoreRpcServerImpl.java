package me.cathub.change.user.rpc.server;

import me.cathub.change.api.dao.user.OnlineStoreCrud;
import me.cathub.change.api.rpc.server.user.OnlineStoreRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.user.bean.OnlineStore;
import me.cathub.change.user.bean.Shopkeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class OnlineStoreRpcServerImpl implements OnlineStoreRpcServer {

    @Autowired
    private OnlineStoreCrud onlineStoreDao;

    @Autowired
    private ShopkeeperRpcServer shopkeeperRpcServer;

    @Autowired
    private Sequence sequence;

    @Override
    public boolean insert(OnlineStore bean) throws Exception {
        bean.setId(sequence.nextId());
        return onlineStoreDao.insert(bean);
    }

    @Override
    public boolean deleteL(OnlineStore bean) throws Exception {
        return onlineStoreDao.deleteL(bean);
    }

    @Override
    public boolean restore(OnlineStore bean) throws Exception {
        return onlineStoreDao.restore(bean);
    }

    @Override
    public boolean deleteP(OnlineStore bean) throws Exception {
        return onlineStoreDao.deleteP(bean);
    }

    @Override
    public boolean update(OnlineStore bean) throws Exception {
        return onlineStoreDao.update(bean);
    }

    @Override
    public OnlineStore select(OnlineStore bean) throws Exception {
        return fill(onlineStoreDao.select(bean));
    }

    @Override
    public List<OnlineStore> list(int page, int count, int tableIndex) throws Exception {
        return onlineStoreDao.list(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public long count(int tableIndex) throws Exception {
        return onlineStoreDao.count(tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return onlineStoreDao.count(tableIndex);
    }

    @Override
    public OnlineStore fill(OnlineStore bean) {
        try {
            Shopkeeper shopkeeper = shopkeeperRpcServer.select(new Shopkeeper(bean.getShopkeeper_id()));

            bean.setShopkeeper(shopkeeper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
