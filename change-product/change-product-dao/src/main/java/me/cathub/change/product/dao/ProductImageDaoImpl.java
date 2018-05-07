package me.cathub.change.product.dao;


import com.github.pagehelper.PageHelper;
import me.cathub.change.api.dao.product.ProductImageDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.common.bean.product.ProductImage;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ProductImageDaoImpl extends BaseDaoMyBatisImpl<ProductImage> implements ProductImageDao {

    @Override
    public boolean insert(ProductImage bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(ProductImage bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(ProductImage bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(ProductImage bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(ProductImage bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public ProductImage select(ProductImage bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<ProductImage> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<ProductImage> listByDel(int page, int count, int tableIndex) throws Exception {
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
    public List<ProductImage> listByProductIdAndImageType(long product_id, int type, int page, int count, int tableIndex) throws Exception {
        List<ProductImage> results = null;
        try {
            HashMap<String, ? super Number> map = new HashMap<>();
            map.put("product_id", product_id);
            map.put("type", type);
            map.put("tableIndex", tableIndex);

            PageHelper.startPage(page, count);
            results = sqlSessionTemplate.selectList(NAME_SPACE + LIST_BY_PRODUCT_IMAGE_ID_AND_IMAGE_TYPE, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public int countByProductIdAndImageType(long product_id, int type, int tableIndex) throws Exception {
        int count = 0;
        try {
            HashMap<String, ? super Number> map = new HashMap<>();
            map.put("product_id", product_id);
            map.put("type", type);
            map.put("tableIndex", tableIndex);
            count = sqlSessionTemplate.selectOne(NAME_SPACE + COUNT_BY_PRODUCT_IMAGE_ID_AND_IMAGE_TYPE, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public ProductImage selectByProductIdCover(long product_id, int tableIndex) throws Exception {
        ProductImage result = null;
        try {
            HashMap<String, ? super Number> map = new HashMap<>();
            map.put("product_id", product_id);
            map.put("tableIndex", tableIndex);
            result = sqlSessionTemplate.selectOne(NAME_SPACE + SELECT_BY_PRODUCT_IMAGE_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
