package me.cathub.change.user.rpc.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 开启User模块Rpc服务
 *
 * @author cheng
 */
public class OpenUserServer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring/spring-user-service.xml"});
        context.start();
        System.in.read(); // 按任意键退出
    }
}