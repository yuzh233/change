import me.cathub.change.api.dao.product.*;
import me.cathub.change.common.bean.product.Product;
import me.cathub.change.common.bean.product.Property;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.common.bean.product.ProductCategory;
import me.cathub.change.product.dao.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

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
    public void addProperty() throws Exception {
        Property property = new Property();
        property.setName("test");
        propertyDao.insert(property);
    }

    @Test
    public void addProductTest() throws Exception {
        ProductCategory sub = productCategoryDao.selectByName("男装",0);
        System.out.println(sub);
    }

    @Test
    public void getProduct() throws Exception {
        propertyValueDao.listByProductId(21736753882734592l, 0, 100, 0).stream()
                .forEach(bean -> {
                    try {
                        String name = propertyDao.select(new Property(bean.getProperty_id())).getName();
                        System.out.println(name + ":" + bean.getValue());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}
