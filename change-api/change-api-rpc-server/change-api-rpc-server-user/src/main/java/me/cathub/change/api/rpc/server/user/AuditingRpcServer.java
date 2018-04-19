package me.cathub.change.api.rpc.server.user;

import me.cathub.change.common.base.BaseService;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.user.bean.Auditing;

public interface AuditingRpcServer extends BaseService<Auditing>, FillAssociationDate<Auditing> {
}
