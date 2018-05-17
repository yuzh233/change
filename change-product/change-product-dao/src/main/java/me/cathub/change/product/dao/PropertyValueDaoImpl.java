package me.cathub.change.product.dao;

import me.cathub.change.api.dao.product.PropertyValueDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.product.bean.PropertyValue;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 属性值Dao实现类
 *
 * @author cheng
 */
@Repository
public class PropertyValueDaoImpl extends BaseDaoMyBatisImpl<PropertyValue> implements PropertyValueDao {

    @Override
    public boolean insert(PropertyValue bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(PropertyValue bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(PropertyValue bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(PropertyValue bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(PropertyValue bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public PropertyValue select(PropertyValue bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<PropertyValue> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<PropertyValue> listByDel(int page, int count, int tableIndex) throws Exception {
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
    public List<PropertyValue> listByProductId(long productId, int page, int count, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("product_id", productId);
        map.put("tableIndex", tableIndex);


        return baseList(NAME_SPACE + LIST_BY_PRODUCT_ID, page, count, map);
    }

    @Override
    public int countByProductId(long productId, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("product_id", productId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_PRODUCT_ID, map);
    }
}
