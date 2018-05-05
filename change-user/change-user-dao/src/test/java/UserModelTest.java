import me.cathub.change.api.dao.user.AdminDao;
import me.cathub.change.api.dao.user.AuditingDao;
import me.cathub.change.api.dao.user.BrandQuotientDao;
import me.cathub.change.api.dao.user.CompanyDao;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.upms.bean.Role;
import me.cathub.change.user.bean.*;
import me.cathub.change.user.dao.AdminDaoImpl;
import me.cathub.change.user.dao.AuditingDaoImpl;
import me.cathub.change.user.dao.BrandQuotientDaoImpl;
import me.cathub.change.user.dao.CompanyDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserModelTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-user-dao.xml");
    AdminDao adminDao = context.getBean(AdminDaoImpl.class);
    AuditingDao auditingDao = context.getBean(AuditingDaoImpl.class);
    BrandQuotientDao brandQuotientDao = context.getBean(BrandQuotientDaoImpl.class);
    CompanyDao companyDao = context.getBean(CompanyDaoImpl.class);

    Sequence sequence = new Sequence(1, 0);

    @Test
    public void test() throws Exception {
        // 19873986099806208
        long[] arr = new long[] {19873941703098368l, 19872888647581696l};
        Admin admin = new Admin(sequence.nextId());
        int count = 0;
        admin.setRole(new Role(19873986099806208l));
        admin.setUsername("admin" + count ++);
        adminDao.insert(admin);

        for (long id:arr) {
            admin.setRole(new Role(id));
            for (int i = 0; i < 15; i++) {
                admin.setId(sequence.nextId());
                admin.setUsername("admin" + count++);
                adminDao.insert(admin);
            }
        }
    }

    @Test
    public void test01() throws Exception {
        BrandQuotient brandQuotient = brandQuotientDao.selectByName("B_jjyt", 0);
    }

    @Test
    public void test02() throws Exception {
    }
}
