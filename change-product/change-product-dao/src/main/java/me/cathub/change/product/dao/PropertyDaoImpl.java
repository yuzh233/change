package me.cathub.change.product.dao;

import com.github.pagehelper.PageHelper;
import me.cathub.change.api.dao.product.PropertyDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.common.bean.product.Property;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Property> listByProductCategoryId(long productCategory_id, int page, int count, int tableIndex) throws Exception {
        List<Property> results = null;
        try {
            Map<String, ? super Number> map = new HashMap<>();
            map.put("productCategory_id", productCategory_id);
            map.put("tableIndex", tableIndex);

            PageHelper.startPage(page, count);
            results = sqlSessionTemplate.selectList(NAME_SPACE + LIST_BY_PRODUCT_CATEGORY_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public int countByProductCategoryId(long productCategory_id, int tableIndex) throws Exception {
        int count = 0;
        try {
            Map<String, ? super Number> map = new HashMap<>();
            map.put("productCategory_id", productCategory_id);
            map.put("tableIndex", tableIndex);
            count = sqlSessionTemplate.selectOne(NAME_SPACE + COUNT__BY_PRODUCT_CATEGORY_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public Property selectByName(String name, int tableIndex) throws Exception {
        Property result = null;
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("name", name);
            map.put("tableIndex", tableIndex);
            result = sqlSessionTemplate.selectOne(NAME_SPACE + SELECT_BY_NAME, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
