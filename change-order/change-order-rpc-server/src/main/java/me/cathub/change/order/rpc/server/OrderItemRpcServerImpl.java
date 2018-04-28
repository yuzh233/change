package me.cathub.change.order.rpc.server;

import me.cathub.change.api.dao.order.OrderItemDao;
import me.cathub.change.api.rpc.server.order.OrderItemRpcServer;
import me.cathub.change.api.rpc.server.order.OrderRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.order.bean.Order;
import me.cathub.change.order.bean.OrderItem;
import me.cathub.change.product.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class OrderItemRpcServerImpl implements OrderItemRpcServer {

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private OrderRpcServer orderRpcServer;

    @Autowired
    private ProductRpcServer productRpcServer;

    @Autowired
    private Sequence sequence;

    @Override
    public long insert(OrderItem bean) throws Exception {
        bean.setId(sequence.nextId());
        return orderItemDao.insert(bean) ? bean.getId() : -1;
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
    public int count(int tableIndex) throws Exception {
        return orderItemDao.count(tableIndex);
    }

    @Override
    public List<OrderItem> listByDel(int page, int count, int tableIndex) throws Exception {
        return orderItemDao.listByDel(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByDel(int tableIndex) throws Exception {
        return orderItemDao.countByDel(tableIndex);
    }

    @Override
    public int clear(int tableIndex) throws Exception {
        return orderItemDao.clear(tableIndex);
    }

    @Override
    public List<OrderItem> listByOrderId(long order_id, int page, int count, int tableIndex) throws Exception {
        return orderItemDao.listByOrderId(order_id, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByOrderId(long order_id, int tableIndex) throws Exception {
        return orderItemDao.countByOrderId(order_id, tableIndex);
    }

    @Override
    public OrderItem fill(OrderItem bean) {
        try {
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
