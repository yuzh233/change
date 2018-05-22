package me.cathub.change.storehouse.dao;

import me.cathub.change.api.dao.storehouse.StorehouseProductStockDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.storehouse.bean.StorehouseProductStock;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 仓库产品库存Dao实现
 *
 * @author cheng
 */
@Repository
public class StorehouseProductStockDaoImpl extends BaseDaoMyBatisImpl<StorehouseProductStock> implements StorehouseProductStockDao {

    @Override
    public boolean insert(StorehouseProductStock bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(StorehouseProductStock bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(StorehouseProductStock bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(StorehouseProductStock bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(StorehouseProductStock bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public StorehouseProductStock select(StorehouseProductStock bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<StorehouseProductStock> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<StorehouseProductStock> listByDel(int page, int count, int tableIndex) throws Exception {
        return listByDel(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int countByDel(int tableIndex) throws Exception {
        return countByDel(NAME_SPACE, tableIndex);
    }

    @Override
    public int clear(int tableIndex) throws Exception {
        return clear(NAME_SPACE, tableIndex);
    }

    @Override
    public StorehouseProductStock selectByStorehouseIdAndProductId(long storehouseId, long productId, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(3);
        map.put("storehouse_id", storehouseId);
        map.put("product_id", productId);
        map.put("tableIndex", tableIndex);

        return searchOne(NAME_SPACE + SELECT_BY_STOREHOUSE_ID_AND_PRODUCT_ID, map);
    }

    @Override
    public List<StorehouseProductStock> listByStorehouseId(long storehouseId, int page, int count, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("storehouse_id", storehouseId);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_STOREHOUSE_ID, page, count, map);
    }

    @Override
    public int countByStorehouseId(long storehouseId, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("storehouse_id", storehouseId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_STOREHOUSE_ID, map);
    }

    @Override
    public List<StorehouseProductStock> listByProductId(long productId, int page, int count, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("product_id", productId);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_PRODUCT_ID, page, count, map);
    }

    @Override
    public int countByProductId(long productId, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("product_id", productId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_PRODUCT_ID, map);
    }

    @Override
    public List<StorehouseProductStock> listByStorehouseIdAndProductCategoryId(long storehouseId, long productCategoryId, int page, int count, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("storehouse_id", storehouseId);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_STOREHOUSE_ID_AND_PRODUCT_CATEGORY_ID, page, count, map);
    }

    @Override
    public int countByStorehouseIdAndProductCategoryId(long storehouseId, long productCategoryId, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(3);
        map.put("storehouse_id", storehouseId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_STOREHOUSE_ID_AND_PRODUCT_CATEGORY_ID, map);
    }

    @Override
    public List<StorehouseProductStock> listByStorehouseIdAndCompanyId(long storehouseId, long companyId, int page, int count, int tableIndex) throws Exception {
        HashMap<String, Object> map = new HashMap<>(3);
        map.put("storehouse_id", storehouseId);
        map.put("company_id", companyId);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_STOREHOUSE_ID_AND_COMPANY_ID, page, count, map);
    }

    @Override
    public int countByStorehouseIdAndCompanyId(long storehouseId, long companyId, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(3);
        map.put("storehouse_id", storehouseId);
        map.put("company_id", companyId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_STOREHOUSE_ID_AND_COMPANY_ID, map);
    }
}
