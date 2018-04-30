package me.cathub.change.api.dao.product;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.product.bean.ProductImage;

import java.util.List;

public interface ProductImageDao extends BaseDao<ProductImage> {
    String NAME_SPACE = "me.cathub.change.product.bean.ProductImage";

    String LIST_BY_PRODUCT_IMAGE_ID_AND_IMAGE_TYPE = ".listByProductIdAndImageType";
    String COUNT_BY_PRODUCT_IMAGE_ID_AND_IMAGE_TYPE = ".countByProductIdAndImageType";
    String SELECT_BY_PRODUCT_IMAGE_ID = ".selectByProductIdCover";

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
    ProductImage selectByProductIdCover(long product_id, int tableIndex) throws Exception;
}