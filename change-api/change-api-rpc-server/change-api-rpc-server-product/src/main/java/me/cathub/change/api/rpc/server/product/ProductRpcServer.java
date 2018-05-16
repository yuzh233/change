package me.cathub.change.api.rpc.server.product;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.common.base.ServerSelectByName;
import me.cathub.change.product.bean.Product;

import java.util.List;

/**
 * 产品Rpc服务接口
 *
 * @author cheng
 */
public interface ProductRpcServer extends BaseRpcServer<Product>, FillAssociationDate<Product>, ServerSelectByName<Product> {

    /**
     * 根据品牌商获取产品列表
     * @param brandQuotientId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<Product> listByBrandQuotientId(long brandQuotientId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据品牌商获取产品数量
     * @param brandQuotientId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByBrandQuotientId(long brandQuotientId, int tableIndex) throws Exception;

    /**
     * 根据产品分类获取产品列表
     * @param productCategoryId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<Product> listByProductCategoryId(long productCategoryId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据产品分类获取产品数量
     * @param productCategoryId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByProductCategoryId(long productCategoryId, int tableIndex) throws Exception;

    /**
     * 根据企业获取产品列表
     * @param companyId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<Product> listByCompanyId(long companyId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据企业获取产品数量
     * @param companyId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByCompanyId(long companyId, int tableIndex) throws Exception;

    /**
     * 根据产品分类和企业获取产品列表
     * @param productCategoryId
     * @param companyId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<Product> listByProductCategoryIdAndCompanyId(long productCategoryId, long companyId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据产品分类和企业获取产品数量
     * @param productCategoryId
     * @param companyId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByProductCategoryIdAndCompanyId(long productCategoryId, long companyId, int tableIndex) throws Exception;
}
