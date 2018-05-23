package me.cathub.change.upms.sso.common;

import me.cathub.change.api.rpc.server.upms.ApplyRpcServer;
import me.cathub.change.api.rpc.server.upms.RolePermissionRpcServer;
import me.cathub.change.upms.bean.Apply;
import me.cathub.change.upms.bean.RolePermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * 角色权限工厂
 *
 * @author cheng
 */
public class RolePermissionFactory {

    private Logger logger = LoggerFactory.getLogger(RolePermissionFactory.class);

    private String applyName;

    private RolePermissionRpcServer rolePermissionRpcServer;
    private ApplyRpcServer applyRpcServer;

    /**
     * 填充角色权限
     * @return
     */
    public Map<String, List<String>> fillRolePermission() {
        logger.info(applyName);

        /**
         * 获取当前系统的所有角色
         * 获取角色的所有权限
         */

        Map<String, List<String>> rPs = new TreeMap<>();
        try {
            Apply apply = applyRpcServer.selectByName(applyName, 0, true);
            List<RolePermission> rolePermissions = rolePermissionRpcServer.listByApplyId(apply.getId(), 0, Integer.MAX_VALUE, 0, false);
            Map<String, List<RolePermission>> temp = rolePermissions.stream()
                    .collect(Collectors.groupingBy(bean -> bean.getRole().getName()));

            for (Map.Entry<String, List<RolePermission>> entry : temp.entrySet()) {
                List<String> permissions = entry.getValue().stream()
                        .map(bean -> bean.getPermission().getUrl())
                        .collect(toList());

                rPs.put(entry.getKey(), permissions);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rPs;
    }

    public void setRolePermissionRpcServer(RolePermissionRpcServer rolePermissionRpcServer) {
        this.rolePermissionRpcServer = rolePermissionRpcServer;
    }

    public void setApplyRpcServer(ApplyRpcServer applyRpcServer) {
        this.applyRpcServer = applyRpcServer;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }
}
