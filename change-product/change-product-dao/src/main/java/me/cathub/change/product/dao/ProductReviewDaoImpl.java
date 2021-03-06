package me.cathub.change.product.dao;

import me.cathub.change.api.dao.product.ProductReviewDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.product.bean.ProductReview;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品评论Dao实现类
 *
 * @author cheng
 */
@Repository
public class ProductReviewDaoImpl extends BaseDaoMyBatisImpl<ProductReview> implements ProductReviewDao {

    @Override
    public boolean insert(ProductReview bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(ProductReview bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(ProductReview bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(ProductReview bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(ProductReview bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public ProductReview select(ProductReview bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<ProductReview> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<ProductReview> listByDel(int page, int count, int tableIndex) throws Exception {
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
    public List<ProductReview> listByProductId(long productId, int page, int count, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("product_id", productId);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_PRODUCT_ID, page, count, map);
    }

    @Override
    public int countByProductId(long productId, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("product_id", productId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_PRODUCT_ID, map);
    }
}
