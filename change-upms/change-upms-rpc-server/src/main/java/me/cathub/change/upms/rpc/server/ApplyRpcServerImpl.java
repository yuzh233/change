package me.cathub.change.upms.rpc.server;

import me.cathub.change.api.dao.upms.ApplyDao;
import me.cathub.change.api.rpc.server.upms.ApplyRpcServer;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.upms.bean.Apply;
import org.springframework.stereotype.Service;

/**
 * 应用Rpc服务实现类
 *
 * @author cheng
 */
@Service
public class ApplyRpcServerImpl extends BaseRpcServerImpl<Apply, ApplyDao> implements ApplyRpcServer {

    @Override
    public Apply selectByName(String name, int tableIndex, boolean flag) throws Exception {
        return dao.selectByName(name, tableIndex);
    }

    @Override
    public Apply fill(Apply bean) {
        return bean;
    }
}
