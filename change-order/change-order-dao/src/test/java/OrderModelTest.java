import me.cathub.change.api.dao.order.OrderDao;
import me.cathub.change.api.dao.order.OrderItemDao;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.order.bean.Order;
import me.cathub.change.order.dao.OrderDaoImpl;
import me.cathub.change.order.dao.OrderItemDaoImpl;
import me.cathub.change.storehouse.bean.Storehouse;
import me.cathub.change.user.bean.BrandQuotient;
import me.cathub.change.user.bean.Shopkeeper;
import org.testng.annotations.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderModelTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-order-dao.xml");
    OrderDao orderDao = context.getBean(OrderDaoImpl.class);
    OrderItemDao orderItemDao = context.getBean(OrderItemDaoImpl.class);

    Sequence sequence = new Sequence(0, 0);

    @Test
    public void test0() throws Exception {
        Order order = new Order();
        order.setTableIndex(0);
        order.setId(sequence.nextId());

        Storehouse storehouse = new Storehouse();
        storehouse.setId(sequence.nextId());
        order.setStorehouse(storehouse);

        Shopkeeper shopkeeper = new Shopkeeper();
        shopkeeper.setId(sequence.nextId());
        order.setShopkeeper(shopkeeper);

        BrandQuotient brandQuotient = new BrandQuotient();
        brandQuotient.setId(sequence.nextId());
        order.setBrandQuotient(brandQuotient);

        orderDao.insert(order);
    }

    @Test
    public void test1() throws Exception {
        Order order = new Order();
        order.setId(18001170492555264l);
        order.setTableIndex(0);

        System.out.println(orderDao.select(order));
    }
}
