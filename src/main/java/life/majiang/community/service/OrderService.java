package life.majiang.community.service;
/**
 * ClassName: OrderService <br/>
 * Description: <br/>
 * date: 2020/2/5 8:11 下午<br/>
 *
 * @author Hesion <br/>
 * @version
 * @since JDK 1.8
 */

import life.majiang.community.mapper.OrderMapper;
import life.majiang.community.model.Order;
import life.majiang.community.model.OrderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: community
 * @description:
 * @author: hesion
 * @create: 2020-02-05 20:11
 **/
@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;
    public List<OrderExample> orderList(String uId) {
        return orderMapper.orderList(uId);
    }

    public int addOrder(Order order) {
        return orderMapper.addOrder(order);
    }
}
