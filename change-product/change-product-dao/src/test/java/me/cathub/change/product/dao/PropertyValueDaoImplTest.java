package me.cathub.change.product.dao;

import me.cathub.change.api.dao.product.PropertyValueDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author cheng
 * @date 2018/6/1
 * @time 16:05
 */
public class PropertyValueDaoImplTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-product-dao.xml");
    PropertyValueDao dao = context.getBean(PropertyValueDao.class);

    @Test
    public void listByDel() throws Exception {
        assertTrue(dao.listByDel(0, 100, 0).size() == dao.countByDel(0));
    }

    @Test
    public void countByDel() {
    }

    @Test
    public void listByProductId() throws Exception {
        assertTrue(dao.listByProductId(1, 0, 100, 0).size() == dao.countByProductId(1, 0));
    }

    @Test
    public void countByProductId() {
    }
}
