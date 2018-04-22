package me.cathub.change.user.dao;

import me.cathub.change.api.dao.user.CompanyDao;
import me.cathub.change.common.base.BaseCrudMyBatisImpl;
import me.cathub.change.user.bean.Company;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CompanyDaoImpl extends BaseCrudMyBatisImpl<Company> implements CompanyDao {

    @Override
    public boolean insert(Company bean) throws Exception {
        return insert(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteL(Company bean) throws Exception {
        return deleteL(NAME_SPACE, bean);
    }

    @Override
    public boolean restore(Company bean) throws Exception {
        return restore(NAME_SPACE, bean);
    }

    @Override
    public boolean deleteP(Company bean) throws Exception {
        return deleteP(NAME_SPACE, bean);
    }

    @Override
    public boolean update(Company bean) throws Exception {
        return update(NAME_SPACE, bean);
    }

    @Override
    public Company select(Company bean) throws Exception {
        return select(NAME_SPACE, bean);
    }

    @Override
    public List<Company> list(int page, int count, int tableIndex) throws Exception {
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
    public Company selectByName(String name, int tableIndex) throws Exception {
        Company result = null;
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
