package me.cathub.change.order.dao;

import me.cathub.change.api.dao.order.OrderDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.order.bean.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单Dao实现
 *
 * @author cheng
 */
@Repository
public class OrderDaoImpl extends BaseDaoMyBatisImpl<Order> implements OrderDao {

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
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<Order> listByDel(int page, int count, int tableIndex) throws Exception {
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
    public List<Order> listByStorehouseId(long storehouseId, int page, int count, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
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
    public List<Order> listByShopkeeperId(long shopkeeperId, int page, int count, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("shopkeeper_id", shopkeeperId);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_SHOPKEEPER_ID, page, count, map);
    }

    @Override
    public int countByShopkeeperId(long shopkeeperId, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("shopkeeper_id", shopkeeperId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_SHOPKEEPER_ID, map);
    }

    @Override
    public List<Order> listByCompanyId(long companyId, int page, int count, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("brandQuotient_id", companyId);
        map.put("tableIndex", tableIndex);

        return baseList(NAME_SPACE + LIST_BY_COMPANY_ID, page, count, map);
    }

    @Override
    public int countByCompanyId(long companyId, int tableIndex) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        map.put("brandQuotient_id", companyId);
        map.put("tableIndex", tableIndex);

        return baseCount(NAME_SPACE + COUNT_BY_COMPANY_ID, map);
    }
}
