package me.cathub.change.db;

import me.cathub.change.api.rpc.server.upms.PermissionRpcServer;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: z.yu
 * DateTime: 2018-04-29 12:56
 * Description:
 */
public class UpmsModelRpcServerTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo-consumer.xml");

    PermissionRpcServer permissionRpcServer = (PermissionRpcServer) context.getBean("permissionRpcServer");
    RoleRpcServer roleRpcServer = (RoleRpcServer) context.getBean("roleRpcServer");

    @Test
    public void test() throws Exception {
        permissionRpcServer.list(0, 100, 0, true).stream()
                .forEach(System.out::println);
    }
}
