package me.cathub.change.api.rpc.server.product;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.product.bean.PropertyKeyValue;
import me.cathub.change.product.bean.PropertyValue;

import java.util.List;

/**
 * 属性值Rpc服务接口
 *
 * @author cheng
 */
public interface PropertyValueRpcServer extends BaseRpcServer<PropertyValue> {

    /**
     * 根据产品获取属性和属性值
     * @param productId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<PropertyValue> listByProductId(long productId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据产品获取属性值数量
     * @param productId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByProductId(long productId, int tableIndex) throws Exception;

    /**
     * 根据产品获取属性键值对列表
     * @param productId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<PropertyKeyValue> keyValueList(long productId, int tableIndex) throws Exception;
}
