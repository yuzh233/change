package me.cathub.change.upms.dao;

import me.cathub.change.common.tool.Sequence;
import me.cathub.change.upms.bean.Role;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RoleDaoImplTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-upms-dao.xml");
    RoleDaoImpl roleDao = context.getBean(RoleDaoImpl.class);
    Sequence sequence = new Sequence(0, 0);

    @Test
    public void insert() throws Exception {
        Role role = new Role(sequence.nextId());
        role.setName("游客");
        roleDao.insert(role);
    }

    @Test
    public void deleteL() throws Exception {
        Role role = new Role(19872888647581696l);
        roleDao.deleteL(role);
    }

    @Test
    public void restore() throws Exception {
        Role role = new Role(19872888647581696l);
        roleDao.restore(role);
    }

    @Test
    public void deleteP() {
    }

    @Test
    public void update() throws Exception {
        Role role = new Role(19872888647581696l);
        role.setName("管理员-审核部");
        roleDao.update(role);
    }

    @Test
    public void select() throws Exception {
        Role role = new Role(19872888647581696l);
        System.out.println(roleDao.select(role));
    }

    @Test
    public void list() throws Exception {
        roleDao.list(0, 100, 0).stream().forEach(e -> System.out.println(e));
    }

    @Test
    public void count() throws Exception {
        System.out.println(roleDao.count(0));
    }

    @Test
    public void clear() {
    }

    @Test
    public void selectByName() throws Exception {
        System.out.println(roleDao.selectByName("用户-品牌商", 0));
    }
}