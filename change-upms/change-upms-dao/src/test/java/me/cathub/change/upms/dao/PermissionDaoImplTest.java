package me.cathub.change.upms.dao;

import me.cathub.change.api.dao.upms.PermissionDao;
import me.cathub.change.common.util.key.Sequence;
import me.cathub.change.upms.bean.Apply;
import me.cathub.change.upms.bean.Permission;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PermissionDaoImplTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-upms-dao.xml");

    PermissionDao dao = context.getBean(PermissionDaoImpl.class);

    Sequence sequence = new Sequence(0, 1);

    @Test
    public void test() throws Exception {
//        List<String> names = Arrays.asList("商品分类", "商品", "商品图片", "属性", "属性值", "商品评论");
//        List<String> nameUrls = Arrays.asList("/productCategory", "/product", "/productImage", "/property", "/propertyValue", "/productReview");

        List<String> names = Arrays.asList("仓库国家", "仓库", "仓库产品库存");
        List<String> nameUrls = Arrays.asList("/storehouseCountry", "/storehouse", "/storehouseProductStock");

        List<String> actionNames = Arrays.asList("添加$", "修改$", "删除$(逻辑删除)", "恢复$(逻辑恢复)", "查询$", "查询$列表", "查询$列表(逻辑删除)");
        List<String> urls = Arrays.asList("/insert", "/update", "/delete", "/restore", "/select", "/list", "/listDel");

        Apply apply = new Apply(30316287322230784L);

        Permission permission = new Permission();
        permission.setApply(apply);

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            String nameUrl = nameUrls.get(i);

            for (int j = 0; j < actionNames.size(); j++) {
                String temp = actionNames.get(j);
                String pName = temp.replace("$", name);
                String pUrl = nameUrl + urls.get(j);

                permission.setId(sequence.nextId());
                permission.setName(pName);
                permission.setUrl(pUrl);
                System.out.println(permission);

                dao.insert(permission);
            }
        }
    }

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