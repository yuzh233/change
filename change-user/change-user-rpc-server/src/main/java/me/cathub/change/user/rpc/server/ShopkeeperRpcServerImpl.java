package me.cathub.change.user.rpc.server;

import me.cathub.change.api.dao.user.ShopkeeperCrud;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.upms.bean.Role;
import me.cathub.change.user.bean.Shopkeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ShopkeeperRpcServerImpl implements ShopkeeperRpcServer {

    @Autowired
    private ShopkeeperCrud shopkeeperDao;

    @Autowired
    private RoleRpcServer roleRpcServer;

    @Autowired
    private Sequence sequence;

    @Override
    public boolean insert(Shopkeeper bean) throws Exception {
        bean.setId(sequence.nextId());
        return shopkeeperDao.insert(bean);
    }

    @Override
    public boolean deleteL(Shopkeeper bean) throws Exception {
        return shopkeeperDao.deleteL(bean);
    }

    @Override
    public boolean restore(Shopkeeper bean) throws Exception {
        return shopkeeperDao.restore(bean);
    }

    @Override
    public boolean deleteP(Shopkeeper bean) throws Exception {
        return shopkeeperDao.deleteP(bean);
    }

    @Override
    public boolean update(Shopkeeper bean) throws Exception {
        return shopkeeperDao.update(bean);
    }

    @Override
    public Shopkeeper select(Shopkeeper bean) throws Exception {
        return fill(shopkeeperDao.select(bean));
    }

    @Override
    public List<Shopkeeper> list(int page, int count, int tableIndex) throws Exception {
        return shopkeeperDao.list(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public long count(int tableIndex) throws Exception {
        return shopkeeperDao.count(tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return shopkeeperDao.count(tableIndex);
    }

    @Override
    public Shopkeeper fill(Shopkeeper bean) {
        try {
            Role role = roleRpcServer.select(new Role(bean.getRole_id()));

            bean.setRole(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
