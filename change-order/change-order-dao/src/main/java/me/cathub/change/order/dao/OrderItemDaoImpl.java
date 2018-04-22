package me.cathub.change.order.dao;

import com.github.pagehelper.PageHelper;
import me.cathub.change.api.dao.order.OrderItemDao;
import me.cathub.change.common.base.BaseCrudMyBatisImpl;
import me.cathub.change.order.bean.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class OrderItemDaoImpl extends BaseCrudMyBatisImpl<OrderItem> implements OrderItemDao {

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
    public long count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return clear(NAME_SPACE, tableIndex);
    }

    @Override
    public List<OrderItem> listByOrderId(long order_id, int page, int count, int tableIndex) throws Exception {
        List<OrderItem> results = null;
        try {
            HashMap<String, ? super Number> map = new HashMap<>();
            map.put("order_id", order_id);
            map.put("tableIndex", tableIndex);

            PageHelper.startPage(page, count);
            results = sqlSessionTemplate.selectList(NAME_SPACE + LIST_BY_ORDER_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public int countByOrderId(long order_id, int tableIndex) throws Exception {
        int count = 0;
        try {
            HashMap<String, ? super Number> map = new HashMap<>();
            map.put("order_id", order_id);
            map.put("tableIndex", tableIndex);
            count = sqlSessionTemplate.selectOne(NAME_SPACE + COUNT_BY_ORDER_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
