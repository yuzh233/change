package me.cathub.change.order.rpc.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OpenOrderServer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring/spring-order-service.xml"});
        context.start();
        System.in.read(); // 按任意键退出
    }
}
