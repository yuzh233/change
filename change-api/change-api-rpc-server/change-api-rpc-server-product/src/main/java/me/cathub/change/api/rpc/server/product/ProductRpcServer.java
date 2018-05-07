package me.cathub.change.api.rpc.server.product;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.common.base.ServerSelectByName;
import me.cathub.change.common.bean.product.Product;

import java.util.List;

public interface ProductRpcServer extends BaseRpcServer<Product>, FillAssociationDate<Product>, ServerSelectByName<Product> {

    /**
     * 根据品牌商获取产品列表
     * @param brandQuotient_id
     * @param page
     * @param count
     * @return
     * @throws Exception
     */
    List<Product> listByBrandQuotientId(long brandQuotient_id, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据品牌商获取产品数量
     * @param brandQuotient_id
     * @return
     * @throws Exception
     */
    int countByBrandQuotientId(long brandQuotient_id, int tableIndex) throws Exception;

    /**
     * 根据产品分类获取产品列表
     * @param productCategory_id
     * @return
     * @throws Exception
     */
    List<Product> listByProductCategoryId(long productCategory_id, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据产品分类获取产品数量
     * @param productCategory_id
     * @return
     * @throws Exception
     */
    int countByProductCategoryId(long productCategory_id, int tableIndex) throws Exception;

    /**
     * 根据企业获取产品列表
     * @param company_id
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<Product> listByCompanyId(long company_id, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据企业获取产品数量
     * @param company_id
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByCompanyId(long company_id, int tableIndex) throws Exception;

    /**
     * 根据产品分类和企业获取产品列表
     * @param productCategory_id
     * @param company_id
     * @param page
     * @param count
     * @return
     * @throws Exception
     */
    List<Product> listByProductCategoryIdAndCompanyId(long productCategory_id, long company_id, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据产品分类和企业获取产品数量
     * @param productCategory_id
     * @param company_id
     * @return
     * @throws Exception
     */
    int countByProductCategoryIdAndCompanyId(long productCategory_id, long company_id, int tableIndex) throws Exception;
}
