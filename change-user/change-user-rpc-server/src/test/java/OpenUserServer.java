import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OpenUserServer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring/spring-user-service.xml"});
        context.start();

        BrandQuotientRpcServer server = (BrandQuotientRpcServer) context.getBean("brandQuotientRpcServer");
        System.out.println(server.selectByName("21735930800898048", 0, true));

        System.in.read(); // 按任意键退出
    }
}