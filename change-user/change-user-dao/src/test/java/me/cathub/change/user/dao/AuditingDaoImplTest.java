package me.cathub.change.user.dao;

import me.cathub.change.api.dao.user.AuditingDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author cheng
 * @date 2018/6/1
 * @time 16:45
 */
public class AuditingDaoImplTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-user-dao.xml");
    AuditingDao dao = context.getBean(AuditingDao.class);

    @Test
    public void listByDel() throws Exception {
        assertTrue(dao.listByDel(0, 0, 0).size() == dao.countByDel(0));
    }

    @Test
    public void countByDel() {
    }

    @Test
    public void listByAdminIdAndUserType() throws Exception {
        assertTrue(dao.listByAdminIdAndUserType(0, 0, 0, 100, 0).size() == dao.countByAdminIdAndUserType(0,  0, 0));
    }

    @Test
    public void countByAdminIdAndUserType() {
    }

    @Test
    public void listByNotAuditing() throws Exception {
        assertTrue(dao.listByNotAuditing(0, 0, 100, 0).size() == dao.countByNotAuditing(0, 0));
    }

    @Test
    public void countByNotAuditing() {
    }
}