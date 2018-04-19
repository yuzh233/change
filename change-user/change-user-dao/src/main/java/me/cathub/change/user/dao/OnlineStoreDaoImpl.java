package me.cathub.change.user.dao;

import com.github.pagehelper.PageHelper;
import me.cathub.change.api.dao.user.OnlineStoreDao;
import me.cathub.change.common.base.BaseIbatis;
import me.cathub.change.user.bean.OnlineStore;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OnlineStoreDaoImpl extends BaseIbatis<OnlineStore> implements OnlineStoreDao {

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
    public long count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public long clear(int tableIndex) throws Exception {
        return clear(NAME_SPACE, tableIndex);
    }

    @Override
    public List<OnlineStore> listByShopkeeperId(long shopkeeper_id, int page, int count, int tableIndex) throws Exception {
        List<OnlineStore> results = null;
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
}
