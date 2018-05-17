package me.cathub.change.api.dao.product;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.product.bean.ProductCategory;

import java.util.List;

/**
 * 产品分类Dao接口
 *
 * @author cheng
 */
public interface ProductCategoryDao extends BaseDao<ProductCategory>, DaoSelectByName<ProductCategory> {
    String NAME_SPACE = "ProductCategory";

    String CHILD_LIST_BY_ID = ".childListById";
    String CHILD_COUNT_BY_ID = ".childCountById";

    /**
     * 根据id获取子分类列表
     * @param id            分类id
     * @param page          当前页
     * @param count         页数量
     * @param tableIndex    表索引
     * @return              子分类列表
     * @throws Exception    Sql throw exception
     */
    List<ProductCategory> childListById(long id, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据id获取子分类数量
     * @param id            分类id
     * @param tableIndex    表索引
     * @return              子分类数量
     * @throws Exception    Sql throw exception
     */
    int childCountById(long id, int tableIndex) throws Exception;
}
