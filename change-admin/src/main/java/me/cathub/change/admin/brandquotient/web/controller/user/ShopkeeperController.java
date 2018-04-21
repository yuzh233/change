package me.cathub.change.admin.brandquotient.web.controller.user;

import me.cathub.change.api.rpc.server.user.ShopkeeperRpcRpcServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shopkeeper")
public class ShopkeeperController {

    @Autowired
    private ShopkeeperRpcRpcServer shopkeeperRpcServer;
}
