package life.majiang.community.controller;
/**
 * ClassName: OrderController <br/>
 * Description: <br/>
 * date: 2020/2/5 7:30 下午<br/>
 *
 * @author Hesion <br/>
 * @version
 * @since JDK 1.8
 */

import life.majiang.community.model.Order;
import life.majiang.community.model.OrderExample;
import life.majiang.community.service.OrderService;
import life.majiang.community.utils.AjaxResponse;
import life.majiang.community.utils.OrderCodeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @program: community
 * @description:
 * @author: hesion
 * @create: 2020-02-05 19:30
 **/
@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/order/{uId}")
    public String order(@PathVariable(name = "uId") String uId,
                        Model model) {
        List<OrderExample> orders = orderService.orderList(uId);
        model.addAttribute("orders", orders);
        return "order";
    }

    @ResponseBody
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public AjaxResponse addOrder(@RequestBody Order order) {
        order.setId(OrderCodeFactory.getOrderCode(order.getQuestionId()));
        order.setCreateTime(new Date());
        order.setDel_flag("0");
        int isAdd = orderService.addOrder(order);
        if (isAdd == 1) {
            return AjaxResponse.success();
        }
        return AjaxResponse.fail();
    }
}
