package me.cathub.change.api.rpc.server.user;

import me.cathub.change.common.bean.User;

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
     * @return
     * @throws Exception
     */
    User select(long id, boolean flag, int type) throws Exception;

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
}
