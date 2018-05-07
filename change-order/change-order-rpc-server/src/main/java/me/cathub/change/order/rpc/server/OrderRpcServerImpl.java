package me.cathub.change.order.rpc.server;

import me.cathub.change.api.dao.order.OrderDao;
import me.cathub.change.api.rpc.server.order.OrderRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.common.bean.order.Order;
import me.cathub.change.common.bean.storehouse.Storehouse;
import me.cathub.change.common.bean.user.BrandQuotient;
import me.cathub.change.common.bean.user.Shopkeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class OrderRpcServerImpl extends BaseRpcServerImpl<Order, OrderDao> implements OrderRpcServer {

    @Autowired
    private StorehouseRpcServer storehouseRpcServer;

    @Autowired
    private ShopkeeperRpcServer shopkeeperRpcServer;

    @Autowired
    private BrandQuotientRpcServer brandQuotientRpcServer;

    @Override
    public List<Order> listByStorehouseId(long storehouse_id, int page, int count, int tableIndex, boolean flag) throws Exception {
        return dao.listByStorehouseId(storehouse_id, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public long countByStorehouseId(long storehouse_id, int tableIndex) throws Exception {
        return dao.countByStorehouseId(storehouse_id, tableIndex);
    }

    @Override
    public List<Order> listByShopkeeperId(long shopkeeper_id, int page, int count, int tableIndex, boolean flag) throws Exception {
        return dao.listByShopkeeperId(shopkeeper_id, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public long countByShopkeeperId(long shopkeeper_id, int tableIndex) throws Exception {
        return dao.countByStorehouseId(shopkeeper_id, tableIndex);
    }

    @Override
    public List<Order> listByBrandQuotient(long brandQuotient_id, int page, int count, int tableIndex, boolean flag) throws Exception {
        return dao.listByBrandQuotient(brandQuotient_id, page, count, tableIndex);
    }

    @Override
    public long countBrandQuotientId(long brandQuotient_id, int tableIndex) {
        return dao.countByBrandQuotientId(brandQuotient_id, tableIndex);
    }

    @Override
    public Order fill(Order bean) {
        try {
            Storehouse storehouse = storehouseRpcServer.select(new Storehouse(bean.getStorehouse_id()), true);
            Shopkeeper shopkeeper = shopkeeperRpcServer.select(new Shopkeeper(bean.getShopkeeper_id()), true);
            BrandQuotient brandQuotient = brandQuotientRpcServer.select(new BrandQuotient(bean.getBrandQuotient_id()), true);

            bean.setStorehouse(storehouse);
            bean.setShopkeeper(shopkeeper);
            bean.setBrandQuotient(brandQuotient);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
