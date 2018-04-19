package me.cathub.change.api.dao.order;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.order.bean.Order;

public interface OrderDao extends BaseDao<Order> {
    String NAME_SPACE = "me.cathub.change.order.bean.Order";
}
