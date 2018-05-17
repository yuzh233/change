package me.cathub.change.api.dao.storehouse;

import me.cathub.change.common.base.BaseDao;
import me.cathub.change.storehouse.bean.StorehouseProductStock;

import java.util.List;

/**
 * 仓库产品库存Dao接口
 *
 * @author cheng
 */
public interface StorehouseProductStockDao extends BaseDao<StorehouseProductStock> {
    String NAME_SPACE = "StorehouseProductStock";

    String SELECT_BY_STOREHOUSE_ID_AND_PRODUCT_ID = ".selectByStorehouseIdAndProductId";
    String LIST_BY_STOREHOUSE_ID = ".listByStorehouseId";
    String COUNT_BY_STOREHOUSE_ID = ".countByStorehouseId";
    String LIST_BY_PRODUCT_ID = ".listByProductId";
    String COUNT_BY_PRODUCT_ID = ".countByProductId";
    String LIST_BY_STOREHOUSE_ID_AND_PRODUCT_CATEGORY_ID = ".listByStorehouseIdAndProductCategoryId";
    String COUNT_BY_STOREHOUSE_ID_AND_PRODUCT_CATEGORY_ID = ".countByStorehouseIdAndProductCategoryId";
    String LIST_BY_STOREHOUSE_ID_AND_COMPANY_ID = ".listByStorehouseIdAndCompanyId";
    String COUNT_BY_STOREHOUSE_ID_AND_COMPANY_ID = ".countByStorehouseIdAndCompanyId";

    /**
     * 根据仓库和产品查找库存(精确查找)
     * @param storehouseId
     * @param productId
     * @param tableIndex
     * @return
     * @throws Exception
     */
    StorehouseProductStock selectByStorehouseIdAndProductId(long storehouseId, long productId, int tableIndex) throws Exception;

    /**
     * 根据仓库得到(全部)产品库存列表
     * @param storehouseId
     * @param page
     * @param count
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<StorehouseProductStock> listByStorehouseId(long storehouseId, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据仓库得到(全部)产品库存数量
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
    List<StorehouseProductStock> listByProductId(long productId, int page, int count, int tableIndex) throws Exception;

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
    List<StorehouseProductStock> listByStorehouseIdAndProductCategoryId(long storehouseId, long productCategoryId, int page, int count, int tableIndex) throws Exception;

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
    List<StorehouseProductStock> listByStorehouseIdAndCompanyId(long storehouseId, long companyId, int page, int count, int tableIndex) throws Exception;

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