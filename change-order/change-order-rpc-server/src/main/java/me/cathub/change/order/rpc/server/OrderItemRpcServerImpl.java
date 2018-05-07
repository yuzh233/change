package me.cathub.change.order.rpc.server;

import me.cathub.change.api.dao.order.OrderItemDao;
import me.cathub.change.api.rpc.server.order.OrderItemRpcServer;
import me.cathub.change.api.rpc.server.order.OrderRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.common.bean.order.Order;
import me.cathub.change.common.bean.order.OrderItem;
import me.cathub.change.common.bean.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class OrderItemRpcServerImpl extends BaseRpcServerImpl<OrderItem, OrderItemDao> implements OrderItemRpcServer {

    @Autowired
    private OrderRpcServer orderRpcServer;

    @Autowired
    private ProductRpcServer productRpcServer;
    

    @Override
    public List<OrderItem> listByOrderId(long order_id, int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return dao.listByOrderId(order_id, page, count, tableIndex);
        else
            return dao.listByOrderId(order_id, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByOrderId(long order_id, int tableIndex) throws Exception {
        return dao.countByOrderId(order_id, tableIndex);
    }

    @Override
    public OrderItem fill(OrderItem bean) {
        try {
            Product product = productRpcServer.select(new Product(bean.getProduct_id()), true);
            Order order = orderRpcServer.select(new Order(bean.getOrder_id()), true);

            bean.setProduct(product);
            bean.setOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }
}
