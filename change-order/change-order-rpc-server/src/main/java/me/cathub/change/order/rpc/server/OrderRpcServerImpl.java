package me.cathub.change.order.rpc.server;

import me.cathub.change.api.dao.order.OrderDao;
import me.cathub.change.api.rpc.server.order.OrderRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseRpcServer;
import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.order.bean.Order;
import me.cathub.change.storehouse.bean.Storehouse;
import me.cathub.change.user.bean.Company;
import me.cathub.change.user.bean.Shopkeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 订单Rpc服务实现类
 *
 * @author cheng
 */
@Service
public class OrderRpcServerImpl extends BaseRpcServerImpl<Order, OrderDao> implements OrderRpcServer {

    @Autowired
    private StorehouseRpcServer storehouseRpcServer;

    @Autowired
    private ShopkeeperRpcServer shopkeeperRpcServer;

    @Autowired
    private CompanyRpcServer companyRpcServer;

    @Override
    public List<Order> listByStorehouseId(long storehouseId, int page, int count, int tableIndex, boolean flag) throws Exception {
        return dao.listByStorehouseId(storehouseId, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public long countByStorehouseId(long storehouseId, int tableIndex) throws Exception {
        return dao.countByStorehouseId(storehouseId, tableIndex);
    }

    @Override
    public List<Order> listByShopkeeperId(long shopkeeperId, int page, int count, int tableIndex, boolean flag) throws Exception {
        return dao.listByShopkeeperId(shopkeeperId, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public long countByShopkeeperId(long shopkeeperId, int tableIndex) throws Exception {
        return dao.countByStorehouseId(shopkeeperId, tableIndex);
    }

    @Override
    public List<Order> listByBrandQuotient(long brandQuotientId, int page, int count, int tableIndex, boolean flag) throws Exception {
        return dao.listByCompanyId(brandQuotientId, page, count, tableIndex);
    }

    @Override
    public long countBrandQuotientId(long brandQuotientId, int tableIndex) throws Exception {
        return dao.countByCompanyId(brandQuotientId, tableIndex);
    }

    @Override
    public Order fill(Order bean) {
        try {
            Storehouse storehouse = storehouseRpcServer.select(new Storehouse(bean.getStorehouseId()), true);
            Shopkeeper shopkeeper = shopkeeperRpcServer.select(new Shopkeeper(bean.getShopkeeperId()), true);
            Company company = companyRpcServer.select(new Company(bean.getCompanyId()), true);

            bean.setStorehouse(storehouse);
            bean.setShopkeeper(shopkeeper);
            bean.setCompany(company);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
