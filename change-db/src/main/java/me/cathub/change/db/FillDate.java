package me.cathub.change.db;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import me.cathub.change.api.rpc.server.product.*;
import me.cathub.change.api.rpc.server.upms.PermissionRpcServer;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.api.rpc.server.user.*;
import me.cathub.change.common.tool.HTTPTool;
import me.cathub.change.common.tool.aliyun.OSSAPI;
import me.cathub.change.db.bean.Product;
import me.cathub.change.product.bean.ProductCategory;
import me.cathub.change.user.bean.BrandQuotient;
import me.cathub.change.user.bean.Company;
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

//    StorehouseProductStockRpcServer storehouseProductStockRpcServer = (StorehouseProductStockRpcServer) context.getBean("storehouseProductStockRpcServer");
//    StorehouseRpcServer storehouseRpcServer = (StorehouseRpcServer) context.getBean("storehouseRpcServer");
//    StorehouseCountryRpcServer storehouseCountryRpcServer = (StorehouseCountryRpcServer) context.getBean("storehouseCountryRpcServer");

//    OrderItemRpcServer orderItemRpcServer = (OrderItemRpcServer) context.getBean("orderItemRpcServer");
//    OrderRpcServer orderRpcServer = (OrderRpcServer) context.getBean("orderRpcServer");

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

                // 获取分类
                ProductCategory category = productCategoryRpcServer.selectByName(jsonDir.getName(), 0, true);

                long b_id = 0;
                // 遍历该分类的产品
                for (Object product:products) {
                    Product temp = JSONUtil.toBean(product.toString(), Product.class);

                    String company_name = temp.getCompany_name();
                    String image_url = temp.getImage_url();

                    if (! image_url.contains(".jpg"))
                        continue;

                    String name = temp.getName();
                    float price = temp.getPrice();

                    // 获取企业
                    Company company = companyRpcServer.selectByName(company_name, 0, true);

                    // 不存在则插入
                    if (company == null) {
                        company = new Company();
                        company.setName(company_name);

                        long c_id = companyRpcServer.insert(company);
                        BrandQuotient brandQuotient = new BrandQuotient();
                        brandQuotient.setUsername(c_id + "");
                        brandQuotient.setPassword("root");
                        brandQuotient.setRole(roleRpcServer.selectByName("用户-品牌商", 0, true));
                        brandQuotient.setCompany(new Company(c_id));

                        b_id = brandQuotientRpcServer.insert(brandQuotient);
                        System.out.println(c_id);
                    }

                    // 填充产品数据
                    me.cathub.change.product.bean.Product p = new me.cathub.change.product.bean.Product();
                    p.setName(name);
                    p.setBrandQuotient(new BrandQuotient(b_id));
                    p.setPrice(price);
                    p.setProductCategory(category);

                    // 插入产品
                    long p_id = productRpcServer.insert(p);

                    // 填充产品图片数据
                    me.cathub.change.product.bean.ProductImage productImage = new me.cathub.change.product.bean.ProductImage();
                    productImage.setType(me.cathub.change.product.bean.ProductImage.TYPE_COVER);
                    productImage.setUrl(OSSAPI.getProductImgUrl(company_name, OSSAPI.getSuffix(image_url)));
                    productImage.setProduct(new me.cathub.change.product.bean.Product(p_id));

                    // 保存图片到OSS
                    OSSAPI.uploadResource(productImage.getUrl(), HTTPTool.getInputStream(image_url));

                    // 插入产品图片
                    productImageRpcServer.insert(productImage);
                    count ++;
                    System.out.println("SUCCESS :" + count);
                }
            }
        }
        System.out.println("INFO COUNT:" + count);
    }

    @Test
    public void delete() throws Exception {
        int count = productImageRpcServer.count(0);
        final int PAGE_COUNT = 200;

        final int TOTAL_PAGE = count % PAGE_COUNT == 0 ? count / PAGE_COUNT : count / PAGE_COUNT + 1;

        for (int p = 0; p < TOTAL_PAGE; p++) {
            productImageRpcServer.list(p, PAGE_COUNT, 0, false).stream()
                    .filter(bean -> bean.getProduct().getProductCategory_id() == 0)
                    .forEach(bean -> {

                        try {
                            /**
                             * 1. OSS 删除图片
                             * 2. 数据库删除 产品 and 产品图片
                             */
//                            OSSAPI.deleteObject(bean.getUrl());
                            productRpcServer.deleteL(bean.getProduct());
                            productImageRpcServer.deleteL(bean);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    @Test
    public void testAddImage() throws Exception {
        me.cathub.change.product.bean.Product product = new me.cathub.change.product.bean.Product();
        long insert = productRpcServer.insert(product);
        System.out.println(insert);
        me.cathub.change.product.bean.ProductImage productImage = new me.cathub.change.product.bean.ProductImage();
        productImage.setProduct(new me.cathub.change.product.bean.Product(insert));
        System.out.println(productImageRpcServer.insert(productImage));
    }

    @Test
    public void foreachProduct() throws Exception {
        adminRpcServer.list(0, 100, 0, true).stream()
                .forEach(System.out::println);
    }
}