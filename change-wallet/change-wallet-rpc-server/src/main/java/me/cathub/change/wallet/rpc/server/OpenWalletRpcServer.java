package me.cathub.change.wallet.rpc.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cheng
 * @date 2018/5/28
 * @time 18:56
 */
public class OpenWalletRpcServer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring/spring-wallet-service.xml"});
        context.start();
        System.in.read(); // 按任意键退出
    }
}
