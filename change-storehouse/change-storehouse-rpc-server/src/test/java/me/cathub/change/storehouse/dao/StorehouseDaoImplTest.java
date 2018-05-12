package me.cathub.change.storehouse.dao;


import me.cathub.change.api.dao.storehouse.StorehouseDao;
import me.cathub.change.common.bean.storehouse.Storehouse;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StorehouseDaoImplTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-storehouse-dao.xml");
    StorehouseDao dao = context.getBean(StorehouseDaoImpl.class);

    @Test
    public void testInsert() throws Exception {
        Storehouse storehouse = new Storehouse();
        dao.insert(storehouse);
    }

    @Test
    public void testDeleteL() throws Exception {
    }

    @Test
    public void testRestore() throws Exception {
    }

    @Test
    public void testDeleteP() throws Exception {
    }

    @Test
    public void testUpdate() throws Exception {
    }

    @Test
    public void testSelect() throws Exception {
    }

    @Test
    public void testList() throws Exception {
        dao.list(0, 100, 0).forEach(System.out::println);
    }

    @Test
    public void testCount() throws Exception {
    }

    @Test
    public void testListByDel() throws Exception {
    }

    @Test
    public void testCountByDel() throws Exception {
    }

    @Test
    public void testClear() throws Exception {
    }

    @Test
    public void testListByStorehouseCountryId() throws Exception {
    }

    @Test
    public void testCountByStorehouseCountryId() throws Exception {
    }

    @Test
    public void testSelectByName() throws Exception {
        System.out.println(dao.selectByName("湘潭雨湖仓库1", 0));
    }
}