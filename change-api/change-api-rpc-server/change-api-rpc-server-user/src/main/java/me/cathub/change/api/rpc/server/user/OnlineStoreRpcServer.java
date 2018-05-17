package me.cathub.change.api.rpc.server.user;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.user.bean.OnlineStore;

import java.util.List;

/**
 * 网店Rpc服务接口
 *
 * @author cheng
 */
public interface OnlineStoreRpcServer extends BaseRpcServer<OnlineStore> {

    /**
     * 根据店主获取网店列表
     * @param shopkeeperId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<OnlineStore> listByShopkeeperId(long shopkeeperId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据店主获取网店数量
     * @param shopkeeperId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByShopkeeperId(long shopkeeperId, int tableIndex) throws Exception;
}
