package me.cathub.change.api.dao.user;


import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.bean.user.OnlineStore;

import java.util.List;

public interface OnlineStoreDao extends BaseDao<OnlineStore> {
    String NAME_SPACE = "OnlineStore";

    String LIST_BY_SHOPKEEPER_ID = ".listByShopkeeperId";
    String COUNT_BY_SHOPKEEPER_ID = ".countByShopkeeperId";

    /**
     * 根据店主获取网店列表
     * @param shopkeeper_id
     * @param page
     * @param count
     * @return
     * @throws Exception
     */
    List<OnlineStore> listByShopkeeperId(long shopkeeper_id, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据店主获取网店数量
     * @param shopkeeper_id
     * @return
     * @throws Exception
     */
    int countByShopkeeperId(long shopkeeper_id, int tableIndex) throws Exception;
}
