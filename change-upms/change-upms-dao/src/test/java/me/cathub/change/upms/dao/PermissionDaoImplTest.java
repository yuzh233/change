package me.cathub.change.upms.dao;

import javafx.application.Application;
import me.cathub.change.api.dao.upms.PermissionDao;
import me.cathub.change.common.util.key.Sequence;
import me.cathub.change.upms.bean.Apply;
import me.cathub.change.upms.bean.Permission;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class PermissionDaoImplTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-upms-dao.xml");

    PermissionDao dao = context.getBean(PermissionDaoImpl.class);

    Sequence sequence = new Sequence(0, 1);

    @Test
    public void insert() throws Exception {
        Permission permission = new Permission(sequence.nextId());
        permission.setName("查询用户列表");
        permission.setApply(new Apply(-1));
        permission.setParent(new Permission(-2));
        permission.setUrl("/user/list");

        assertTrue(dao.insert(permission));

        Permission select1 = dao.select(permission);
        assertNotNull(select1);

        assertEquals(select1.getApplyId(), permission.getApply().getId());
        assertEquals(select1.getParentId(), permission.getParent().getId());
        assertEquals(select1.getUrl(), permission.getUrl());

        permission.setName("查询用户");
        permission.setUrl("/user/select");
        permission.setApply(new Apply(-10));
        permission.setParent(new Permission(-20));

        assertTrue(dao.update(permission));

        Permission select = dao.select(permission);
        assertEquals(-10, select.getApplyId());
        assertEquals(-20, select.getParentId());
        assertEquals("/user/select", select.getUrl());

        assertTrue(dao.deleteL(permission));
        assertTrue(dao.restore(permission));
        assertFalse(dao.deleteP(permission));
        assertTrue(dao.deleteL(permission));
        assertTrue(dao.deleteP(permission));
        assertNull(dao.select(permission));
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
    public void select() throws Exception {
        System.out.println(dao.select(new Permission(1998)));
    }

    @Test
    public void list() throws Exception {
        dao.list(0, 1000, 0).forEach(System.out::println);
    }

    @Test
    public void count() {
    }

    @Test
    public void listByDel() throws Exception {
        dao.listByDel(0, 1000, 0).forEach(System.out::println);
    }

    @Test
    public void countByDel() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void selectByName() throws Exception {
        System.out.println(dao.selectByName("查询商品列表", 0));
    }

    @Test
    public void listByApplyId() throws Exception {
        dao.listByApplyId(-1, 0, 1000, 0).forEach(System.out::println);
    }

    @Test
    public void countByApplyId() {
    }

    @Test
    public void childListById() throws Exception {
        dao.childListById(-2, 0, 1000, 0).forEach(System.out::println);
    }

    @Test
    public void childCountById() {
    }
}