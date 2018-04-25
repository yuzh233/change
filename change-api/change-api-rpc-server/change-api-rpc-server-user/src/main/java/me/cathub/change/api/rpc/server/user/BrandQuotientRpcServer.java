package me.cathub.change.api.rpc.server.user;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.common.base.SelectByName;
import me.cathub.change.user.bean.BrandQuotient;

public interface BrandQuotientRpcServer extends BaseRpcServer<BrandQuotient>, FillAssociationDate<BrandQuotient>, SelectByName<BrandQuotient> {
}
