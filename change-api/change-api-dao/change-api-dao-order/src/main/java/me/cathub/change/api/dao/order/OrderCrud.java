package me.cathub.change.api.dao.order;

import me.cathub.change.common.base.BaseCrud;
import me.cathub.change.order.bean.Order;

public interface OrderCrud extends BaseCrud<Order> {
    String NAME_SPACE = "me.cathub.change.order.bean.Order";
}
