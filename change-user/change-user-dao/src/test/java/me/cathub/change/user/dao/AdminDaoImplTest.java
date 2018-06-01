package me.cathub.change.user.dao;

import me.cathub.change.api.dao.user.AdminDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author cheng
 * @date 2018/6/1
 * @time 16:43
 */
public class AdminDaoImplTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-user-dao.xml");
    AdminDao dao = context.getBean(AdminDao.class);

    @Test
    public void listByDel() throws Exception {
        assertTrue(dao.listByDel(0, 100, 0).size() == dao.countByDel(0));
    }

    @Test
    public void countByDel() {
    }

    @Test
    public void selectByName() {
    }
}