package me.cathub.change.product.rpc.server;

import me.cathub.change.api.dao.product.PropertyDao;
import me.cathub.change.api.rpc.server.product.ProductCategoryRpcServer;
import me.cathub.change.api.rpc.server.product.PropertyRpcServer;
import me.cathub.change.common.tool.Sequence;
import me.cathub.change.product.bean.ProductCategory;
import me.cathub.change.product.bean.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PropertyRpcServerImpl implements PropertyRpcServer {

    @Autowired
    private PropertyDao propertyDao;

    @Autowired
    private ProductCategoryRpcServer productCategoryRpcServer;

    @Autowired
    private Sequence sequence;

    @Override
    public long insert(Property bean) throws Exception {
        bean.setId(sequence.nextId());
        return propertyDao.insert(bean) ? bean.getId() : -1;
    }

    @Override
    public boolean deleteL(Property bean) throws Exception {
        return propertyDao.deleteL(bean);
    }

    @Override
    public boolean restore(Property bean) throws Exception {
        return propertyDao.restore(bean);
    }

    @Override
    public boolean deleteP(Property bean) throws Exception {
        return propertyDao.deleteP(bean);
    }

    @Override
    public boolean update(Property bean) throws Exception {
        return propertyDao.update(bean);
    }

    @Override
    public Property select(Property bean, boolean flag) throws Exception {
        if (flag)
            return propertyDao.select(bean);
        else
            return fill(propertyDao.select(bean));
    }

    @Override
    public List<Property> list(int page, int count, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return propertyDao.list(page, count, tableIndex);
        else
            return propertyDao.list(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int count(int tableIndex) throws Exception {
        return propertyDao.count(tableIndex);
    }

    @Override
    public List<Property> listByDel(int page, int count, int tableIndex, boolean flag) throws Exception {
        return propertyDao.listByDel(page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByDel(int tableIndex) throws Exception {
        return propertyDao.countByDel(tableIndex);
    }

    @Override
    public int clear(int tableIndex) throws Exception {
        return propertyDao.count(tableIndex);
    }

    @Override
    public Property selectByName(String name, int tableIndex, boolean flag) throws Exception {
        if (flag)
            return propertyDao.selectByName(name, tableIndex);
        else
            return fill(propertyDao.selectByName(name, tableIndex));
    }

    @Override
    public List<Property> listByProductCategoryId(long productCategory_id, int page, int count, int tableIndex, boolean flag) throws Exception {
        return propertyDao.listByProductCategoryId(productCategory_id, page, count, tableIndex).stream()
                .map(bean -> fill(bean))
                .collect(toList());
    }

    @Override
    public int countByProductCategoryId(long productCategory_id, int tableIndex) throws Exception {
        return propertyDao.countByProductCategoryId(productCategory_id, tableIndex);
    }

    @Override
    public Property fill(Property bean) {
        try {
            ProductCategory productCategory = productCategoryRpcServer.select(new ProductCategory(bean.getProductCategory_id()), true);

            bean.setProductCategory(productCategory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
