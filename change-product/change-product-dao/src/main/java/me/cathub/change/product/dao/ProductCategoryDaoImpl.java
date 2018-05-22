package me.cathub.change.product.dao;

import me.cathub.change.api.dao.product.ProductCategoryDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.product.bean.ProductCategory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品分类Dao实现类
 *
 * @author cheng
 */
@Repository
public class ProductCategoryDaoImpl extends BaseDaoMyBatisImpl<ProductCategory> implements ProductCategoryDao {

    @Override
    public boolean insert(ProductCategory bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(ProductCategory bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(ProductCategory bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(ProductCategory bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(ProductCategory bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public ProductCategory select(ProductCategory bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<ProductCategory> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<ProductCategory> listByDel(int page, int count, int tableIndex) throws Exception {
        return listByDel(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int countByDel(int tableIndex) throws Exception {
        return countByDel(NAME_SPACE, tableIndex);
    }

    @Override
    public int clear(int tableIndex) throws Exception {
        return clear(NAME_SPACE, tableIndex);
    }

    @Override
    public ProductCategory selectByName(String name, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("name", name);
        map.put("tableIndex", tableIndex);

        return searchOne(NAME_SPACE + SELECT_BY_NAME, map);
    }

    @Override
    public List<ProductCategory> childListById(long id, int page, int count, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("id", id);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + CHILD_LIST_BY_ID, page, count, map);
    }

    @Override
    public int childCountById(long id, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("id", id);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + CHILD_COUNT_BY_ID, map);
    }
}