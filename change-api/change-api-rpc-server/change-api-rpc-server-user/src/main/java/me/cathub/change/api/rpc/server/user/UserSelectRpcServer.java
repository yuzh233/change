package me.cathub.change.api.rpc.server.user;

import me.cathub.change.common.bean.User;
import me.cathub.change.user.bean.Admin;
import me.cathub.change.user.bean.BrandQuotient;
import me.cathub.change.user.bean.Shopkeeper;

/**
 * 用户查询Rpc服务接口:统一用户查询接口
 *
 * @author cheng
 */
public interface UserSelectRpcServer {

    /**
     * 查询数据(ID)
     * @param id
     * @param flag
     * @param type
     * @param tableIndex
     * @return
     * @throws Exception
     */
    User select(long id, boolean flag, int tableIndex, int type) throws Exception;

    /**
     * 查询数据(Name)
     * @param name
     * @param tableIndex
     * @param flag
     * @param type
     * @return
     * @throws Exception
     */
    User selectByName(String name, int tableIndex, boolean flag, int type) throws Exception;

    BrandQuotient selectBrandQuotient(long id, int tableIndex, boolean flag) throws Exception;
    Admin selectAdmin(long id, int tableIndex, boolean flag) throws Exception;
    Shopkeeper selectShopkeeper(long id, int tableIndex, boolean flag) throws Exception;
}