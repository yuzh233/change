package me.cathub.change.product.dao;


import me.cathub.change.api.dao.product.ProductImageDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.product.bean.ProductImage;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * 产品图片Dao实现类
 *
 * @author cheng
 */
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
    public List<ProductImage> listByProductIdAndImageType(long productId, int type, int page, int count, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(3);
        map.put("product_id", productId);
        map.put("type", type);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_PRODUCT_IMAGE_ID_AND_IMAGE_TYPE, page, count, map);
    }

    @Override
    public int countByProductIdAndImageType(long productId, int type, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(3);
        map.put("product_id", productId);
        map.put("type", type);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_PRODUCT_IMAGE_ID_AND_IMAGE_TYPE, map);
    }

    @Override
    public ProductImage selectByProductIdCover(long productId, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("product_id", productId);
        map.put("tableIndex", tableIndex);

        return search(NAME_SPACE + SELECT_BY_PRODUCT_IMAGE_ID, map);
    }
}
