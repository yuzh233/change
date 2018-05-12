package me.cathub.change.upms.rpc.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OpenUpmsServer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring/spring-upms-service.xml"});
        context.start();

        System.in.read(); // 按任意键退出
    }
}
