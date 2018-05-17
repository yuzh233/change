package me.cathub.change.api.rpc.server.product;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.product.bean.ProductReview;

import java.util.List;

/**
 * 产品评论Rpc服务接口
 *
 * @author cheng
 */
public interface ProductReviewRpcServer extends BaseRpcServer<ProductReview> {

    /**
     * 根据产品获取产品评论列表
     * @param productId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<ProductReview> listByProductId(long productId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据产品获取产品评论数量
     * @param productId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByProductId(long productId, int tableIndex) throws Exception;
}
