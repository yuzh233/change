package me.cathub.change.user.dao;

import me.cathub.change.api.dao.user.ShopkeeperDao;
import me.cathub.change.common.base.BaseDaoMyBatisImpl;
import me.cathub.change.common.bean.user.Shopkeeper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ShopkeeperDaoImpl extends BaseDaoMyBatisImpl<Shopkeeper> implements ShopkeeperDao {

    @Override
    public boolean insert(Shopkeeper bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(Shopkeeper bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(Shopkeeper bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(Shopkeeper bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(Shopkeeper bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public Shopkeeper select(Shopkeeper bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<Shopkeeper> list(int page, int count, int tableIndex) throws Exception {
        return list(NAME_SPACE, page, count, tableIndex);
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return count(NAME_SPACE, tableIndex);
    }

    @Override
    public List<Shopkeeper> listByDel(int page, int count, int tableIndex) throws Exception {
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
    public Shopkeeper login(Shopkeeper bean) throws Exception {
        Shopkeeper result = null;
        try {
            result = sqlSessionTemplate.selectOne(NAME_SPACE + LOGIN, bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Shopkeeper selectByName(String name, int tableIndex) throws Exception {
        Shopkeeper result = null;
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("name", name);
            map.put("tableIndex", tableIndex);
            result = sqlSessionTemplate.selectOne(NAME_SPACE + SELECT_BY_NAME, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
