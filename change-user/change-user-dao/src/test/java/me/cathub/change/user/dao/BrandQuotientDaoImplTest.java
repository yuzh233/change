package me.cathub.change.user.dao;

import me.cathub.change.api.dao.user.BrandQuotientDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author cheng
 * @date 2018/6/1
 * @time 16:49
 */
public class BrandQuotientDaoImplTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-user-dao.xml");
    BrandQuotientDao dao = context.getBean(BrandQuotientDao.class);

    @Test
    public void listByDel() throws Exception {
        assertTrue(dao.listByDel(0, 110, 0).size() == dao.countByDel(0));
    }

    @Test
    public void countByDel() {
    }

    @Test
    public void selectByName() throws Exception {
        System.out.println(dao.selectByName("", 0));
    }

    @Test
    public void listByCompanyId() throws Exception {
        assertTrue(dao.listByCompanyId(1, 0, 0, 0).size() == dao.countByCompanyId(1, 0));
    }

    @Test
    public void countByCompanyId() {
    }
}