package me.cathub.change.api.dao.user;


import me.cathub.change.common.base.BaseDao;
import me.cathub.change.user.bean.OnlineStore;

import java.util.List;

/**
 * 网店Dao接口
 *
 * @author cheng
 */
public interface OnlineStoreDao extends BaseDao<OnlineStore> {
    String NAME_SPACE = "OnlineStore";

    String LIST_BY_SHOPKEEPER_ID = ".listByShopkeeperId";
    String COUNT_BY_SHOPKEEPER_ID = ".countByShopkeeperId";

    /**
     * 根据店主获取网店列表
     * @param shopkeeperId
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<OnlineStore> listByShopkeeperId(long shopkeeperId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据店主获取网店数量
     * @param shopkeeperId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByShopkeeperId(long shopkeeperId, int tableIndex) throws Exception;
}
