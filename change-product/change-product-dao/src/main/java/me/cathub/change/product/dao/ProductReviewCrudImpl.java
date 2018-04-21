package me.cathub.change.product.dao;

import com.github.pagehelper.PageHelper;
import me.cathub.change.api.dao.product.ProductReviewCrud;
import me.cathub.change.common.base.BaseCrudMyBatisImpl;
import me.cathub.change.product.bean.ProductReview;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductReviewCrudImpl extends BaseCrudMyBatisImpl<ProductReview> implements ProductReviewCrud {

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
    public long count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return clear(NAME_SPACE, tableIndex);
    }

    @Override
    public List<ProductReview> listByProductId(long product_id, int page, int count, int tableIndex) throws Exception {
        List<ProductReview> results = null;
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
            Map<String, ? super Number> map = new HashMap<>();
            map.put("product_id", product_id);
            map.put("tableIndex", tableIndex);
            count = sqlSessionTemplate.selectOne(NAME_SPACE + COUNT_BY_PRODUCT_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
