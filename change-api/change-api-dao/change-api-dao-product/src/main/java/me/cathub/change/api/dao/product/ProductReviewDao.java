package me.cathub.change.api.dao.product;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.product.bean.ProductReview;

import java.util.List;

/**
 * 产品评论Dao接口
 *
 * @author cheng
 */
public interface ProductReviewDao extends BaseDao<ProductReview> {
    String NAME_SPACE = "ProductReview";

    String LIST_BY_PRODUCT_ID = ".listByProductId";
    String COUNT_BY_PRODUCT_ID = ".countByProductId";

    /**
     * 根据产品获取产品评论列表
     * @param productId
     * @param page
     * @param tableIndex
     * @param count
     * @return
     * @throws Exception
     */
    List<ProductReview> listByProductId(long productId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据产品获取产品评论数量
     * @param productId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByProductId(long productId, int tableIndex) throws Exception;
}
