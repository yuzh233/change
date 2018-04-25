package me.cathub.change.api.rpc.server.product;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.product.bean.ProductImage;

import java.util.List;

public interface ProductImageRpcServer extends BaseRpcServer<ProductImage>, FillAssociationDate<ProductImage> {

    /**
     * 根据产品和图片类型获取产品图片列表
     * @param product_id
     * @return
     * @throws Exception
     */
    List<ProductImage> listByProductIdAndImageType(long product_id, int type, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据产品和图片类型获取图片数量
     * @param product_id
     * @param type
     * @return
     * @throws Exception
     */
    int countByProductIdAndImageType(long product_id, int type, int tableIndex) throws Exception;

    /**
     * 根据产品获取封面图片
     * @param product_id
     * @return
     * @throws Exception
     */
    ProductImage selectByProductIdHead(long product_id, int tableIndex) throws Exception;
}
