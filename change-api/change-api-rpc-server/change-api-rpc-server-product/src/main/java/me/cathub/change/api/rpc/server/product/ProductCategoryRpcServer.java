package me.cathub.change.api.rpc.server.product;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.SelectByName;
import me.cathub.change.product.bean.ProductCategory;

import java.util.List;

public interface ProductCategoryRpcServer extends BaseRpcServer<ProductCategory>, SelectByName<ProductCategory> {

    /**
     * 根据id获取子分类列表
     * @param id
     * @return
     * @throws Exception
     */
    List<ProductCategory> childListById(long id, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据id获取子分类数量
     * @param id
     * @return
     * @throws Exception
     */
    int childCountById(long id, int tableIndex) throws Exception;
}