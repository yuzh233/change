package me.cathub.change.order.rpc.server;

import me.cathub.change.api.dao.order.OrderItemDao;
import me.cathub.change.api.rpc.server.order.OrderItemRpcServer;
import me.cathub.change.api.rpc.server.order.OrderRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.order.bean.Order;
import me.cathub.change.order.bean.OrderItem;
import me.cathub.change.product.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 订单项Rpc服务实现类
 *
 * @author cheng
 */
@Service
public class OrderItemRpcServerImpl extends BaseRpcServerImpl<OrderItem, OrderItemDao> implements OrderItemRpcServer {

    @Autowired
    private OrderRpcServer orderRpcServer;

    @Autowired
    private ProductRpcServer productRpcServer;
    

    @Override
    public List<OrderItem> listByOrderId(long orderId, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag) {
            return dao.listByOrderId(orderId, page, count, tableIndex);
        } else {
            return dao.listByOrderId(orderId, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
        }
    }

    @Override
    public int countByOrderId(long orderId, int tableIndex) throws Exception {
        return dao.countByOrderId(orderId, tableIndex);
    }

    @Override
    public OrderItem fill(OrderItem bean) {
        try {
            Product product = productRpcServer.select(new Product(bean.getProductId()), true);
            Order order = orderRpcServer.select(new Order(bean.getOrderId()), true);

            bean.setProduct(product);
            bean.setOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }
}
