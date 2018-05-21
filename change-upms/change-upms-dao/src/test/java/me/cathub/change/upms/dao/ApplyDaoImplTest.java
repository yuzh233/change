package me.cathub.change.upms.dao;

import me.cathub.change.api.dao.upms.ApplyDao;
import me.cathub.change.common.util.key.Sequence;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class ApplyDaoImplTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-upms-dao.xml");

    ApplyDao dao = context.getBean(ApplyDaoImpl.class);
    Sequence sequence = new Sequence(0 ,1);

    @Test
    public void insert() {
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
    public void list() {
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
    public void selectByName() throws Exception {
        System.out.println(dao.selectByName("权限子系统", 0));
    }
}