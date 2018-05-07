package me.cathub.change.order.dao;

import me.cathub.change.api.dao.order.OrderDao;
import me.cathub.change.common.bean.order.Order;
import me.cathub.change.common.bean.storehouse.Storehouse;
import me.cathub.change.common.bean.user.BrandQuotient;
import me.cathub.change.common.bean.user.Shopkeeper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class OrderDaoImplTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-order-dao.xml");
    OrderDao orderDao = context.getBean(OrderDaoImpl.class);

    @Test
    public void testInsert() throws Exception {
        Order order = new Order(0);

        BrandQuotient brandQuotient = new BrandQuotient(-1);
        Shopkeeper shopkeeper = new Shopkeeper(-2);
        Storehouse storehouse = new Storehouse(-3);

        order.setBrandQuotient(brandQuotient);
        order.setShopkeeper(shopkeeper);

        order.setMessage("message");
        order.setStorehouse(storehouse);

        orderDao.insert(order);
        System.out.println("insert:id:0" + orderDao.select(new Order(0)));

        order.setId(1);
        orderDao.insert(order);
        order.setId(2);
        orderDao.insert(order);
        order.setId(3);
        orderDao.insert(order);
        order.setId(4);
        orderDao.insert(order);
        order.setId(5);
        orderDao.insert(order);
        order.setId(6);
        orderDao.insert(order);
        order.setId(7);
        orderDao.insert(order);
        order.setId(8);
        orderDao.insert(order);
        order.setId(9);
        orderDao.insert(order);
        order.setId(10);
        orderDao.insert(order);
    }

    @Test
    public void testDeleteL() throws Exception {
        orderDao.deleteL(new Order(1));
        System.out.println("deleteL:id:1" + orderDao.select(new Order(1)));
    }

    @Test
    public void testRestore() throws Exception {
        orderDao.restore(new Order(1));
        System.out.println("restore:id:1" + orderDao.select(new Order(1)));
    }

    @Test
    public void testDeleteP() throws Exception {
        orderDao.deleteL(new Order(1));
        orderDao.deleteP(new Order(1));
        System.out.println("deleteP:id:1" + orderDao.select(new Order(1)));
    }

    @Test
    public void testUpdate() throws Exception {
        Order order = new Order(0);

        BrandQuotient brandQuotient = new BrandQuotient(-1);
        Shopkeeper shopkeeper = new Shopkeeper(-2);
        Storehouse storehouse = new Storehouse(-3);

        order.setBrandQuotient(brandQuotient);
        order.setShopkeeper(shopkeeper);

        order.setMessage("error");
        order.setStorehouse(storehouse);
        orderDao.update(order);

        System.out.println("update:id:0" + orderDao.select(new Order(0)));

    }

    @Test
    public void testSelect() throws Exception {
    }

    @Test
    public void testList() throws Exception {
        orderDao.list(0, 5, 0).forEach(System.out::println);
    }

    @Test
    public void testCount() throws Exception {
        System.out.println(orderDao.count(0));
    }

    @Test
    public void testListByDel() throws Exception {
        orderDao.listByDel(0, 5, 0).forEach(System.out::println);
    }

    @Test
    public void testCountByDel() throws Exception {
        System.out.println(orderDao.countByDel(0));
    }

    @Test
    public void testClear() throws Exception {
        orderDao.clear(0);
    }

    @Test
    public void testListByStorehouseId() throws Exception {
        orderDao.listByStorehouseId(-3, 0,5, 0).forEach(System.out::println);
    }

    @Test
    public void testCountByStorehouseId() throws Exception {
        orderDao.listByStorehouseId(-3, 0,5, 0).forEach(System.out::println);
    }

    @Test
    public void testListByShopkeeperId() throws Exception {
        orderDao.listByShopkeeperId(-2, 0,5, 0).forEach(System.out::println);
    }

    @Test
    public void testCountByShopkeeperId() throws Exception {
        System.out.println(orderDao.countByShopkeeperId(-1, 0));
    }

    @Test
    public void testListByBrandQuotient() throws Exception {
        orderDao.listByBrandQuotient(-1, 0,5, 0).forEach(System.out::println);
    }

    @Test
    public void testCountBrandQuotientId() throws Exception {
        System.out.println(orderDao.countByBrandQuotientId(-1, 0));
    }
}