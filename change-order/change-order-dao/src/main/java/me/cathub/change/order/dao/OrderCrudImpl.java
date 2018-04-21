package me.cathub.change.order.dao;

import me.cathub.change.api.dao.order.OrderCrud;
import me.cathub.change.common.base.BaseCrudMyBatisImpl;
import me.cathub.change.order.bean.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderCrudImpl extends BaseCrudMyBatisImpl<Order> implements OrderCrud {

    @Override
    public boolean insert(Order bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(Order bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(Order bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(Order bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(Order bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public Order select(Order bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<Order> list(int page, int count, int tableIndex) throws Exception {
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
}
