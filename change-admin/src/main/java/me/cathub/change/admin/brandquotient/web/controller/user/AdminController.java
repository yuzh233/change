package me.cathub.change.admin.brandquotient.web.controller.user;

import me.cathub.change.api.rpc.server.user.AdminRpcServer;
import me.cathub.change.common.base.BaseControllerImpl;
import me.cathub.change.common.base.PageResult;
import me.cathub.change.user.bean.Admin;
import me.cathub.change.user.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 用户模块下的管理crud
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseControllerImpl<Admin, AdminRpcServer>{

    //模拟数据
    static List<User> aaa = new ArrayList();
    static{
        User user = new User();
        user.setId(12313);
        user.setPassword("1231");
        user.setUsername("lisa");
        user.setPhone("12345678977");
        user.setStatus(1);
        user.setEmail("104564@1231.com");
        User user2 = new User();
        user2.setId(456789);
        user2.setCreateDate(new Date());
        user2.setUpdateDate(new Date());
        user2.setPassword("1231");
        user2.setUsername("lisa");
        user2.setPhone("12345678977");
        user2.setEmail("104564@1231.com");
        aaa.add(user);
        aaa.add(user2);
    }


    //测试与前台交互
    @RequestMapping("/inserts")
    @ResponseBody
    public boolean inserts(Admin bean) throws Exception {
        System.out.println(bean);
        bean.setId(3);
        aaa.add(bean);
        return true;
    }

    //测试与前台交互
    @RequestMapping("/lists")
    @ResponseBody
    public Object lists(Integer page, Integer count, Integer tableIndex, String searchText, HttpServletRequest request,
                        HttpServletResponse response) throws Exception {
        System.out.println(page + "," + count + "," + tableIndex);

        /**
         * 自己封装的数据返回类型，bootstrap-table要求服务器返回的json数据必须包含：total，rows（即实际数据）两个节点
         * bootstrap-table根据服务器端返回的total，以及table设定的pageSize，自动生成分页的页面元素，每次点击下一页或者指定页码，
         * bootstrap-table会自动给参数pageNumber赋值，服务器返回指定页的数据。
         */
        Map map = new HashMap();
        map.put("rows", aaa);
        map.put("total", 100);
        return new PageResult(aaa,100);
    }

    //测试与前台交互
    @RequestMapping("/updates")
    @ResponseBody
    public boolean update(Admin bean) throws Exception {
        System.out.println("【update:->】"+bean);
        User temp = null;
        for (User admin : aaa) {
            if(admin.getId() == bean.getId()){
                temp = admin;
            }
        }
        aaa.remove(temp);
        aaa.add(bean);
        return true;
    }

    //测试删除
    @RequestMapping("/delete")
    @ResponseBody
    public boolean deleteL(@RequestParam(value = "ids[]") Integer[] ids){
        System.out.println(ids.toString());
        List<Integer> delList = new ArrayList();
        if(ids.length != 0){
            for(int i = 0; i < ids.length ; i++){
                for (int j = 0; j < aaa.size(); j++) {
                    if(aaa.get(j).getId() == ids[i]){
                        delList.add(j);
                    }
                }
            }
        }
        for (Integer j : delList) {
            aaa.remove(aaa.get(j));
        }
        return true;
    }



}
