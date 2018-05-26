package me.cathub.change.apply.web.controller.temp;

import me.cathub.change.apply.common.PlaceAnOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 下单页
 *  data:
 *      当前订单 and 当前订单的子订单项
 *
 *  action:
 *      预下单:生成订单,展示给前台用户确定
 *      下单:用户确定后完成下单
 *
 *  1. 用户下单:提交i(产品id-数量-仓库id)
 *  2. 生成订单存放到缓存,展示给用户确定
 *  3. 用户确定下单,存放到数据库,跳转到付款页面
 */

@RequestMapping("/placeAnOrder")
@Controller
public class PlaceAnOrderPageController {

    /**
     * 下单接口
     * @return
     * @throws Exception
     */
    @RequestMapping("/")
    public ModelAndView index(List<PlaceAnOrder> placeAnOrders) throws Exception {
        /**
         *
         */
        return null;
    }
}