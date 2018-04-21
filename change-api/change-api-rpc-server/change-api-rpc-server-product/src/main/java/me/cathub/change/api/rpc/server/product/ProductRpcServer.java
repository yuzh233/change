package me.cathub.change.api.rpc.server.product;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.product.bean.Product;

public interface ProductRpcServer extends BaseRpcServer<Product>, FillAssociationDate<Product> {
}
