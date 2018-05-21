package me.cathub.change.product.dao;

import me.cathub.change.api.dao.product.ProductDao;
import me.cathub.change.common.util.key.Sequence;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class ProductDaoImplTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-product-dao.xml");

    ProductDao dao = context.getBean(ProductDaoImpl.class);
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
    public void listByBrandQuotientId() {
    }

    @Test
    public void countByBrandQuotientId() {
    }

    @Test
    public void listByCompanyId() {
    }

    @Test
    public void countByCompanyId() {
    }

    @Test
    public void listByProductCategoryIdAndCompanyId() {
    }

    @Test
    public void countByProductCategoryIdAndCompanyId() {
    }

    @Test
    public void listByProductCategoryId() {
    }

    @Test
    public void countByProductCategoryId() {
    }

    @Test
    public void selectByName() throws Exception {
        System.out.println(dao.selectByName("厂家批发成人儿童夏威夷草裙花环服装5，6件套淘宝速卖通外贸代发", 0));
    }
}