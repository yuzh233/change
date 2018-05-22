package me.cathub.change.upms.dao;

import me.cathub.change.api.dao.upms.UserRoleDao;
import me.cathub.change.common.bean.User;
import me.cathub.change.common.util.key.Sequence;
import me.cathub.change.upms.bean.Role;
import me.cathub.change.upms.bean.UserRole;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.*;

public class UserRoleDaoImplTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-upms-dao.xml");

    UserRoleDao dao = context.getBean(UserRoleDao.class);
    Sequence sequence = new Sequence(0 ,1);

    @Test
    public void insert() throws Exception {
        UserRole userRole = new UserRole(sequence.nextId());
        userRole.setUser(new User(-1));
        userRole.setRole(new Role(-2));

        assertTrue(dao.insert(userRole));

        UserRole select = dao.select(new UserRole(1998));
        assertEquals(-1, select.getUserId());
        assertEquals(-2, select.getRoleId());

        userRole.setRole(new Role(-10));
        userRole.setUser(new User(-20));
        assertTrue(dao.update(userRole));

        assertTrue(dao.deleteL(userRole));
        assertTrue(dao.restore(userRole));
        assertFalse(dao.deleteP(userRole));
        assertTrue(dao.deleteL(userRole));
        assertTrue(dao.deleteP(userRole));
        assertNull(dao.select(userRole));
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
    public void update() throws Exception {
    }

    @Test
    public void select() {
    }

    @Test
    public void list() throws Exception {
        dao.list(0, 1000, 0).forEach(System.out::println);
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
    public void listByUserId() throws Exception {
        dao.listByUserId(-1 ,0, 1000, 0).forEach(System.out::println);
    }

    @Test
    public void countByUserId() {
    }

    @Test
    public void listByRoleId() throws Exception {
        dao.listByRoleId(-2 ,0, 1000, 0).forEach(System.out::println);
    }

    @Test
    public void countByRoleId() {
    }
}