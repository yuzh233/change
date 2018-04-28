package me.cathub.change.api.rpc.server.product;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.product.bean.ProductReview;

import java.util.List;

public interface ProductReviewRpcServer extends BaseRpcServer<ProductReview>, FillAssociationDate<ProductReview> {

    /**
     * 根据产品获取产品评论列表
     * @param product_id
     * @param page
     * @param count
     * @return
     * @throws Exception
     */
    List<ProductReview> listByProductId(long product_id, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据产品获取产品评论数量
     * @param product_id
     * @return
     * @throws Exception
     */
    int countByProductId(long product_id, int tableIndex) throws Exception;
}
