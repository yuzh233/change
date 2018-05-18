package me.cathub.change.upms.server.common;

import me.cathub.change.api.rpc.server.upms.PermissionRpcServer;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {

    @Autowired
    private RoleRpcServer roleRpcServer;
    private PermissionRpcServer permissionRpcServer;

    /**
     * 工厂方法
     * @return
     */
    public LinkedHashMap<String, String> build () {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();



        return map;
    }

    public void setRoleRpcServer(RoleRpcServer roleRpcServer) {
        this.roleRpcServer = roleRpcServer;
    }

    public void setPermissionRpcServer(PermissionRpcServer permissionRpcServer) {
        this.permissionRpcServer = permissionRpcServer;
    }
}
