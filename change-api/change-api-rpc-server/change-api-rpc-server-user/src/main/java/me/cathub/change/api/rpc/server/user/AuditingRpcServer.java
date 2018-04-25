package me.cathub.change.api.rpc.server.user;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.FillAssociationDate;
import me.cathub.change.user.bean.Auditing;

import java.util.List;

public interface AuditingRpcServer extends BaseRpcServer<Auditing>, FillAssociationDate<Auditing> {

    /**
     * 根据管理员和类型获取审核列表
     * @param admin_id
     * @param type 用户类型
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<Auditing> listByAdminIdAndUserType(long admin_id, int type, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据管理员和类型获取审核数量
     * @param admin_id
     * @param type 用户类型
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByAdminIdAndUserType(long admin_id, int type, int tableIndex) throws Exception;

    /**
     * 根据用户类型获取未审核的列表
     * @param type 用户类型
     * @param tableIndex
     * @return
     * @throws Exception
     */
    List<Auditing> listByNotAuditing(int type, int page, int count, int tableIndex) throws Exception;

    /**
     * 根据用户类型获取未审核的数量
     * @param type 用户类型
     * @param tableIndex
     * @return
     * @throws Exception
     */
    int countByNotAuditing(int type, int tableIndex) throws Exception;
}
