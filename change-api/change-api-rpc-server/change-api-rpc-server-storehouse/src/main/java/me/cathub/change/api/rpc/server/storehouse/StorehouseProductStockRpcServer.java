package me.cathub.change.api.rpc.server.storehouse;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.storehouse.bean.StorehouseProductStock;

import java.util.List;

/**
 * 仓库产品库存Rpc服务接口
 *
 * @author cheng
 */
public interface StorehouseProductStockRpcServer extends BaseRpcServer<StorehouseProductStock> {

    /**
     * 根据仓库和产品查找库存
     * @param storehouseId
     * @param productId
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    StorehouseProductStock selectByStorehouseIdAndProductId(long storehouseId, long productId, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据仓库得到产品库存列表
     * @param storehouseId
     * @param page
     * @param count
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    List<StorehouseProductStock> listByStorehouseId(long storehouseId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据仓库得到产品库存数量
     * @param storehouseId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByStorehouseId(long storehouseId, int tableIndex) throws Exception;

    /**
     * 根据产品得到库存列表(一个产品,多个仓库)
     * @param productId
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<StorehouseProductStock> listByProductId(long productId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据产品得到库存数量(一个产品,多个仓库)
     * @param productId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByProductId(long productId, int tableIndex) throws Exception;

    /**
     * 根据仓库和产品分类得到产品库存列表(某个仓库,某个分类)
     * @param storehouseId
     * @param productCategoryId
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<StorehouseProductStock> listByStorehouseIdAndProductCategoryId(long storehouseId, long productCategoryId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据仓库和产品分类得到产品库存数量(某个仓库,某个分类)
     * @param storehouseId
     * @param productCategoryId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByStorehouseIdAndProductCategoryId(long storehouseId, long productCategoryId, int tableIndex) throws Exception;

    /**
     * 根据仓库和企业得到产品库存列表(某个仓库,某个企业)
     * @param storehouseId
     * @param companyId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<StorehouseProductStock> listByStorehouseIdAndCompanyId(long storehouseId, long companyId, int page, int count, int tableIndex, boolean flag) throws Exception;

    /**
     * 根据仓库和企业得到产品库存数量(某个仓库,某个企业)
     * @param storehouseId
     * @param companyId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByStorehouseIdAndCompanyId(long storehouseId, long companyId, int tableIndex) throws Exception;
}
