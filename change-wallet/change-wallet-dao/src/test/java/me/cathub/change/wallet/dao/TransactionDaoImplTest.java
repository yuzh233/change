package me.cathub.change.wallet.dao;

import me.cathub.change.api.dao.wallet.TransactionDao;
import me.cathub.change.common.bean.User;
import me.cathub.change.common.util.key.Sequence;
import me.cathub.change.wallet.bean.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author cheng
 * @date 2018/5/28
 * @time 16:43
 */
public class TransactionDaoImplTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-wallet-dao.xml");
    TransactionDao transactionDao = context.getBean(TransactionDao.class);
    Sequence sequence = new Sequence(0, 1);

    @Test
    public void insert() throws Exception {
        Transaction transaction = new Transaction(sequence.nextId());
        transaction.setAmount(999);
        transaction.setMessage("message");
        transaction.setSendUser(new User(1));
        transaction.setReceiveUser(new User(-1));
        transaction.setType(Transaction.PAY_TYPE_ZFB);

        assertTrue(transactionDao.insert(transaction));

        Transaction select = transactionDao.select(transaction);
        assertEquals(transaction.getMessage(), select.getMessage());
        assertEquals(transaction.getSendUser().getId(), select.getSendUserId());
        assertEquals(transaction.getReceiveUser().getId(), select.getReceiveUserId());
        assertEquals(transaction.getReturnId(), select.getReturnId());
        assertEquals(transaction.getType(), select.getType());
        assertTrue(transaction.getAmount() == select.getAmount());

        transaction.setMessage("updateMessage");
        transaction.setReturnId("10000001");
        transaction.setStatus(Transaction.STATUS_SUCCESS);
        assertTrue(transactionDao.update(transaction));

        select = transactionDao.select(transaction);

        assertEquals(transaction.getMessage(), select.getMessage());
        assertEquals(transaction.getSendUser().getId(), select.getSendUserId());
        assertEquals(transaction.getReceiveUser().getId(), select.getReceiveUserId());
        assertEquals(transaction.getReturnId(), select.getReturnId());
        assertEquals(transaction.getType(), select.getType());
        assertTrue(transaction.getAmount() == select.getAmount());

        assertFalse(transactionDao.deleteP(transaction));
        assertTrue(transactionDao.deleteL(transaction));
        assertTrue(transactionDao.restore(transaction));
        assertTrue(transactionDao.deleteL(transaction));
        assertTrue(transactionDao.deleteP(transaction));
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
    public void listBySendUserId() throws Exception {
//        Transaction transaction = new Transaction();
//
//        for (int i = 0; i < 50; i++) {
//            transaction.setId(sequence.nextId());
//            transaction.setAmount(999);
//            transaction.setMessage("message");
//            transaction.setSendUser(new User(1));
//            transaction.setReceiveUser(new User(-1));
//            transaction.setPayType(Transaction.PAY_TYPE_ZFB);
//            transaction.setType(Transaction.TYPE_TRANS);
//
//            transactionDao.insert(transaction);
//        }

        transactionDao.listBySendUserId(1, 0, 100, 0)
                .forEach(System.out::println);
    }

    @Test
    public void countBySendUserId() throws Exception {
        System.out.println(transactionDao.countBySendUserId(1, 0));
    }

    @Test
    public void listByReceiveUserId() throws Exception {
        transactionDao.listByReceiveUserId(-1, 0, 100, 0)
                .forEach(System.out::println);
    }

    @Test
    public void countByReceiveUserId() throws Exception {
        System.out.println(transactionDao.countByReceiveUserId(-1, 0));
    }
}