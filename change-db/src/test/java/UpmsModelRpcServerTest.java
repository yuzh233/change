import me.cathub.change.api.rpc.server.upms.PermissionRpcServer;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UpmsModelRpcServerTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo-consumer.xml");

    PermissionRpcServer permissionRpcServer = (PermissionRpcServer) context.getBean("permissionRpcServer");
    RoleRpcServer roleRpcServer = (RoleRpcServer) context.getBean("roleRpcServer");

    @Test
    public void foreachPermission() throws Exception {
        roleRpcServer.list(0, 100, 0, false).stream()
                .forEach(System.out::println);
    }
}