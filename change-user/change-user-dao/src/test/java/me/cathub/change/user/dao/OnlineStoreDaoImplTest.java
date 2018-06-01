package me.cathub.change.user.dao;

import me.cathub.change.api.dao.user.OnlineStoreDao;
import me.cathub.change.user.bean.OnlineStore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author cheng
 * @date 2018/6/1
 * @time 16:52
 */
public class OnlineStoreDaoImplTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-user-dao.xml");
    OnlineStoreDao dao = context.getBean(OnlineStoreDao.class);

    @Test
    public void listByDel() throws Exception {
        assertTrue(dao.listByDel(0, 100, 0).size() == dao.countByDel(0));
    }

    @Test
    public void countByDel() {
    }

    @Test
    public void listByShopkeeperId() throws Exception {
        assertTrue(dao.listByShopkeeperId(1, 0, 100, 0).size() == dao.countByShopkeeperId(1, 0));
    }

    @Test
    public void countByShopkeeperId() {
    }
}