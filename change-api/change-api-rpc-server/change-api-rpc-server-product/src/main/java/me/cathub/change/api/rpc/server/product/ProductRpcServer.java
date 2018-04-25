package me.cathub.change.api.rpc.server.product;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.common.base.SelectByName;
import me.cathub.change.product.bean.Product;

import java.util.List;

public interface ProductRpcServer extends BaseRpcServer<Product>, FillAssociationDate<Product>, SelectByName<Product> {

    /**
     * 根据品牌商获取产品列表
     * @param brandQuotient_id
     * @param page
     * @param count
     * @return
     * @throws Exception
     */
    List<Product> listByBrandQuotientId(long brandQuotient_id, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据品牌商获取产品数量
     * @param brandQuotient_id
     * @return
     * @throws Exception
     */
    int countByBrandQuotientId(long brandQuotient_id, int tableIndex) throws Exception;

    /**
     * 根据产品分类和品牌商获取产品列表
     * @param productCategory_id
     * @param brandQuotient_id
     * @param page
     * @param count
     * @return
     * @throws Exception
     */
    List<Product> listByProductCategoryIdAndBrandQuotientId(long productCategory_id, long brandQuotient_id, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据产品分类和品牌商获取产品数量
     * @param productCategory_id
     * @param brandQuotient_id
     * @return
     * @throws Exception
     */
    int countByProductCategoryIdAndBrandQuotientId(long productCategory_id, long brandQuotient_id, int tableIndex) throws Exception;

    /**
     * 根据产品分类获取产品列表
     * @param productCategory_id
     * @return
     * @throws Exception
     */
    List<Product> listByProductCategoryId(long productCategory_id, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据产品分类获取产品数量
     * @param productCategory_id
     * @return
     * @throws Exception
     */
    int countByProductCategoryId(long productCategory_id, int tableIndex) throws Exception;
}
