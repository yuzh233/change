package me.cathub.change.order.dao;

import com.github.pagehelper.PageHelper;
import me.cathub.change.api.dao.order.OrderDao;
import me.cathub.change.common.base.BaseCrudMyBatisImpl;
import me.cathub.change.order.bean.Order;
import me.cathub.change.user.bean.BrandQuotient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDaoImpl extends BaseCrudMyBatisImpl<Order> implements OrderDao {

    @Override
    public boolean insert(Order bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(Order bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(Order bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(Order bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(Order bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public Order select(Order bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<Order> list(int page, int count, int tableIndex) throws Exception {
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
    public List<Order> listByStorehouseId(long storehouse_id, int page, int count, int tableIndex) throws Exception {
        List<Order> results = null;

        try {
            Map<String, ? super Number> map = new HashMap<>();
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

    @Override
    public List<Order> listByShopkeeperId(long shopkeeper_id, int page, int count, int tableIndex) throws Exception {
        List<Order> results = null;

        try {
            Map<String, ? super Number> map = new HashMap<>();
            map.put("shopkeeper_id", shopkeeper_id);
            map.put("tableIndex", tableIndex);

            PageHelper.startPage(page, count);
            results = sqlSessionTemplate.selectList(NAME_SPACE + LIST_BY_SHOPKEEPER_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

    @Override
    public int countByShopkeeperId(long shopkeeper_id, int tableIndex) throws Exception {
        int count = 0;

        try {
            Map<String, ? super Number> map = new HashMap<>();
            map.put("shopkeeper_id", shopkeeper_id);
            map.put("tableIndex", tableIndex);

            count = sqlSessionTemplate.selectOne(NAME_SPACE + COUNT_BY_SHOPKEEPER_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    @Override
    public List<Order> listByBrandQuotient(long brandQuotient_id, int page, int count, int tableIndex) throws Exception {
        List<Order> results = null;

        try {
            Map<String, ? super Number> map = new HashMap<>();
            map.put("brandQuotient_id", brandQuotient_id);
            map.put("tableIndex", tableIndex);

            PageHelper.startPage(page, count);
            results = sqlSessionTemplate.selectList(NAME_SPACE + LIST_BY_BRAND_QUOTIENT_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

    @Override
    public int countBrandQuotientId(long brandQuotient_id, int tableIndex) {
        int count = 0;

        try {
            Map<String, ? super Number> map = new HashMap<>();
            map.put("brandQuotient_id", brandQuotient_id);
            map.put("tableIndex", tableIndex);

            count = sqlSessionTemplate.selectOne(NAME_SPACE + COUNT_BY_BRAND_QUOTIENT_ID, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
}
