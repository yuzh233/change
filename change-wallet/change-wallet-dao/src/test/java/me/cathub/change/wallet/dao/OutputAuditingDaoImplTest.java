package me.cathub.change.wallet.dao;

import me.cathub.change.api.dao.wallet.OutputAuditingDao;
import me.cathub.change.common.bean.User;
import me.cathub.change.common.util.key.Sequence;
import me.cathub.change.user.bean.Admin;
import me.cathub.change.wallet.bean.OutputAuditing;
import me.cathub.change.wallet.bean.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author cheng
 * @date 2018/5/28
 * @time 16:07
 */
public class OutputAuditingDaoImplTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-wallet-dao.xml");
    OutputAuditingDao outputAuditingDao = context.getBean(OutputAuditingDao.class);
    Sequence sequence = new Sequence(0, 1);

    @Test
    public void insert() throws Exception {
        OutputAuditing outputAuditing = new OutputAuditing(sequence.nextId());
        outputAuditing.setAdmin(new Admin(-1));
        outputAuditing.setUser(new User(-2));
        outputAuditing.setTransaction(new Transaction(-3));
        outputAuditing.setAmount(999);
        outputAuditing.setOutputType(OutputAuditing.OUTPUT_TYPE_ZFB);
        outputAuditing.setType(User.TYPE_SHOPKEEPER);

        assertTrue(outputAuditingDao.insert(outputAuditing));

        OutputAuditing select = outputAuditingDao.select(outputAuditing);

        assertEquals(outputAuditing.getAdmin().getId(), select.getAdminId());
        assertEquals(outputAuditing.getUser().getId(), select.getUserId());
        assertEquals(outputAuditing.getTransaction().getId(), select.getTransactionId());
        assertEquals(outputAuditing.getOutputType(), select.getOutputType());
        assertTrue(outputAuditing.getAmount() == select.getAmount());

        assertFalse(outputAuditingDao.deleteP(outputAuditing));
        assertTrue(outputAuditingDao.deleteL(outputAuditing));
        assertTrue(outputAuditingDao.restore(outputAuditing));
        assertTrue(outputAuditingDao.deleteL(outputAuditing));
        assertTrue(outputAuditingDao.deleteP(outputAuditing));
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
    public void listByAdminIdAndUserType() throws Exception {
        OutputAuditing outputAuditing = new OutputAuditing();
        ArrayList<OutputAuditing> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            outputAuditing.setId(sequence.nextId());
            outputAuditing.setType(User.TYPE_SHOPKEEPER);
            outputAuditing.setUser(new User(1999));
            outputAuditing.setAdmin(new Admin(-1));

            outputAuditingDao.insert(outputAuditing);
            list.add(outputAuditing);
        }

        outputAuditingDao.listByAdminIdAndUserType(-1, User.TYPE_SHOPKEEPER, 0, 100, 0)
                .forEach(System.out::println);

//        for (OutputAuditing temp : list) {
//            outputAuditingDao.deleteL(temp);
//            outputAuditingDao.deleteP(temp);
//        }
    }

    @Test
    public void countByAdminIdAndUserType() throws Exception {
        System.out.println(outputAuditingDao.countByAdminIdAndUserType(-1, User.TYPE_SHOPKEEPER, 0));
    }

    @Test
    public void listByNotAuditing() throws Exception {
        outputAuditingDao.listByNotAuditing(User.TYPE_SHOPKEEPER, 0, 100, 0)
                .forEach(System.out::println);
    }

    @Test
    public void countByNotAuditing() throws Exception {
        System.out.println(outputAuditingDao.countByNotAuditing(User.TYPE_SHOPKEEPER, 0));
    }

    @Test
    public void listByUserIdAndUserType() throws Exception {
        outputAuditingDao.listByUserIdAndUserType(1999, User.TYPE_SHOPKEEPER, 0, 100, 0)
                .forEach(System.out::println);
    }

    @Test
    public void countByUserIdAndUserType() throws Exception {
        System.out.println(outputAuditingDao.countByUserIdAndUserType(1999, User.TYPE_SHOPKEEPER, 0));
    }
}