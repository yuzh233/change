package me.cathub.change.upms.dao;

import me.cathub.change.api.dao.upms.PermissionDao;
import me.cathub.change.api.dao.upms.RolePermissionDao;
import me.cathub.change.common.util.key.Sequence;
import me.cathub.change.upms.bean.Apply;
import me.cathub.change.upms.bean.Permission;
import me.cathub.change.upms.bean.Role;
import me.cathub.change.upms.bean.RolePermission;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;

public class RolePermissionDaoImplTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-upms-dao.xml");

    RolePermissionDao dao = context.getBean(RolePermissionDaoImpl.class);
    PermissionDao pDao = context.getBean(PermissionDaoImpl.class);
    Sequence sequence = new Sequence(0 ,1);

    @Test
    public void test() throws Exception {
        List<Permission> permissions = pDao.listByApplyId(30316478049816576L, 0, 100, 0);

        RolePermission rolePermission = new RolePermission(sequence.nextId());
        rolePermission.setRole(new Role(33251004266844160L));
        rolePermission.setApply(new Apply(30316478049816576L));

        permissions = permissions.stream()
                .filter(bean -> bean.getUrl().contains("/list") || bean.getUrl().contains("select"))
                .collect(toList());

        for (Permission permission : permissions) {
            rolePermission.setPermission(permission);
            dao.insert(rolePermission);
            rolePermission.setId(sequence.nextId());
        }
    }

    @Test
    public void insert() throws Exception {
        RolePermission rolePermission = new RolePermission(sequence.nextId());
        rolePermission.setRole(new Role(30317630518726656L));
        rolePermission.setApply(new Apply(30315967665934336L));

        // 增加测试
        assertTrue(dao.insert(rolePermission));

        RolePermission select = dao.select(rolePermission);
        assertNotNull(select);
        assertEquals(-1, select.getRoleId());
        assertEquals(-2, select.getApplyId());

        rolePermission.setRole(new Role(-10));
        rolePermission.setApply(new Apply(-20));
        assertTrue(dao.update(rolePermission));

        select = dao.select(rolePermission);
        assertEquals(-10, select.getRoleId());
        assertEquals(-20, select.getApplyId());

        assertTrue(dao.deleteL(rolePermission));
        assertTrue(dao.restore(rolePermission));
        assertFalse(dao.deleteP(rolePermission));
        assertTrue(dao.deleteL(rolePermission));
        assertTrue(dao.deleteP(rolePermission));
        assertNull(dao.select(rolePermission));
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
        RolePermission rolePermission = new RolePermission(sequence.nextId());
        rolePermission.setRole(new Role(-1));
        rolePermission.setApply(new Apply(-2));
        dao.insert(rolePermission);
        rolePermission.setId(sequence.nextId());
        dao.insert(rolePermission);
        rolePermission.setId(sequence.nextId());
        dao.insert(rolePermission);
        rolePermission.setId(sequence.nextId());
        dao.insert(rolePermission);
        rolePermission.setId(sequence.nextId());
        dao.insert(rolePermission);
        rolePermission.setId(sequence.nextId());
        dao.insert(rolePermission);
        rolePermission.setId(sequence.nextId());
        dao.insert(rolePermission);
        rolePermission.setId(sequence.nextId());
        dao.insert(rolePermission);
        rolePermission.setId(sequence.nextId());
        dao.insert(rolePermission);
        rolePermission.setId(sequence.nextId());
        dao.insert(rolePermission);
        rolePermission.setId(sequence.nextId());
        dao.insert(rolePermission);
        rolePermission.setId(sequence.nextId());
        dao.insert(rolePermission);
        rolePermission.setId(sequence.nextId());
        dao.insert(rolePermission);

        dao.list(0, 100, 0).forEach(System.out::println);
    }

    @Test
    public void count() throws Exception {
        System.out.println(dao.count(0));
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
    public void listByRoleIdAndApplyId() throws Exception {
        dao.listByRoleIdAndApplyId(-1, -2, 0, 10000, 0).forEach(System.out::println);
    }

    @Test
    public void countByRoleIdAndApplyId() throws Exception {
        System.out.println(dao.countByRoleIdAndApplyId(-1, -2, 0));
    }

    @Test
    public void listByRoleId() throws Exception {
        dao.listByRoleId(-1, 0, 100, 0).forEach(System.out::println);
    }

    @Test
    public void countByRoleId() throws Exception {
        System.out.println(dao.countByRoleId(-1,  0));
    }
}