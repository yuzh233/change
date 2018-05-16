package me.cathub.change.api.dao.product;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.product.bean.Property;

import java.util.List;

/**
 * 属性Dao接口
 *
 * @author cheng
 */
public interface PropertyDao extends BaseDao<Property>, DaoSelectByName<Property> {
    String NAME_SPACE = "Property";

    String LIST_BY_PRODUCT_CATEGORY_ID = ".listByProductCategoryId";
    String COUNT__BY_PRODUCT_CATEGORY_ID = ".countByProductCategoryId";
    String SELECT_BY_NAME_AND_PRODUCT_CATEGORY = ".selectByNameAndProductCategory";

    /**
     * 根据产品分类获取属性列表
     * @param productCategoryId
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<Property> listByProductCategoryId(long productCategoryId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据产品分类获取属性数量
     * @param productCategoryId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByProductCategoryId(long productCategoryId, int tableIndex) throws Exception;

    /**
     * 根据属性名和产品分类获取属性
     * @param name
     * @param productCategoryId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    Property selectByNameAndProductCategory(String name, long productCategoryId, int tableIndex) throws Exception;
}