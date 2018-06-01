package me.cathub.change.storehouse.dao;

import me.cathub.change.api.dao.storehouse.StorehouseDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author cheng
 * @date 2018/6/1
 * @time 16:11
 */
public class StorehouseDaoImplTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/spring-storehouse-dao.xml");
    StorehouseDao dao = context.getBean(StorehouseDao.class);

    @Test
    public void listByDel() throws Exception {
        assertTrue(dao.listByDel(0, 100, 0).size() == dao.countByDel(0));
    }

    @Test
    public void countByDel() {
    }

    @Test
    public void listByStorehouseCountryId() throws Exception {
        assertTrue(dao.listByStorehouseCountryId(1, 0, 100, 0).size() == dao.countByStorehouseCountryId(1, 0));
    }

    @Test
    public void countByStorehouseCountryId() {
    }

    @Test
    public void selectByName() throws Exception {
        System.out.println(dao.selectByName("", 0));
    }
}
