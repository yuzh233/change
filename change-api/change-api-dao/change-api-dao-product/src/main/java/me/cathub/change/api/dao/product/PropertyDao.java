package me.cathub.change.api.dao.product;


import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.common.bean.product.Property;

import java.util.List;

public interface PropertyDao extends BaseDao<Property>, DaoSelectByName<Property> {
    String NAME_SPACE = "Property";

    String LIST_BY_PRODUCT_CATEGORY_ID = ".listByProductCategoryId";
    String COUNT__BY_PRODUCT_CATEGORY_ID = ".countByProductCategoryId";
    String SELECT_BY_NAME_AND_PRODUCT_CATEGORY = ".selectByNameAndProductCategory";

    /**
     * 根据产品分类获取属性列表
     * @param productCategory_id
     * @param page
     * @param count
     * @return
     * @throws Exception
     */
    List<Property> listByProductCategoryId(long productCategory_id, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据产品分类获取属性数量
     * @param productCategory_id
     * @return
     * @throws Exception
     */
    int countByProductCategoryId(long productCategory_id, int tableIndex) throws Exception;

    /**
     * 根据属性名和产品分类获取属性
     * @param name
     * @param productCategory_id
     * @param tableIndex
     * @return
     * @throws Exception
     */
    Property selectByNameAndProductCategory(String name, long productCategory_id, int tableIndex) throws Exception;
}