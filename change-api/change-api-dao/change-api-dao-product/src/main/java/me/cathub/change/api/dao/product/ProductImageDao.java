package me.cathub.change.api.dao.product;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.product.bean.ProductImage;

import java.util.List;

/**
 * 产品图片Dao接口
 *
 * @author cheng
 */
public interface ProductImageDao extends BaseDao<ProductImage> {
    String NAME_SPACE = "ProductImage";

    String LIST_BY_PRODUCT_IMAGE_ID_AND_IMAGE_TYPE = ".listByProductIdAndImageType";
    String COUNT_BY_PRODUCT_IMAGE_ID_AND_IMAGE_TYPE = ".countByProductIdAndImageType";
    String SELECT_BY_PRODUCT_IMAGE_ID = ".selectByProductIdCover";

    /**
     * 根据产品和图片类型获取产品图片列表
     * @param productId
     * @param type
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<ProductImage> listByProductIdAndImageType(long productId, int type, int page, int count, int tableIndex) throws Exception;

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
     * @return
     * @throws Exception
     */
    ProductImage selectByProductIdCover(long productId, int tableIndex) throws Exception;
}