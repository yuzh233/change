package me.cathub.change.api.rpc.server.product;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.product.bean.ProductImage;

import java.util.List;

/**
 * 产品图片Dao接口
 *
 * @author cheng
 */
public interface ProductImageRpcServer extends BaseRpcServer<ProductImage> {

    /**
     * 根据产品和图片类型获取产品图片列表
     * @param productId
     * @param type
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<ProductImage> listByProductIdAndImageType(long productId, int type, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据产品和图片类型获取图片数量
     * @param productId
     * @param type
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByProductIdAndImageType(long productId, int type, int tableIndex) throws Exception;

    /**
     * 根据产品获取封面图片
     * @param productId
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    ProductImage selectByProductIdCover(long productId, int tableIndex, boolean flag) throws Exception;
}
