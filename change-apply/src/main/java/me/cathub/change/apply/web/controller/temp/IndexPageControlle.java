package me.cathub.change.apply.web.controller.temp;

import me.cathub.change.product.bean.Product;
import me.cathub.change.product.bean.ProductCategory;
import me.cathub.change.user.bean.Company;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 首页
 *  data:
 *      商品一级分类、每个分类9个商品
 *      每日上新 : 8个商品
 *      排行榜 : 12个商品
 *      优选供应商 : n个企业
 *      各个分类 : 8个商品
 */
@Controller
public class IndexPageControlle {

    /**
     * 返回HTML页面
     * @return
     * @throws Exception
     */
    @RequestMapping("/")
    public String index() throws Exception {
        return "index";
    }

    /**
     * 返回分类:商品信息
     * @return
     * @throws Exception
     */
    @RequestMapping("/categoryAndProductData")
    @ResponseBody
    public Map<ProductCategory, List<Product>> categoryAndProductData() throws Exception {
        return null;
    }

    /**
     * 返回新商品列表
     * @return
     * @throws Exception
     */
    @RequestMapping("/newProduct")
    @ResponseBody
    public List<Product> newProduct() throws Exception {
        return null;
    }

    /**
     * 返回商品排行榜
     * @return
     * @throws Exception
     */
    @RequestMapping("/rankingList")
    @ResponseBody
    public Map<Integer, List<Product>> rankingList() throws Exception {
        return null;
    }

    /**
     * 返回优选企业
     * @return
     * @throws Exception
     */
    @RequestMapping("/companyList")
    @ResponseBody
    public List<Company> companyList() throws Exception {
        return null;
    }

    /**
     * 返回某类别的优选商品
     * @return
     * @throws Exception
     */
    @RequestMapping("/categoryProductList")
    @ResponseBody
    public List<Product> categoryProductList() throws Exception {
        return null;
    }
}
