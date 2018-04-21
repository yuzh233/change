package me.cathub.change.admin.brandquotient.web.controller.user;

import me.cathub.change.api.rpc.server.user.OnlineStoreRpcServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/onlineStore")
public class OnlineStoreController {

    @Autowired
    private OnlineStoreRpcServer onlineStoreRpcServer;
}
