package me.cathub.change.api.dao.user;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.common.base.LoginInterface;
import me.cathub.change.common.base.DaoSelectByName;
import me.cathub.change.common.bean.user.Shopkeeper;

public interface ShopkeeperDao extends BaseDao<Shopkeeper>, LoginInterface<Shopkeeper>, DaoSelectByName<Shopkeeper> {
    String NAME_SPACE = "Shopkeeper";
}
