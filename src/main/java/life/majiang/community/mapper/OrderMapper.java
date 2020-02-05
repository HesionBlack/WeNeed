package life.majiang.community.mapper;

import life.majiang.community.model.Order;
import life.majiang.community.model.OrderExample;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName: ORderMapper <br/>
 * Description: <br/>
 * date: 2020/2/5 8:18 下午<br/>
 *
 * @author Hesion <br/>
 * @since JDK 1.8
 */
@Mapper
public interface OrderMapper {
    @Select("SELECT * FROM v_orderExample WHERE buyerId=#{buyerId}")
    List<OrderExample> orderList(String userId);

    @Insert("INSERT INTO `order` VALUES(#{s.id},#{s.buyerId},#{s.providerId},#{s.questionId},#{s.description},#{s.number},current_timestamp(),#{s.del_flag})")
    int addOrder(@Param("s") Order order);

}
