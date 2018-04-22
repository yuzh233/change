package me.cathub.change.api.dao.product;


import me.cathub.change.common.base.BaseCrud;
import me.cathub.change.product.bean.Property;

import java.util.List;

public interface PropertyDao extends BaseCrud<Property> {
    String NAME_SPACE = "me.cathub.change.product.bean.Property";

    String LIST_BY_PRODUCT_CATEGORY_ID = ".listByProductCategoryId";
    String COUNT__BY_PRODUCT_CATEGORY_ID = ".countByProductCategoryId";

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
}