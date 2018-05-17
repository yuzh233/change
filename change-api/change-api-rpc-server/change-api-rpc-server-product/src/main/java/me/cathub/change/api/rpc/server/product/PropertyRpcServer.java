package me.cathub.change.api.rpc.server.product;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.common.base.ServerSelectByName;
import me.cathub.change.product.bean.Property;

import java.util.List;

/**
 * 属性Rpc服务接口
 *
 * @author cheng
 */
public interface PropertyRpcServer extends BaseRpcServer<Property>, ServerSelectByName<Property> {

    /**
     * 根据产品分类获取属性列表
     * @param productCategoryId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<Property> listByProductCategoryId(long productCategoryId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据产品分类获取属性数量
     * @param productCategoryId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByProductCategoryId(long productCategoryId, int tableIndex) throws Exception;

    /**
     * 根据属性名和产品分类获取属性
     * @param name
     * @param productCategoryId
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    Property selectByNameAndProductCategory(String name, long productCategoryId, int tableIndex, boolean flag) throws Exception;
}
