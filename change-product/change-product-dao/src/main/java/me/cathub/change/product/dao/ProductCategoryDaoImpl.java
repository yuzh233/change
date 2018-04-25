package me.cathub.change.product.dao;

import com.github.pagehelper.PageHelper;
import me.cathub.change.api.dao.product.ProductCategoryDao;
import me.cathub.change.common.base.BaseCrudMyBatisImpl;
import me.cathub.change.product.bean.ProductCategory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductCategoryDaoImpl extends BaseCrudMyBatisImpl<ProductCategory> implements ProductCategoryDao {

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
    public long count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return clear(NAME_SPACE, tableIndex);
    }

    @Override
    public ProductCategory selectByName(String name, int tableIndex) throws Exception {
        ProductCategory result = null;
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

    @Override
    public List<ProductCategory> childListById(long id, int page, int count, int tableIndex) throws Exception {
        List<ProductCategory> results = null;

        try {
            Map<String, ? super Number> map = new HashMap<>();
            map.put("id", id);
            map.put("tableIndex", tableIndex);

            PageHelper.startPage(page, count);
            results = sqlSessionTemplate.selectList(NAME_SPACE + CHILD_LIST_BY_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

    @Override
    public int childCountById(long id, int tableIndex) throws Exception {
        int count = 0;

        try {
            Map<String, ? super Number> map = new HashMap<>();
            map.put("id", id);
            map.put("tableIndex", tableIndex);

            count = sqlSessionTemplate.selectOne(NAME_SPACE + CHILD_COUNT_BY_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
}