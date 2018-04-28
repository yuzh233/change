package me.cathub.change.db;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import me.cathub.change.api.rpc.server.order.OrderItemRpcServer;
import me.cathub.change.api.rpc.server.order.OrderRpcServer;
import me.cathub.change.api.rpc.server.product.*;
import me.cathub.change.api.rpc.server.storehouse.StorehouseCountryRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseProductStockRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseRpcServer;
import me.cathub.change.api.rpc.server.upms.PermissionRpcServer;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.api.rpc.server.user.*;
import me.cathub.change.db.bean.Product;
import me.cathub.change.product.bean.ProductCategory;
import me.cathub.change.user.bean.BrandQuotient;
import me.cathub.change.user.bean.Company;
import me.cathub.change.user.bean.OnlineStore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.nio.charset.Charset;

/**
 * 填充数据
 */
public class FillDate {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo-consumer.xml");

    PermissionRpcServer permissionRpcServer = (PermissionRpcServer) context.getBean("permissionRpcServer");
    RoleRpcServer roleRpcServer = (RoleRpcServer) context.getBean("roleRpcServer");

    OnlineStoreRpcServer onlineStoreRpcServer = (OnlineStoreRpcServer) context.getBean("onlineStoreRpcServer");
    CompanyRpcServer companyRpcServer = (CompanyRpcServer) context.getBean("companyRpcServer");
    AuditingRpcServer auditingRpcServer = (AuditingRpcServer) context.getBean("auditingRpcServer");
    AdminRpcServer adminRpcServer = (AdminRpcServer) context.getBean("adminRpcServer");
    ShopkeeperRpcServer shopkeeperRpcServer = (ShopkeeperRpcServer) context.getBean("shopkeeperRpcServer");
    BrandQuotientRpcServer brandQuotientRpcServer = (BrandQuotientRpcServer) context.getBean("brandQuotientRpcServer");

    ProductReviewRpcServer productReviewRpcServer = (ProductReviewRpcServer) context.getBean("productReviewRpcServer");
    ProductRpcServer productRpcServer = (ProductRpcServer) context.getBean("productRpcServer");
    ProductImageRpcServer productImageRpcServer = (ProductImageRpcServer) context.getBean("productImageRpcServer");
    PropertyRpcServer propertyRpcServer = (PropertyRpcServer) context.getBean("propertyRpcServer");
    ProductCategoryRpcServer productCategoryRpcServer = (ProductCategoryRpcServer) context.getBean("productCategoryRpcServer");
    PropertyValueRpcServer propertyValueRpcServer = (PropertyValueRpcServer) context.getBean("propertyValueRpcServer");

    StorehouseProductStockRpcServer storehouseProductStockRpcServer = (StorehouseProductStockRpcServer) context.getBean("storehouseProductStockRpcServer");
    StorehouseRpcServer storehouseRpcServer = (StorehouseRpcServer) context.getBean("storehouseRpcServer");
    StorehouseCountryRpcServer storehouseCountryRpcServer = (StorehouseCountryRpcServer) context.getBean("storehouseCountryRpcServer");

    OrderItemRpcServer orderItemRpcServer = (OrderItemRpcServer) context.getBean("orderItemRpcServer");
    OrderRpcServer orderRpcServer = (OrderRpcServer) context.getBean("orderRpcServer");

    @Test
    public void initCategory() throws Exception {
        File jsonFile = new File("C:\\Users\\cheng\\Desktop\\DATA\\categorys\\kj.1688.com\\bc3ed2297ade92e01f37506df2ede378.json");
        JSONObject json = JSONUtil.readJSONObject(jsonFile, Charset.defaultCharset());
        JSONArray categorys = JSONUtil.parseArray(json.get("categorys"));
        for (Object category : categorys) {
            String categoryName = (String) JSONUtil.getByPath(JSONUtil.parse(category), "name");

            ProductCategory productCategory = new ProductCategory();
            productCategory.setName(categoryName);

//            productCategoryRpcServer.insert(productCategory);
        }
    }

    @Test
    public void initProduct() throws Exception {
        File dir = new File("C:\\Users\\cheng\\Desktop\\DATA\\products");
        File[] jsonDirs = dir.listFiles();

        int count = 0;
        for (File jsonDir:jsonDirs) {
            File[] jsonFiles = jsonDir.listFiles();
            for (File jsonFile:jsonFiles) {
                JSONObject json = JSONUtil.readJSONObject(jsonFile, Charset.defaultCharset());

                Object temp_obj = JSONUtil.getByPath(json, "products");
                if (temp_obj == null) {
                    System.out.println("ERROR : target :" + jsonFile.getName());
                    continue;
                }
                JSONArray products = JSONUtil.parseArray(temp_obj);

                for (Object product:products) {
                    Product temp = JSONUtil.toBean(product.toString(), Product.class);

                    String company_name = temp.getCompany_name();
                    String image_url = temp.getImage_url();
                    String name = temp.getName();
                    float price = temp.getPrice();

                    ProductCategory category = productCategoryRpcServer.selectByName(jsonDir.getName(), 0);
                    Company company = companyRpcServer.selectByName(company_name, 0);
                    if (company == null) {
                        company = new Company();
                        company.setName(company_name);

                        companyRpcServer.insert(company);

                        System.out.println(company.getId());
                        System.out.println(company.getId());
                    }


//                    me.cathub.change.product.bean.Product p = new me.cathub.change.product.bean.Product();
//                    p.setName(name);
//                    p.setBrandQuotient();

                    count ++;
                }
            }
        }
        System.out.println("INFO COUNT:" + count);
    }
}
