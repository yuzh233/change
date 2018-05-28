package me.cathub.change.wallet.dao;

import me.cathub.change.api.dao.wallet.AliPayDao;
import me.cathub.change.common.bean.User;
import me.cathub.change.common.util.key.Sequence;
import me.cathub.change.wallet.bean.AliPay;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author cheng
 * @date 2018/5/28
 * @time 15:35
 */
public class AliPayDaoImplTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-wallet-dao.xml");
    AliPayDao aliPayDao = context.getBean(AliPayDaoImpl.class);
    Sequence sequence = new Sequence(0, 1);

    @Test
    public void insert() throws Exception {
        AliPay aliPay = new AliPay(sequence.nextId());
        aliPay.setAccount("787949900@qq.com");
        aliPay.setRealName("晨光");
        aliPay.setUser(new User(19980918));

        assertTrue(aliPayDao.insert(aliPay));

        AliPay select = aliPayDao.select(aliPay);

        assertEquals(select.getAccount(), aliPay.getAccount());
        assertEquals(select.getRealName(), aliPay.getRealName());

        aliPay.setAccount("***");
        assertTrue(aliPayDao.update(aliPay));
        assertEquals(aliPayDao.selectByUserId(19980918L, 0).getAccount(), aliPay.getAccount());

        assertFalse(aliPayDao.deleteP(aliPay));
        assertTrue(aliPayDao.deleteL(aliPay));
        assertTrue(aliPayDao.restore(aliPay));
        assertTrue(aliPayDao.deleteL(aliPay));
        assertTrue(aliPayDao.deleteP(aliPay));
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
    public void selectByUserId() {
    }
}