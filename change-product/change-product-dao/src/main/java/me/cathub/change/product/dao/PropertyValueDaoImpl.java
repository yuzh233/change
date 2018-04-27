package me.cathub.change.product.dao;

import com.github.pagehelper.PageHelper;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NamedMethodGenerator;
import me.cathub.change.api.dao.product.PropertyValueDao;
import me.cathub.change.common.base.BaseCrudMyBatisImpl;
import me.cathub.change.product.bean.PropertyValue;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PropertyValueDaoImpl extends BaseCrudMyBatisImpl<PropertyValue> implements PropertyValueDao {

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
    public List<PropertyValue> listByProductId(long product_id, int page, int count, int tableIndex) throws Exception {
        List<PropertyValue> results = null;

        try {
            Map<String, ? super Number> map = new HashMap<>();
            map.put("product_id", product_id);
            map.put("tableIndex", tableIndex);

            PageHelper.startPage(page, count);
            results = sqlSessionTemplate.selectList(NAME_SPACE + LIST_BY_PRODUCT_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

    @Override
    public int countByProductId(long product_id, int tableIndex) throws Exception {
        int count = 0;

        try {
            HashMap<String, ? super Number> map = new HashMap<>();
            map.put("product_id", product_id);
            map.put("tableIndex", tableIndex);

            count = sqlSessionTemplate.selectOne(NAME_SPACE + COUNT_BY_PRODUCT_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
}
