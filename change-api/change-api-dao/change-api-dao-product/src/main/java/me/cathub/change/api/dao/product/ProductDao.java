package me.cathub.change.api.dao.product;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.product.bean.Product;

import java.util.List;

public interface ProductDao extends BaseDao<Product>, DaoSelectByName<Product> {
    String NAME_SPACE = "me.cathub.change.product.bean.Product";

    String LIST_BY_PRODUCT_CATEGORY_ID_AND_BRAND_QUOTIENT_ID = ".listByProductCategoryIdAndBrandQuotientId";
    String COUNT_BY_PRODUCT_CATEGORY_ID_AND_BRAND_QUOTIENT_ID = ".countByProductCategoryIdAndBrandQuotientId";
    String LIST_BY_PRODUCT_CATEGORY_ID = ".listByProductCategoryId";
    String COUNT_BY_PRODUCT_CATEGORY_ID = ".countByProductCategoryId";
    String LIST_BY_BRAND_QUOTIENT_ID = ".listByBrandQuotientId";
    String COUNT_BY_BRAND_QUOTIENT_ID = ".countByBrandQuotientId";

    /**
     * 根据品牌商获取产品列表
     * @param brandQuotient_id
     * @param page
     * @param count
     * @return
     * @throws Exception
     */
    List<Product> listByBrandQuotientId(long brandQuotient_id, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据品牌商获取产品数量
     * @param brandQuotient_id
     * @return
     * @throws Exception
     */
    int countByBrandQuotientId(long brandQuotient_id, int tableIndex) throws Exception;

    /**
     * 根据产品分类和品牌商获取产品列表
     * @param productCategory_id
     * @param brandQuotient_id
     * @param page
     * @param count
     * @return
     * @throws Exception
     */
    List<Product> listByProductCategoryIdAndBrandQuotientId(long productCategory_id, long brandQuotient_id, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据产品分类和品牌商获取产品数量
     * @param productCategory_id
     * @param brandQuotient_id
     * @return
     * @throws Exception
     */
    int countByProductCategoryIdAndBrandQuotientId(long productCategory_id, long brandQuotient_id, int tableIndex) throws Exception;

    /**
     * 根据产品分类获取产品列表
     * @param productCategory_id
     * @return
     * @throws Exception
     */
    List<Product> listByProductCategoryId(long productCategory_id, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据产品分类获取产品数量
     * @param productCategory_id
     * @return
     * @throws Exception
     */
    int countByProductCategoryId(long productCategory_id, int tableIndex) throws Exception;
}
