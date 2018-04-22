package me.cathub.change.api.dao.user;

import me.cathub.change.common.base.BaseCrud;
import me.cathub.change.common.base.LoginInterface;
import me.cathub.change.common.base.SelectByName;
import me.cathub.change.user.bean.Shopkeeper;

public interface ShopkeeperDao extends BaseCrud<Shopkeeper>, LoginInterface<Shopkeeper>, SelectByName<Shopkeeper> {
    String NAME_SPACE = "me.cathub.change.user.bean.Shopkeeper";
}
