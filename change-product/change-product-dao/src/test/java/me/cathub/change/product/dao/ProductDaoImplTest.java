package me.cathub.change.product.dao;

import me.cathub.change.api.dao.product.ProductDao;
import me.cathub.change.common.util.key.Sequence;
import me.cathub.change.product.bean.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import static org.junit.Assert.*;

public class ProductDaoImplTest {
    static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-product-dao.xml");

    static ProductDao dao = context.getBean(ProductDaoImpl.class);
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
    public void list() throws Exception {
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
    public void listByBrandQuotientId() throws Exception {
        List<Product> products = dao.listByBrandQuotientId(1, 0, 100, 0);
        assertTrue(products.size() == dao.countByBrandQuotientId(1, 0));
    }

    @Test
    public void countByBrandQuotientId() {
    }

    @Test
    public void listByCompanyId() throws Exception {
        List<Product> products = dao.listByCompanyId(1, 0, 100, 0);
        assertTrue(products.size() == dao.countByCompanyId(1, 0));
    }

    @Test
    public void countByCompanyId() {
    }

    @Test
    public void listByProductCategoryIdAndCompanyId() throws Exception {
        List<Product> products = dao.listByProductCategoryIdAndCompanyId(1, 2, 0, 100, 0);
        assertTrue(products.size() == dao.countByProductCategoryIdAndCompanyId(1, 2, 0));
    }

    @Test
    public void countByProductCategoryIdAndCompanyId() {
    }

    @Test
    public void listByProductCategoryId() throws Exception {
        List<Product> products = dao.listByProductCategoryId(1, 0, 100, 0);
        assertTrue(products.size() == dao.countByProductCategoryId(1, 0));
    }

    @Test
    public void countByProductCategoryId() {
    }

    @Test
    public void listByName() throws Exception {
        dao.listByName("儿童", 0, 100, 0).stream()
                .forEach(System.out::println);
    }

    @Test
    public void search() throws Exception {
//        dao.listBySearch("儿童", 0, 5, new String[] {"price"}, true, 0, 200, 0).stream()
//                .forEach(System.out::println);

        System.out.println(dao.countBySearch("儿童", 0, 5, 0));
    }

    public static void main(String[] args) throws Exception {
//        ExecutorService exec = Executors.newCachedThreadPool();
//        //只允许5个线程同时访问
//        final Semaphore semp = new Semaphore(5);
//
//        int COUNT = 500;
//        int page = dao.count(0);
//        page = page % COUNT == 0 ? page / COUNT : page / COUNT + 1;
//
//        for (int i = 0; i < page; i++) {
//            final int temp = i;
//            Runnable run = new Runnable() {
//                public void run() {
//                    try {
//                        semp.acquire();
//
//                        dao.list(temp, COUNT, 0).stream()
//                                .forEach(bean -> System.out.println(semp.availablePermits() + " : " + bean));
//
//                        semp.release();
//                    }catch(Exception e){
//                        e.printStackTrace();
//                    }
//                }
//            };
//            exec.execute(run);
//        }
//        exec.shutdown();
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\cheng\\Desktop\\[ CHANGE ]\\productData.txt")));
//        dao.list(0, Integer.MAX_VALUE, 0).stream()
//                .map(bean -> {
//                    writer.write(bean.getId() + ":");
//                });
//        System.out.println("END");
    }

    static class Task extends Thread {
        private Semaphore semaphore;
        private int page;
        private int size;
        private ProductDao productDao;

        public Task(Semaphore semaphore, int page, int size, ProductDao productDao) {
            this.semaphore = semaphore;
            this.page = page;
            this.size = size;
            this.productDao = productDao;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                productDao.list(page, size, 0).stream()
                        .forEach(bean -> System.out.println(semaphore.getQueueLength() + " : " + bean));
                semaphore.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}