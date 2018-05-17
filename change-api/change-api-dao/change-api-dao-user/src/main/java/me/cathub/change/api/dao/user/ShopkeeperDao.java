package me.cathub.change.api.dao.user;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.user.bean.Shopkeeper;

/**
 * B2C店主Dao接口
 *
 * @author cheng
 */
public interface ShopkeeperDao extends BaseDao<Shopkeeper>, DaoSelectByName<Shopkeeper> {
    String NAME_SPACE = "Shopkeeper";
}
