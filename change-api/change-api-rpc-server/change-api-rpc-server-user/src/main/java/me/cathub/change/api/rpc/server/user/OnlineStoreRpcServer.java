package me.cathub.change.api.rpc.server.user;

import me.cathub.change.common.base.BaseService;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.user.bean.OnlineStore;

public interface OnlineStoreRpcServer extends BaseService<OnlineStore>, FillAssociationDate<OnlineStore> {
}
