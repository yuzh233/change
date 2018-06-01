package me.cathub.change.product.dao;

import me.cathub.change.api.dao.product.ProductImageDao;
import me.cathub.change.product.bean.ProductImage;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author cheng
 * @date 2018/6/1
 * @time 15:52
 */
public class ProductImageDaoImplTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-product-dao.xml");
    ProductImageDao dao = context.getBean(ProductImageDao.class);

    @Test
    public void listByDel() throws Exception {
        assertTrue(dao.listByDel(0, 100, 0).size() == dao.countByDel(0));
    }

    @Test
    public void countByDel() {
    }

    @Test
    public void listByProductIdAndImageType() throws Exception {
        assertTrue(dao.listByProductIdAndImageType(1, ProductImage.TYPE_INFO, 0, 100, 0).size() == dao.countByProductIdAndImageType(1, ProductImage.TYPE_INFO, 0));
    }

    @Test
    public void countByProductIdAndImageType() {
    }

    @Test
    public void selectByProductIdCover() {
    }
}
