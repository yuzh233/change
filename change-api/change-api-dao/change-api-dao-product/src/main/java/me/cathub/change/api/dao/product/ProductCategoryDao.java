package me.cathub.change.api.dao.product;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.common.bean.product.ProductCategory;

import java.util.List;

public interface ProductCategoryDao extends BaseDao<ProductCategory>, DaoSelectByName<ProductCategory> {
    String NAME_SPACE = "ProductCategory";

    String CHILD_LIST_BY_ID = ".childListById";
    String CHILD_COUNT_BY_ID = ".childCountById";

    /**
     * 根据id获取子分类列表
     * @param id
     * @return
     * @throws Exception
     */
    List<ProductCategory> childListById(long id, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据id获取子分类数量
     * @param id
     * @return
     * @throws Exception
     */
    int childCountById(long id, int tableIndex) throws Exception;
}
