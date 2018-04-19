package me.cathub.change.product.dao;

import com.github.pagehelper.PageHelper;
import me.cathub.change.api.dao.product.PropertyValueDao;
import me.cathub.change.common.base.BaseIbatis;
import me.cathub.change.common.base.PropertyAndValue;
import me.cathub.change.product.bean.PropertyValue;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PropertyValueDaoImpl extends BaseIbatis<PropertyValue> implements PropertyValueDao {

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
    public long count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return clear(NAME_SPACE, tableIndex);
    }

    @Override
    public List<PropertyAndValue> listByProductId(long product_id, int page, int count, int tableIndex) throws Exception {
        List<PropertyAndValue> results = null;
        try {
            Map<String,? super Number> map = new HashMap<>();
            map.put("product_id", product_id);
            map.put("tableIndex", tableIndex);

            PageHelper.startPage(page, count);
            results =sqlSessionTemplate.selectList(NAME_SPACE + LIST_BY_PRODUCT_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
}
