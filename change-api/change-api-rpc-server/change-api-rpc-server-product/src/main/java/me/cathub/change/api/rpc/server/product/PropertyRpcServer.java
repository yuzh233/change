package me.cathub.change.api.rpc.server.product;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.common.base.SelectByName;
import me.cathub.change.product.bean.Property;

import java.util.List;

public interface PropertyRpcServer extends BaseRpcServer<Property>, FillAssociationDate<Property>, SelectByName<Property> {

    /**
     * 根据产品分类获取属性列表
     * @param productCategory_id
     * @param page
     * @param count
     * @return
     * @throws Exception
     */
    List<Property> listByProductCategoryId(long productCategory_id, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据产品分类获取属性数量
     * @param productCategory_id
     * @return
     * @throws Exception
     */
    int countByProductCategoryId(long productCategory_id, int tableIndex) throws Exception;
}
