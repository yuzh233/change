package me.cathub.change.api.dao.product;

import me.cathub.change.common.base.BaseCrud;
import me.cathub.change.common.base.SelectByName;
import me.cathub.change.product.bean.ProductCategory;

public interface ProductCategoryDao extends BaseCrud<ProductCategory>, SelectByName<ProductCategory> {
    String NAME_SPACE = "me.cathub.change.product.bean.ProductCategory";
}
