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
public class Order {
    private String id;
    private String buyerId;
    private String providerId;
    private Long questionId;
    private String description;
    private Integer number;
    private Date createTime;
    private String del_flag;
}
