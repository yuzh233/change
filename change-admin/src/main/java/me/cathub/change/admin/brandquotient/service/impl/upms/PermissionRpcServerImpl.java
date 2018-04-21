package me.cathub.change.admin.brandquotient.service.impl.upms;

import me.cathub.change.admin.brandquotient.service.inter.upms.PermissionService;
import me.cathub.change.common.base.BaseRpcServerImpl;
import me.cathub.change.upms.bean.Permission;
import org.springframework.stereotype.Service;

@Service
public class PermissionRpcServerImpl extends BaseRpcServerImpl<Permission, PermissionRpcServerImpl> implements PermissionService {
}
