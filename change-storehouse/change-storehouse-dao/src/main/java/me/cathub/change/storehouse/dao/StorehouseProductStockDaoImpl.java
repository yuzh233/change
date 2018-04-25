package me.cathub.change.storehouse.dao;

import com.github.pagehelper.PageHelper;
import me.cathub.change.api.dao.storehouse.StorehouseProductStockDao;
import me.cathub.change.common.base.BaseCrudMyBatisImpl;
import me.cathub.change.storehouse.bean.StorehouseProductStock;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StorehouseProductStockDaoImpl extends BaseCrudMyBatisImpl<StorehouseProductStock> implements StorehouseProductStockDao {

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
    public long count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return clear(NAME_SPACE, tableIndex);
    }

    @Override
    public StorehouseProductStock selectByStorehouseIdAndProductId(long storehouse_id, long product_id, int tableIndex) throws Exception {
        StorehouseProductStock result = null;
        try {
            HashMap<String, ? super Number> map = new HashMap<>();
            map.put("storehouse_id", storehouse_id);
            map.put("product_id", product_id);
            map.put("tableIndex", tableIndex);
            result = sqlSessionTemplate.selectOne(NAME_SPACE + SELECT_BY_STOREHOUSE_ID_AND_PRODUCT_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<StorehouseProductStock> listByStorehouseId(long storehouse_id, int page, int count, int tableIndex) throws Exception {
        List<StorehouseProductStock> results = null;
        try {
            HashMap<String, ? super Number> map = new HashMap<>();
            map.put("storehouse_id", storehouse_id);
            map.put("tableIndex", tableIndex);

            PageHelper.startPage(page, count);
            results = sqlSessionTemplate.selectList(NAME_SPACE + LIST_BY_STOREHOUSE_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public int countByStorehouseId(long storehouse_id, int tableIndex) throws Exception {
        int count = 0;

        try {
            Map<String, ? super Number> map = new HashMap<>();
            map.put("storehouse_id", storehouse_id);
            map.put("tableIndex", tableIndex);

            count = sqlSessionTemplate.selectOne(NAME_SPACE + COUNT_BY_STOREHOUSE_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
