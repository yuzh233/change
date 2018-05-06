package me.cathub.change.upms.dao;

import me.cathub.change.api.dao.upms.PermissionDao;
import me.cathub.change.api.dao.upms.RoleDao;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.upms.bean.Permission;
import me.cathub.change.upms.bean.Role;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class PermissionDaoImplTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-upms-dao.xml");
    PermissionDao permissionDao = context.getBean(PermissionDaoImpl.class);
    RoleDao roleDao = context.getBean(RoleDaoImpl.class);
    Sequence sequence = new Sequence(0, 0);

    @Test
    public void insert() throws Exception {
        Role role = roleDao.selectByName("游客", 0);
        Permission permission = new Permission(sequence.nextId());
        permission.setRole(role);
        permission.setName("select:product:*");
        permissionDao.insert(permission);
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
    public void select() {
    }

    @Test
    public void list() throws Exception {
        permissionDao.list(0, 100, 0).forEach( e -> System.out.println(e));
        permissionDao.list(0, 100, 0).forEach( e -> System.out.println(e));
    }

    @Test
    public void count() throws Exception {
        System.out.println(permissionDao.count(0));
    }

    @Test
    public void clear() {
    }

    @Test
    public void listByRoleId() {
    }

    @Test
    public void countByRoleId() {
    }

    @Test
    public void selectByName() {
    }
}
