package me.cathub.change.api.dao.user;

import me.cathub.change.common.base.BaseCrud;
import me.cathub.change.common.base.LoginInterface;
import me.cathub.change.user.bean.Shopkeeper;

public interface ShopkeeperCrud extends BaseCrud<Shopkeeper>, LoginInterface<Shopkeeper> {
    String NAME_SPACE = "me.cathub.change.user.bean.Shopkeeper";
}
