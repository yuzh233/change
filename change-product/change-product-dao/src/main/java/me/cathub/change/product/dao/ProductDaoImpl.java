package me.cathub.change.product.dao;

import com.github.pagehelper.PageHelper;
import me.cathub.change.api.dao.product.ProductDao;
import me.cathub.change.common.base.BaseCrudMyBatisImpl;
import me.cathub.change.product.bean.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImpl extends BaseCrudMyBatisImpl<Product> implements ProductDao {

    @Override
    public boolean insert(Product bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(Product bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(Product bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(Product bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(Product bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public Product select(Product bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<Product> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<Product> listByDel(int page, int count, int tableIndex) throws Exception {
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
    public List<Product> listByBrandQuotientId(long brandQuotient_id, int page, int count, int tableIndex) throws Exception {
        List<Product> results = null;
        try {
            Map<String, ? super Number> map = new HashMap<>();
            map.put("brandQuotient_id", brandQuotient_id);
            map.put("tableIndex", tableIndex);

            PageHelper.startPage(page, count);
            results = sqlSessionTemplate.selectList(NAME_SPACE + LIST_BY_BRAND_QUOTIENT_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public int countByBrandQuotientId(long brandQuotient_id, int tableIndex) throws Exception {
        int count = 0;
        try {
            Map<String, ? super Number> map = new HashMap<>();
            map.put("brandQuotient_id", brandQuotient_id);
            map.put("tableIndex", tableIndex);
            count = sqlSessionTemplate.selectOne(NAME_SPACE + COUNT_BY_BRAND_QUOTIENT_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Product> listByProductCategoryIdAndBrandQuotientId(long productCategory_id, long brandQuotient_id, int page, int count, int tableIndex) throws Exception {
        List<Product> results = null;
        try {
            HashMap<String, ? super Number> map = new HashMap<>();
            map.put("productCategory_id", productCategory_id);
            map.put("brandQuotient_id", brandQuotient_id);
            map.put("tableIndex", tableIndex);

            PageHelper.startPage(page, count);
            results = sqlSessionTemplate.selectList(NAME_SPACE + LIST_BY_PRODUCT_CATEGORY_ID_AND_BRAND_QUOTIENT_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public int countByProductCategoryIdAndBrandQuotientId(long productCategory_id, long brandQuotient_id, int tableIndex) throws Exception {
        int count = 0;
        try {
            HashMap<String, ? super Number> map = new HashMap<>();
            map.put("productCategory_id", productCategory_id);
            map.put("brandQuotient_id", brandQuotient_id);
            map.put("tableIndex", tableIndex);
            count = sqlSessionTemplate.selectOne(NAME_SPACE + COUNT_BY_PRODUCT_CATEGORY_ID_AND_BRAND_QUOTIENT_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Product> listByProductCategoryId(long productCategory_id, int page, int count, int tableIndex) throws Exception {
        List<Product> results = null;
        try {
            HashMap<String, ? super Number> map = new HashMap<>();
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
            HashMap<String, ? super Number> map = new HashMap<>();
            map.put("productCategory_id", productCategory_id);
            map.put("tableIndex", tableIndex);
            count = sqlSessionTemplate.selectOne(NAME_SPACE + COUNT_BY_PRODUCT_CATEGORY_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public Product selectByName(String name, int tableIndex) throws Exception {
        Product result = null;
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
