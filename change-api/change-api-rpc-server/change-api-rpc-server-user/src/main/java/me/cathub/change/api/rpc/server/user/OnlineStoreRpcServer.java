package me.cathub.change.api.rpc.server.user;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.common.bean.user.OnlineStore;

import java.util.List;

public interface OnlineStoreRpcServer extends BaseRpcServer<OnlineStore>, FillAssociationDate<OnlineStore> {

    /**
     * 根据店主获取网店列表
     * @param shopkeeper_id
     * @param page
     * @param count
     * @return
     * @throws Exception
     */
    List<OnlineStore> listByShopkeeperId(long shopkeeper_id, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据店主获取网店数量
     * @param shopkeeper_id
     * @return
     * @throws Exception
     */
    int countByShopkeeperId(long shopkeeper_id, int tableIndex) throws Exception;
}
