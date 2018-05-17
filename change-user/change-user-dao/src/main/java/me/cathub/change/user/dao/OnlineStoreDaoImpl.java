package me.cathub.change.user.dao;

import me.cathub.change.api.dao.user.OnlineStoreDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.user.bean.OnlineStore;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 网店Dao实现类
 *
 * @author cheng
 */
@Repository
public class OnlineStoreDaoImpl extends BaseDaoMyBatisImpl<OnlineStore> implements OnlineStoreDao {

    @Override
    public boolean insert(OnlineStore bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(OnlineStore bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(OnlineStore bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(OnlineStore bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(OnlineStore bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public OnlineStore select(OnlineStore bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<OnlineStore> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<OnlineStore> listByDel(int page, int count, int tableIndex) throws Exception {
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
    public List<OnlineStore> listByShopkeeperId(long shopkeeperId, int page, int count, int tableIndex) throws Exception {
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
}
