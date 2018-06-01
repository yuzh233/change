package me.cathub.change.order.dao;


import me.cathub.change.api.dao.order.OrderDao;
import me.cathub.change.order.bean.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author cheng
 * @date 2018/6/1
 * @time 15:28
 */
public class OrderDaoImplTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/spring-order-dao.xml");

    OrderDao orderDao = context.getBean(OrderDaoImpl.class);

    @org.junit.Test
    public void listByStorehouseId() throws Exception {
        List<Order> orders = orderDao.listByStorehouseId(1, 0, 100, 0);

        assertTrue(orderDao.countByStorehouseId(1, 0) == orders.size());
    }

    @org.junit.Test
    public void countByStorehouseId() {
    }

    @org.junit.Test
    public void listByShopkeeperId() throws Exception {
        List<Order> orders = orderDao.listByShopkeeperId(1, 0, 100, 0);

        assertTrue(orderDao.countByShopkeeperId(1, 0) == orders.size());
    }

    @org.junit.Test
    public void countByShopkeeperId() {
    }

    @org.junit.Test
    public void listByCompanyId() throws Exception {
        List<Order> orders = orderDao.listByCompanyId(1, 0, 100, 0);

        assertTrue(orderDao.countByCompanyId(1, 0) == orders.size());
    }

    @org.junit.Test
    public void countByCompanyId() {
    }
}
