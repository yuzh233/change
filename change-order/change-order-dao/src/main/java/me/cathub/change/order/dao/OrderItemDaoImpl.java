package me.cathub.change.order.dao;

import me.cathub.change.api.dao.order.OrderItemDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.order.bean.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * 订单项Dao实现
 *
 * @author cheng
 */
@Repository
public class OrderItemDaoImpl extends BaseDaoMyBatisImpl<OrderItem> implements OrderItemDao {

    @Override
    public boolean insert(OrderItem bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(OrderItem bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(OrderItem bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(OrderItem bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(OrderItem bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public OrderItem select(OrderItem bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<OrderItem> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<OrderItem> listByDel(int page, int count, int tableIndex) throws Exception {
        return listByDel(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int countByDel(int tableIndex) throws Exception {
        return countByDel(NAME_SPACE, tableIndex);
    }

    @Override
    public int clear(int tableIndex) throws Exception {
        return clear(NAME_SPACE, tableIndex);
    }

    @Override
    public List<OrderItem> listByOrderId(long orderId, int page, int count, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("order_id", orderId);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_ORDER_ID, page, count, map);
    }

    @Override
    public int countByOrderId(long orderId, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("order_id", orderId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_ORDER_ID, map);
    }
}
