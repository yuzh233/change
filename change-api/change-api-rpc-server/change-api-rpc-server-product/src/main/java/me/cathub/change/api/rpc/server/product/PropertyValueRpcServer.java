package me.cathub.change.api.rpc.server.product;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.product.bean.PropertyValue;

import java.util.List;

public interface PropertyValueRpcServer extends BaseRpcServer<PropertyValue>, FillAssociationDate<PropertyValue> {

    /**
     * 根据产品获取属性和属性值
     * @param product_id
     * @return
     * @throws Exception
     */
    List<PropertyValue> listByProductId(long product_id, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据产品获取属性值数量
     * @param product_id
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByProductId(long product_id, int tableIndex) throws Exception;
}
