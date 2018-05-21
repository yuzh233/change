package me.cathub.change.product.dao;

import me.cathub.change.api.dao.product.PropertyDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.product.bean.Property;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 属性Dao实现类
 *
 * @author cheng
 */
@Repository
public class PropertyDaoImpl extends BaseDaoMyBatisImpl<Property> implements PropertyDao {

    @Override
    public boolean insert(Property bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(Property bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(Property bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(Property bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(Property bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public Property select(Property bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<Property> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<Property> listByDel(int page, int count, int tableIndex) throws Exception {
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
    public List<Property> listByProductCategoryId(long productCategoryId, int page, int count, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("productCategory_id", productCategoryId);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_PRODUCT_CATEGORY_ID, page, count, map);
    }

    @Override
    public int countByProductCategoryId(long productCategoryId, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("productCategory_id", productCategoryId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT__BY_PRODUCT_CATEGORY_ID, map);
    }

    @Override
    public Property selectByNameAndProductCategory(String name, long productCategoryId, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(3);
        map.put("name", name);
        map.put("productCategory_id", productCategoryId);
        map.put("tableIndex", tableIndex);

        return searchOne(NAME_SPACE + SELECT_BY_NAME_AND_PRODUCT_CATEGORY, map);
    }

    @Override
    public Property selectByName(String name, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("name", name);
        map.put("tableIndex", tableIndex);

        return searchOne(NAME_SPACE + SELECT_BY_NAME, map);
    }
}
