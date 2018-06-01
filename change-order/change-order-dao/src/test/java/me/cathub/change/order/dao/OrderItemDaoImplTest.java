package me.cathub.change.order.dao;

import me.cathub.change.api.dao.order.OrderItemDao;
import me.cathub.change.order.bean.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author cheng
 * @date 2018/6/1
 * @time 15:29
 */
public class OrderItemDaoImplTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/spring-order-dao.xml");

    OrderItemDao dao = context.getBean(OrderItemDao.class);

    @Test
    public void listByOrderId() throws Exception {
        List<OrderItem> orderItems = dao.listByOrderId(1, 0, 100, 0);
        assertTrue(orderItems.size() == dao.countByOrderId(1, 0));
    }

    @Test
    public void countByOrderId() {
    }
}
