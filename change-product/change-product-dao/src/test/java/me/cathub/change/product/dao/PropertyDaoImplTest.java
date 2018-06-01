package me.cathub.change.product.dao;

import me.cathub.change.api.dao.product.PropertyDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author cheng
 * @date 2018/6/1
 * @time 16:01
 */
public class PropertyDaoImplTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-product-dao.xml");
    PropertyDao dao = context.getBean(PropertyDao.class);

    @Test
    public void listByDel() throws Exception {
        assertTrue(dao.listByDel(0, 100, 0).size() == dao.countByDel(0));
    }

    @Test
    public void countByDel() {
    }

    @Test
    public void listByProductCategoryId() throws Exception {
        assertTrue(dao.listByProductCategoryId(1, 0, 100, 0).size() == dao.countByProductCategoryId(1, 0));
    }

    @Test
    public void countByProductCategoryId() {
    }

    @Test
    public void selectByNameAndProductCategory() throws Exception {
        System.out.println(dao.selectByNameAndProductCategory("", 1, 0));
    }

    @Test
    public void selectByName() throws Exception {
        System.out.println(dao.selectByName("", 0));
    }
}
