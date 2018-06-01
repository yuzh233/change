package me.cathub.change.product.dao;

import me.cathub.change.api.dao.product.ProductDao;
import me.cathub.change.common.util.key.Sequence;
import me.cathub.change.product.bean.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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
    public void listByBrandQuotientId() throws Exception {
        List<Product> products = dao.listByBrandQuotientId(1, 0, 100, 0);
        assertTrue(products.size() == dao.countByBrandQuotientId(1, 0));
    }

    @Test
    public void countByBrandQuotientId() {
    }

    @Test
    public void listByCompanyId() throws Exception {
        List<Product> products = dao.listByCompanyId(1, 0, 100, 0);
        assertTrue(products.size() == dao.countByCompanyId(1, 0));
    }

    @Test
    public void countByCompanyId() {
    }

    @Test
    public void listByProductCategoryIdAndCompanyId() throws Exception {
        List<Product> products = dao.listByProductCategoryIdAndCompanyId(1, 2, 0, 100, 0);
        assertTrue(products.size() == dao.countByProductCategoryIdAndCompanyId(1, 2, 0));
    }

    @Test
    public void countByProductCategoryIdAndCompanyId() {
    }

    @Test
    public void listByProductCategoryId() throws Exception {
        List<Product> products = dao.listByProductCategoryId(1, 0, 100, 0);
        assertTrue(products.size() == dao.countByProductCategoryId(1, 0));
    }

    @Test
    public void countByProductCategoryId() {
    }

    @Test
    public void selectByName() throws Exception {
        System.out.println(dao.selectByName("厂家批发成人儿童夏威夷草裙花环服装5，6件套淘宝速卖通外贸代发", 0));
    }
}