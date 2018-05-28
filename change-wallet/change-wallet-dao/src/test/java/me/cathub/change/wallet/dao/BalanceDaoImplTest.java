package me.cathub.change.wallet.dao;

import me.cathub.change.api.dao.wallet.BalanceDao;
import me.cathub.change.common.bean.User;
import me.cathub.change.common.util.key.Sequence;
import me.cathub.change.wallet.bean.Balance;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author cheng
 * @date 2018/5/28
 * @time 15:55
 */
public class BalanceDaoImplTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-wallet-dao.xml");
    BalanceDao balanceDao = context.getBean(BalanceDao.class);
    Sequence sequence = new Sequence(0, 1);

    @Test
    public void insert() throws Exception {
        Balance balance = new Balance(sequence.nextId());
        balance.setBalance(99.99F);
        balance.setUser(new User(19980918));
        balance.setType(User.TYPE_SHOPKEEPER);

        assertTrue(balanceDao.insert(balance));

        Balance s0 = balanceDao.select(balance);
        Balance s1 = balanceDao.selectByUserId(19980918, 0);

        System.out.println(balance);
        System.out.println(s0);
        System.out.println(s1);

        balance.setBalance(787949900.89F);
        assertTrue(balanceDao.update(balance));

        s0 = balanceDao.select(balance);
        s1 = balanceDao.selectByUserId(19980918, 0);

        System.out.println(balance);
        System.out.println(s0);
        System.out.println(s1);

        assertFalse(balanceDao.deleteP(balance));
        assertTrue(balanceDao.deleteL(balance));
        assertTrue(balanceDao.restore(balance));
        assertTrue(balanceDao.deleteL(balance));
        assertTrue(balanceDao.deleteP(balance));
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