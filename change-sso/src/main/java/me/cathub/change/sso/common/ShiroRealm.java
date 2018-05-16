package me.cathub.change.sso.common;

import me.cathub.change.api.rpc.server.upms.PermissionRpcServer;
import me.cathub.change.api.rpc.server.upms.RoleRpcServer;
import me.cathub.change.api.rpc.server.user.AdminRpcServer;
import me.cathub.change.api.rpc.server.user.BrandQuotientRpcServer;
import me.cathub.change.api.rpc.server.user.ShopkeeperRpcServer;
import me.cathub.change.common.bean.upms.Permission;
import me.cathub.change.common.bean.upms.Role;
import me.cathub.change.common.bean.user.Admin;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 认证授权
 */
public class ShiroRealm extends AuthorizingRealm {
    Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    private ShopkeeperRpcServer shopkeeperRpcServer;

    private BrandQuotientRpcServer brandQuotientRpcServer;

    private AdminRpcServer adminRpcServer;

    private PermissionRpcServer permissionRpcServer;

    private RoleRpcServer roleRpcServer;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();

        Set<String> roles = new HashSet<>();
        Set<String> permissions = new HashSet<>();
        try {
            Admin admin = adminRpcServer.selectByName(username, 0, true);

            // 当前用户角色
            Role role = roleRpcServer.select(new Role(admin.getRole_id()), true);
            roles.add(role.getName());

            // 当前用户所有权限
            List<Permission> upmsPermissions = permissionRpcServer.listByRoleId(role.getId(), 0, Integer.MAX_VALUE, 0, true);
            for (Permission upmsPermission : upmsPermissions) {
                if (StringUtils.isNotBlank(upmsPermission.getName())) {
                    permissions.add(upmsPermission.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证用户
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();

        Admin user = null;
        try {
            if (adminRpcServer == null) {
                logger.info("RpcServer Is Null~");
            }
            user = adminRpcServer.selectByName(username, 0, true);
            logger.info("selectByName : " + user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            throw new UnknownAccountException();
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, user.getPassword(), getName());
        return info;
    }

    public void setShopkeeperRpcServer(ShopkeeperRpcServer shopkeeperRpcServer) {
        this.shopkeeperRpcServer = shopkeeperRpcServer;
    }

    public void setBrandQuotientRpcServer(BrandQuotientRpcServer brandQuotientRpcServer) {
        this.brandQuotientRpcServer = brandQuotientRpcServer;
    }

    public void setAdminRpcServer(AdminRpcServer adminRpcServer) {
        this.adminRpcServer = adminRpcServer;
    }

    public void setPermissionRpcServer(PermissionRpcServer permissionRpcServer) {
        this.permissionRpcServer = permissionRpcServer;
    }

    public void setRoleRpcServer(RoleRpcServer roleRpcServer) {
        this.roleRpcServer = roleRpcServer;
    }
}
