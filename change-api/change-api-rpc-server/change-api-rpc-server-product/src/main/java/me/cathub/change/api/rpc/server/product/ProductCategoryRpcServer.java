package me.cathub.change.api.rpc.server.product;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.ServerSelectByName;
import me.cathub.change.product.bean.ProductCategory;

import java.util.List;

/**
 * 产品分类Rpc服务接口
 *
 * @author cheng
 */
public interface ProductCategoryRpcServer extends BaseRpcServer<ProductCategory>, ServerSelectByName<ProductCategory> {

    /**
     * 根据id获取子分类列表
     * @param id
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<ProductCategory> childListById(long id, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据id获取子分类数量
     * @param id
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int childCountById(long id, int tableIndex) throws Exception;
}