package me.cathub.change.api.rpc.server.product;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.product.bean.ProductImage;

public interface ProductImageRpcServer extends BaseRpcServer<ProductImage>, FillAssociationDate<ProductImage> {
}
