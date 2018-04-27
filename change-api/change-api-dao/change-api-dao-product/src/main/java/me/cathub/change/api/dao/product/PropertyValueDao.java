package me.cathub.change.api.dao.product;

import me.cathub.change.common.base.BaseCrud;
import me.cathub.change.product.bean.PropertyValue;

import java.util.List;

public interface PropertyValueDao extends BaseCrud<PropertyValue> {
    String NAME_SPACE = "me.cathub.change.product.bean.PropertyValue";

    String LIST_BY_PRODUCT_ID = ".listByProductId";
    String COUNT_BY_PRODUCT_ID = ".countByProductId";

    /**
     * 根据产品获取属性值列表
     * @param product_id
     * @return
     * @throws Exception
     */
    List<PropertyValue> listByProductId(long product_id, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据产品获取属性值数量
     * @param product_id
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByProductId(long product_id, int tableIndex) throws Exception;
}