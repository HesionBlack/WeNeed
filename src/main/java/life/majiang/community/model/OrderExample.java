package life.majiang.community.model;

import lombok.Data;

import java.util.Date;

/**
 * ClassName: Order <br/>
 * Description: <br/>
 * date: 2020/2/5 7:57 下午<br/>
 *
 * @author Hesion <br/>
 * @since JDK 1.8
 */
@Data
public class OrderExample {
    private String id;
    private String buyerId;
    private String providerId;
    private Long questionId;
    /**
     * @Author hst
     * @Description //TODO 供货者姓名
     * @Date 8:36 下午 2020/2/5
     **/
    private String pName;
    private String description;
    private Integer number;
    private Date createTime;
    private String del_flag;
}
