package me.cathub.change.api.dao.user;

import me.cathub.change.common.base.BaseCrud;
import me.cathub.change.common.base.LoginInterface;
import me.cathub.change.user.bean.BrandQuotient;

public interface BrandQuotientDao extends BaseCrud<BrandQuotient>, LoginInterface<BrandQuotient> {
    String NAME_SPACE = "me.cathub.change.user.bean.BrandQuotient";
}