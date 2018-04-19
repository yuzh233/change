package me.cathub.change.api.rpc.server.product;

import me.cathub.change.common.base.BaseService;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.product.bean.Property;

public interface PropertyRpcServer extends BaseService<Property>, FillAssociationDate<Property> {
}
