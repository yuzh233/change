package me.cathub.change.order.dao;

import me.cathub.change.api.dao.order.OrderItemDao;
import me.cathub.change.common.bean.order.Order;
import me.cathub.change.common.bean.order.OrderItem;
import me.cathub.change.common.bean.product.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;


public class OrderItemDaoImplTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-order-dao.xml");
    OrderItemDao orderItemDao = context.getBean(OrderItemDaoImpl.class);

    @Test
    public void testInsert() throws Exception {
        OrderItem orderItem = new OrderItem(0);

        orderItem.setUnitPrice(10);
        orderItem.setCount(10);
        orderItem.setTotalPrice(10 * 10);
        orderItem.setOrder(new Order(0));

        orderItem.setProduct(new Product(-1));
        orderItemDao.insert(orderItem);
        orderItem.setId(1);
        orderItem.setProduct(new Product(-2));
        orderItemDao.insert(orderItem);
        orderItem.setId(3);
        orderItem.setProduct(new Product(-3));
        orderItemDao.insert(orderItem);
        orderItem.setId(4);
        orderItem.setProduct(new Product(-4));
        orderItemDao.insert(orderItem);
        orderItem.setId(5);
        orderItem.setProduct(new Product(-5));
        orderItemDao.insert(orderItem);
        orderItem.setId(6);
        orderItem.setProduct(new Product(-6));
        orderItemDao.insert(orderItem);
        orderItem.setId(7);
        orderItem.setProduct(new Product(-7));
        orderItemDao.insert(orderItem);
        orderItem.setId(8);
        orderItem.setProduct(new Product(-8));
        orderItemDao.insert(orderItem);
        orderItem.setId(9);
        orderItem.setProduct(new Product(-9));
        orderItemDao.insert(orderItem);
        orderItem.setId(10);
        orderItem.setProduct(new Product(-10));
        orderItemDao.insert(orderItem);
        orderItem.setId(11);
        orderItem.setProduct(new Product(-11));
        orderItemDao.insert(orderItem);
    }

    @Test
    public void testDeleteL() throws Exception {
        orderItemDao.deleteL(new OrderItem(11));

        System.out.println(orderItemDao.select(new OrderItem(11)));
    }

    @Test
    public void testRestore() throws Exception {
        orderItemDao.restore(new OrderItem(11));

        System.out.println(orderItemDao.select(new OrderItem(11)));
    }

    @Test
    public void testDeleteP() throws Exception {
        orderItemDao.deleteL(new OrderItem(11));
        orderItemDao.deleteP(new OrderItem(11));

        System.out.println(orderItemDao.select(new OrderItem(11)));
    }

    @Test
    public void testUpdate() throws Exception {
        OrderItem orderItem = new OrderItem(0);

        orderItem.setUnitPrice(10);
        orderItem.setCount(10);
        orderItem.setTotalPrice(10 * 10);
        orderItem.setProduct(new Product(-1998));
        orderItemDao.update(orderItem);

        System.out.println(orderItemDao.select(new OrderItem(0)));
    }

    @Test
    public void testSelect() throws Exception {
    }

    @Test
    public void testList() throws Exception {
        orderItemDao.list(0, 5, 0).forEach(System.out::println);
    }

    @Test
    public void testCount() throws Exception {
    }

    @Test
    public void testListByDel() throws Exception {
        orderItemDao.listByDel(0, 5, 0).forEach(System.out::println);
    }

    @Test
    public void testCountByDel() throws Exception {
    }

    @Test
    public void testClear() throws Exception {
    }

    @Test
    public void testListByOrderId() throws Exception {
        orderItemDao.listByOrderId(0,0, 5, 0).forEach(System.out::println);
    }

    @Test
    public void testCountByOrderId() throws Exception {
    }
}