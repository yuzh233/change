package me.cathub.change.product.dao;

import me.cathub.change.api.dao.product.ProductCategoryDao;
import me.cathub.change.common.util.key.Sequence;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author cheng
 * @date 2018/5/30
 * @time 22:57
 */
public class ProductCategoryDaoImplTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-product-dao.xml");

    ProductCategoryDao dao = context.getBean(ProductCategoryDao.class);
    Sequence sequence = new Sequence(0 ,1);

    @Test
    public void insert() {
    }

    @Test
    public void deleteL() {
    }

    @Test
    public void restore() {
    }

    @Test
    public void deleteP() {
    }

    @Test
    public void update() {
    }

    @Test
    public void select() {
    }

    @Test
    public void list() {
    }

    @Test
    public void count() {
    }

    @Test
    public void listByDel() {
    }

    @Test
    public void countByDel() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void selectByName() throws Exception {
        System.out.println(dao.selectByName("手机", 0));
    }

    @Test
    public void childListById() throws Exception {
        dao.childListById(20476139176730624L, 0, 100, 0)
                .forEach(System.out::println);
    }

    @Test
    public void childCountById() throws Exception {
        System.out.println(dao.childCountById(20476139176730624L, 0));
    }
}