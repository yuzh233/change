package me.cathub.change.apply.home.controller;

import me.cathub.change.api.rpc.server.product.ProductCategoryRpcServer;
import me.cathub.change.api.rpc.server.product.ProductImageRpcServer;
import me.cathub.change.api.rpc.server.product.ProductRpcServer;
import me.cathub.change.api.rpc.server.storehouse.StorehouseProductStockRpcServer;
import me.cathub.change.api.rpc.server.user.CompanyRpcServer;
import me.cathub.change.apply.common.ListUtils;
import me.cathub.change.apply.common.ProductPageResult;
import me.cathub.change.apply.common.QueryHelper;
import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.ProductCategory;
import me.cathub.change.product.bean.ProductImage;
import me.cathub.change.storehouse.bean.StorehouseProductStock;
import me.cathub.change.user.bean.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 首页
 * data:
 * 商品一级分类、每个分类9个商品
 * 每日上新 : 8个商品
 * 排行榜 : 12个商品
 * 优选供应商 : n个企业
 * 各个分类 : 8个商品
 *
 * @Author: z.yu
 * @Date: 2018/05/25 15:16
 * @Description: 主页控制器
 */
@Controller
public class IndexPageController {

    @Autowired
    private ServletContext servletContext;
    @Autowired
    private ProductCategoryRpcServer productCategoryRpcServer;
    @Autowired
    private ProductRpcServer productRpcServer;
    @Autowired
    private ProductImageRpcServer imageRpcServer;
    @Autowired
    private CompanyRpcServer companyRpcServer;
    @Autowired
    private StorehouseProductStockRpcServer storehouseProductStockRpcServer;

    /**
     * 返回home页面
     */
    @RequestMapping({"/", "/index.jsp"})
    public ModelAndView index(ModelAndView modelAndView) throws Exception {
        Map map = (Map) servletContext.getAttribute("oneCategory");
        if (map == null) {
            map = oneLevelCategoryList();
            servletContext.setAttribute("oneCategory", map);
        }
        modelAndView = new ModelAndView("index");
        modelAndView.addObject("categoryMap", map);
        return modelAndView;
    }

    /**
     * 初始化一级分类信息
     */
    @ResponseBody
    public Map oneLevelCategoryList() throws Exception {
        List<ProductCategory> pcl = productCategoryRpcServer.list(1, 100, 0, true);
        //存放所有的分类id
        List<String> ids = new ArrayList<>();
        //存放所有的分类名
        List<String> names = new ArrayList<>();
        for (ProductCategory pc : pcl) {
            long id = pc.getId();
            ids.add(String.valueOf(id));
            String name = pc.getName();
            names.add(name);
        }
        //拆分List，每三个一组。如key="123/456/789" value="男装/女装/数码"
        ids = ListUtils.splitList(ids);
        names = ListUtils.splitList(names);

        //存放 分类id-分类 键值对
        Map categoryMap = new LinkedHashMap<String, String>();
        for (int i = 0; i < ids.size(); i++) {
            categoryMap.put(ids.get(i), names.get(i));
        }
        return categoryMap;
    }

    /**
     * 初始化二级分类对象信息
     *
     * @param ids 121231 / 12313 / 1231321
     * @return key = 一级分类名  value = 二级分类对象集合
     */
    public Map<String, List<ProductCategory>> initTwoLevelCategoryList(String ids) throws Exception {
        String[] str = ids.split("/");
        long[] str2 = new long[str.length];
        for (int i = 0; i < str.length; i++) {
            str2[i] = Long.parseLong(str[i].trim());
        }

        Map<String, List<ProductCategory>> map = new LinkedHashMap<>();
        for (long id : str2) {
            ProductCategory oneLevel = productCategoryRpcServer.select(new ProductCategory(id), true);
            List<ProductCategory> twoLevelList = productCategoryRpcServer.childListById(id, 0, 50, 0, true);
            map.put(oneLevel.getName(), twoLevelList);
        }
        return map;
    }

    /**
     * 展示所有二级分类
     */
    @RequestMapping("/twoLevelCategory")
    @ResponseBody
    public Object twoLevelCategoryList(@RequestParam String ids) throws Exception {
        Map twoCategory = (Map) servletContext.getAttribute("twoCategory");
        Map<String, List<ProductCategory>> map = null;
        if (twoCategory != null) {
            map = (Map<String, List<ProductCategory>>) twoCategory.get(ids);
            if (map == null) {
                map = initTwoLevelCategoryList(ids);
            }
        } else {
            map = initTwoLevelCategoryList(ids);
        }
        return map;
    }

    /**
     * 容器启动加载分类信息到内存
     */
    @PostConstruct
    public void initCategoryInfo() throws Exception {
        System.out.println("--------->>> 初始化分类信息 <<<----------");
        Map map = (Map) servletContext.getAttribute("oneCategory");
        if (map == null) {
            map = oneLevelCategoryList();
            servletContext.setAttribute("oneCategory", map);
        }

        Map<String, Map<String, List<ProductCategory>>> twoCategory = new HashMap<>();
        //key = 1111 / 222 /333  value = 男装/女装/鞋靴
        Map<String, String> oneCategory = (Map<String, String>) servletContext.getAttribute("oneCategory");
        for (String str : oneCategory.keySet()) {
            //key = 一级分类名  value = 二级分类对象集合
            Map<String, List<ProductCategory>> two = initTwoLevelCategoryList(str);
            twoCategory.put(str, two);
        }
        servletContext.setAttribute("twoCategory", twoCategory);
    }

    /**
     * 分类商品列表
     */
    @RequestMapping("/categoryAndProductData")
    @ResponseBody
    public QueryHelper categoryAndProductData(QueryHelper q) throws Exception {
        //查询总记录数
        int count = storehouseProductStockRpcServer.countByStorehouseIdAndProductCategoryId(27145893731905536L, q.getCategoryId(), 0);
        q.setTotalCount(count);
        int totalPage = count % q.getCount() == 0 ? count / q.getCount() : count / q.getCount() + 1;
        q.setTotalPage(totalPage);

        //查询产品
        List<StorehouseProductStock> sps = storehouseProductStockRpcServer.listByStorehouseIdAndProductCategoryId(27145893731905536L, q.getCategoryId(), q.getPage(), q.getCount(), 0, false);


        //把仓库产品库存对象集合抽取出产品对象生成集合
        List<Product> productList = sps.stream().map((p) -> p.getProduct()).collect(Collectors.toList());
        List<ProductPageResult> pageResultList = getProductAndImageList(productList);

        q.setProductPageResultList(pageResultList);
        return q;
    }

    /**
     * 返回新商品列表
     */
    @RequestMapping("/newProduct")
    @ResponseBody
    public List newProduct() throws Exception {
        List<StorehouseProductStock> sps = storehouseProductStockRpcServer.list(4, 12, 0, false);
        List<Product> productList = sps.stream().map((p) -> p.getProduct()).collect(Collectors.toList());
        return getProductAndImageList(productList);
    }

    /**
     * 通用获取产品显示对象的方法
     */
    public List<ProductPageResult> getProductAndImageList(List<Product> productList) throws Exception {
        List<ProductPageResult> productPageResultList = new ArrayList<>();
        for (Product product : productList) {
            //0：产品封面图片
            List<ProductImage> image = imageRpcServer.listByProductIdAndImageType(product.getId(), 0, 1, 1, 0, true);
            //产品结果对象 包含产品+产品图片
            ProductPageResult productPageResult = new ProductPageResult(product, image.size() != 0 ? image.get(0) : null);
            productPageResultList.add(productPageResult);
        }
        return productPageResultList;
    }

    /**
     * 返回商品排行榜
     */
    @RequestMapping("/rankingList")
    @ResponseBody
    public Map<Integer, ProductPageResult> rankingList() throws Exception {

        List<StorehouseProductStock> sps = storehouseProductStockRpcServer.list(5, 12, 0, false);
        List<Product> productList = sps.stream().map((p) -> p.getProduct()).collect(Collectors.toList());

        Map<Integer, ProductPageResult> map = new LinkedHashMap<>();
        List<ProductPageResult> productPageResultList = getProductAndImageList(productList);
        for (int i = 0; i < productPageResultList.size(); i++) {
            map.put(i + 1, productPageResultList.get(i));
        }
        return map;
    }

    /**
     * 返回优选企业
     */
    @RequestMapping("/companyList")
    @ResponseBody
    public List<Company> companyList() throws Exception {
        List<Company> companyList = companyRpcServer.list(1, 12, 0, true);
        return companyList;
    }

    /**
     * 返回某类别的优选商品
     */
    @RequestMapping("/categoryProductList")
    @ResponseBody
    public List<ProductPageResult> categoryProductList(@RequestParam String categoryName) throws Exception {
        //获取分类
        ProductCategory productCategory = productCategoryRpcServer.selectByName(categoryName, 0, true);
        if (productCategory != null) {
            //获取产品列表
            List<StorehouseProductStock> sps = storehouseProductStockRpcServer.listByStorehouseIdAndProductCategoryId(27145893731905536L, productCategory.getId(),1, 8, 0, false);
            List<Product> productList = sps.stream().map((p) -> p.getProduct()).collect(Collectors.toList());
            if (productList != null) {
                //封装产品+图片结果集列表
                List<ProductPageResult> productPageResultList = getProductAndImageList(productList);
                return productPageResultList;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
