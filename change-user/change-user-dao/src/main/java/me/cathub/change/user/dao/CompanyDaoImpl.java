package me.cathub.change.user.dao;

import me.cathub.change.api.dao.user.CompanyDao;
import me.cathub.change.common.base.BaseIbatis;
import me.cathub.change.user.bean.Company;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDaoImpl extends BaseIbatis<Company> implements CompanyDao {

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
}
