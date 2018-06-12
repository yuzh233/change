package me.cathub.change.api.dao.product;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.DaoSearchList;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.product.bean.Product;

import java.util.List;

/**
 * 产品Dao接口
 *
 * @author cheng
 */
public interface ProductDao extends BaseDao<Product>, DaoSearchList<Product> {
    String NAME_SPACE = "Product";

    String LIST_BY_COMPANY_ID = ".listByCompanyId";
    String COUNT_BY_COMPANY_ID = ".countByCompanyId";
    String LIST_BY_PRODUCT_CATEGORY_ID_AND_COMPANY_ID = ".listByProductCategoryIdAndCompanyId";
    String COUNT_BY_PRODUCT_CATEGORY_ID_AND_COMPANY_ID = ".countByProductCategoryIdAndCompanyId";
    String LIST_BY_PRODUCT_CATEGORY_ID = ".listByProductCategoryId";
    String COUNT_BY_PRODUCT_CATEGORY_ID = ".countByProductCategoryId";
    String LIST_BY_BRAND_QUOTIENT_ID = ".listByBrandQuotientId";
    String COUNT_BY_BRAND_QUOTIENT_ID = ".countByBrandQuotientId";
    String LIST_BY_SEARCH = ".listBySearch";
    String COUNT_BY_SEARCH = ".countBySearch";

    /**
     * 根据品牌商账号获取产品列表
     * @param brandQuotientId
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<Product> listByBrandQuotientId(long brandQuotientId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据品牌商账号获取产品数量
     * @param brandQuotientId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByBrandQuotientId(long brandQuotientId, int tableIndex) throws Exception;

    /**
     * 根据产品分类获取产品列表
     * @param productCategoryId
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<Product> listByProductCategoryId(long productCategoryId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据产品分类获取产品数量
     * @param productCategoryId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByProductCategoryId(long productCategoryId, int tableIndex) throws Exception;

    /**
     * 根据企业获取产品列表
     * @param companyId
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<Product> listByCompanyId(long companyId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据企业获取产品数量
     * @param companyId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByCompanyId(long companyId, int tableIndex) throws Exception;

    /**
     * 根据产品分类和企业获取产品列表
     * @param productCategoryId
     * @param companyId
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<Product> listByProductCategoryIdAndCompanyId(long productCategoryId, long companyId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据产品分类和企业获取产品数量
     * @param productCategoryId
     * @param companyId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByProductCategoryIdAndCompanyId(long productCategoryId, long companyId, int tableIndex) throws Exception;

    /**
     * 搜索
     * @param keyName
     * @param minPrice
     * @param maxPrice
     * @param sorts     排序依据
     * @param desc      true 升序
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<Product> listBySearch(String keyName, float minPrice, float maxPrice, String[] sorts, boolean desc, int page, int count, int tableIndex) throws Exception;

    /**
     * 搜索数量
     * @param keyName
     * @param minPrice
     * @param maxPrice
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countBySearch(String keyName, float minPrice, float maxPrice, int tableIndex) throws Exception;
}