package me.cathub.change.storehouse.dao;

import me.cathub.change.api.dao.storehouse.StorehouseCountryDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author cheng
 * @date 2018/6/1
 * @time 16:07
 */
public class StorehouseCountryDaoImplTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/spring-storehouse-dao.xml");
    StorehouseCountryDao dao = context.getBean(StorehouseCountryDao.class);

    @Test
    public void listByDel() throws Exception {
        assertTrue(dao.listByDel(0, 100, 0).size() == dao.countByDel(0));
    }

    @Test
    public void countByDel() {
    }

    @Test
    public void selectByName() throws Exception {
        System.out.println(dao.selectByName("", 0));
    }
}
