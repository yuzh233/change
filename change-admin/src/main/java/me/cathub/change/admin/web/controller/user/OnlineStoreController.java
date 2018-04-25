package me.cathub.change.admin.web.controller.user;

import me.cathub.change.api.rpc.server.user.OnlineStoreRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.user.bean.OnlineStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/onlineStore")
public class OnlineStoreController extends BaseControllerImpl<OnlineStore, OnlineStoreRpcServer> {
}
