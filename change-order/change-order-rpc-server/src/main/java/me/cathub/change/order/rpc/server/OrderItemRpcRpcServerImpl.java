package me.cathub.change.order.rpc.server;

import me.cathub.change.api.dao.order.OrderItemCrud;
import me.cathub.change.api.rpc.server.order.OrderItemRpcRpcServer;
import me.cathub.change.api.rpc.server.order.OrderRpcRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcRpcServer;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.order.bean.Order;
import me.cathub.change.order.bean.OrderItem;
import me.cathub.change.product.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class OrderItemRpcRpcServerImpl implements OrderItemRpcRpcServer {

    @Autowired
    private OrderItemCrud orderItemDao;

    @Autowired
    private OrderRpcRpcServer orderRpcServer;

    @Autowired
    private ProductRpcRpcServer productRpcServer;

    @Autowired
    private Sequence sequence;

    @Override
    public boolean insert(OrderItem bean) throws Exception {
        bean.setId(sequence.nextId());
        return orderItemDao.insert(bean);
    }

    @Override
    public boolean deleteL(OrderItem bean) throws Exception {
        return orderItemDao.deleteL(bean);
    }

    @Override
    public boolean restore(OrderItem bean) throws Exception {
        return orderItemDao.restore(bean);
    }

    @Override
    public boolean deleteP(OrderItem bean) throws Exception {
        return orderItemDao.deleteP(bean);
    }

    @Override
    public boolean update(OrderItem bean) throws Exception {
        return orderItemDao.update(bean);
    }

    @Override
    public OrderItem select(OrderItem bean) throws Exception {
        return fill(orderItemDao.select(bean));
    }

    @Override
    public List<OrderItem> list(int page, int count, int tableIndex) throws Exception {
        return orderItemDao.list(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public long count(int tableIndex) throws Exception {
        return orderItemDao.count(tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return orderItemDao.clear(tableIndex);
    }

    @Override
    public OrderItem fill(OrderItem bean) {
        try {
            /*
                填充关联对象
             */
            Product product = productRpcServer.select(new Product(bean.getProduct_id()));
            Order order = orderRpcServer.select(new Order(bean.getOrder_id()));

            bean.setProduct(product);
            bean.setOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }
}
