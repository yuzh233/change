package me.cathub.change.product.dao;

import com.github.pagehelper.PageHelper;
import me.cathub.change.api.dao.product.ProductDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.product.bean.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品Dao实现类
 *
 * @author cheng
 */
@Repository
public class ProductDaoImpl extends BaseDaoMyBatisImpl<Product> implements ProductDao {

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
    public List<Product> listByBrandQuotientId(long brandQuotientId, int page, int count, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("brandQuotient_id", brandQuotientId);
        map.put("tableIndex", tableIndex);

        PageHelper.startPage(page, count);

        return baseList(NAME_SPACE + LIST_BY_BRAND_QUOTIENT_ID, page, count, map);
    }

    @Override
    public int countByBrandQuotientId(long brandQuotientId, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("brandQuotient_id", brandQuotientId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_BRAND_QUOTIENT_ID, map);
    }

    @Override
    public List<Product> listByCompanyId(long companyId, int page, int count, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("company_id", companyId);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_COMPANY_ID, page, count, map);
    }

    @Override
    public int countByCompanyId(long companyId, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("company_id", companyId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_COMPANY_ID, map);
    }

    @Override
    public List<Product> listByProductCategoryIdAndCompanyId(long productCategoryId, long companyId, int page, int count, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(3);
        map.put("productCategory_id", productCategoryId);
        map.put("company_id", companyId);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_PRODUCT_CATEGORY_ID_AND_COMPANY_ID, page, count, map);
    }

    @Override
    public int countByProductCategoryIdAndCompanyId(long productCategoryId, long companyId, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(3);
        map.put("productCategory_id", productCategoryId);
        map.put("company_id", companyId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_PRODUCT_CATEGORY_ID_AND_COMPANY_ID, map);
    }

    @Override
    public List<Product> listByProductCategoryId(long productCategoryId, int page, int count, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("productCategory_id", productCategoryId);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_PRODUCT_CATEGORY_ID, page, count, map);
    }

    @Override
    public int countByProductCategoryId(long productCategoryId, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("productCategory_id", productCategoryId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_PRODUCT_CATEGORY_ID, map);
    }

    @Override
    public Product selectByName(String name, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("name", name);
        map.put("tableIndex", tableIndex);

        return searchOne(NAME_SPACE + SELECT_BY_NAME, map);
    }

    @Override
    public List<Product> listByName(String name, int page, int count, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("name", name);
        map.put("tableIndex", tableIndex);

        return searchList(NAME_SPACE + LIST_BY_NAME, page, count, map);
    }

    @Override
    public int countByName(String name, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("name", name);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_NAME, map);
    }
}
