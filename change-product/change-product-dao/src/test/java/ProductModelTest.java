import me.cathub.change.api.dao.product.*;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.product.bean.ProductCategory;
import me.cathub.change.product.dao.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductModelTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-product-dao.xml");
    ProductCategoryDao productCategoryDao = context.getBean(ProductCategoryDaoImpl.class);
    ProductDao productDao = context.getBean(ProductDaoImpl.class);
    ProductImageDao productImageDao = context.getBean(ProductImageDaoImpl.class);
    ProductReviewDao productReviewDao = context.getBean(ProductReviewDaoImpl.class);
    PropertyDao propertyDao = context.getBean(PropertyDaoImpl.class);
    PropertyValueDao propertyValueDao = context.getBean(PropertyValueDaoImpl.class);

    Sequence sequence = new Sequence(2, 0);

    @Test
    public void addProductTest() throws Exception {
        ProductCategory sub = new ProductCategory(sequence.nextId());
        sub.setName("内衣");
        productCategoryDao.insert(sub);
    }
}
