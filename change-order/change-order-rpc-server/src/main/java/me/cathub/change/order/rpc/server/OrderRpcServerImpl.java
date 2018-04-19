package me.cathub.change.order.rpc.server;

import me.cathub.change.api.dao.order.OrderDao;
import me.cathub.change.api.rpc.server.order.OrderRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.order.bean.Order;
import me.cathub.change.storehouse.bean.Storehouse;
import me.cathub.change.user.bean.BrandQuotient;
import me.cathub.change.user.bean.Shopkeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class OrderRpcServerImpl implements OrderRpcServer {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorehouseRpcServer storehouseRpcServer;

    @Autowired
    private ShopkeeperRpcServer shopkeeperRpcServer;

    @Autowired
    private BrandQuotientRpcServer brandQuotientRpcServer;

    @Override
    public boolean insert(Order bean) throws Exception {
        return orderDao.insert(bean);
    }

    @Override
    public boolean deleteL(Order bean) throws Exception {
        return orderDao.deleteL(bean);
    }

    @Override
    public boolean restore(Order bean) throws Exception {
        return orderDao.restore(bean);
    }

    @Override
    public boolean deleteP(Order bean) throws Exception {
        return orderDao.deleteP(bean);
    }

    @Override
    public boolean update(Order bean) throws Exception {
        return orderDao.update(bean);
    }

    @Override
    public Order select(Order bean) throws Exception {
        return fill(orderDao.select(bean));
    }

    @Override
    public List<Order> list(int page, int count, int tableIndex) throws Exception {
        return orderDao.list(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public long count(int tableIndex) throws Exception {
        return orderDao.count(tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return orderDao.clear(tableIndex);
    }

    @Override
    public Order fill(Order bean) {
        try {
            bean.setStorehouse(storehouseRpcServer.select(new Storehouse(bean.getStorehouse_id())));
            bean.setShopkeeper(shopkeeperRpcServer.select(new Shopkeeper(bean.getShopkeeper_id())));
            bean.setBrandQuotient(brandQuotientRpcServer.select(new BrandQuotient(bean.getBrandQuotient_id())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
