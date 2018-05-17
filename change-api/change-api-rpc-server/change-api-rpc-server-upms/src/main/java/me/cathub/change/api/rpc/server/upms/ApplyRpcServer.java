package me.cathub.change.api.rpc.server.upms;

import me.cathub.change.common.base.BaseRpcServer;
import me.cathub.change.common.base.ServerSelectByName;
import me.cathub.change.upms.bean.Apply;

/**
 * 应用Ppc服务接口
 *
 * @author cheng
 */
public interface ApplyRpcServer extends BaseRpcServer<Apply>, ServerSelectByName<Apply> {
}
