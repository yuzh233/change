package me.cathub.change.api.dao.product;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.product.bean.PropertyValue;

import java.util.List;

/**
 * 属性值Dao接口
 *
 * @author cheng
 */
public interface PropertyValueDao extends BaseDao<PropertyValue> {
    String NAME_SPACE = "PropertyValue";

    String LIST_BY_PRODUCT_ID = ".listByProductId";
    String COUNT_BY_PRODUCT_ID = ".countByProductId";

    /**
     * 根据产品获取属性值列表
     * @param productId     产品id
     * @param page          当前页
     * @param count         页数量
     * @param tableIndex    表索引
     * @return              属性值列表
     * @throws Exception    Sql throw exception
     */
    List<PropertyValue> listByProductId(long productId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据产品获取属性值数量
     * @param productId     产品id
     * @param tableIndex    表索引
     * @return              属性值数量
     * @throws Exception    Sql throw exception
     */
    int countByProductId(long productId, int tableIndex) throws Exception;
}