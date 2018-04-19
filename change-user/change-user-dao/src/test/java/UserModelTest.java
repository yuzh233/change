import me.cathub.change.api.dao.user.AdminDao;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.user.dao.AdminDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserModelTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-user-dao.xml");
    AdminDao adminDao = context.getBean(AdminDaoImpl.class);

    Sequence sequence = new Sequence(0, 0);

    @Test
    public void test() throws Exception {
        adminDao.list(1,100, 0).forEach(i -> System.out.println(i));
    }
}
