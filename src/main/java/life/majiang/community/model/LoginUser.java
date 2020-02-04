package life.majiang.community.model;
/**
 * ClassName: LoginUser <br/>
 * Description: <br/>
 * date: 2020/2/4 8:41 下午<br/>
 *
 * @author Hesion <br/>
 * @version
 * @since JDK 1.8
 */

import lombok.Data;

import java.util.Date;

/**
 * @program: community
 * @description:
 * @author: hesion
 * @create: 2020-02-04 20:41
 **/
@Data
public class LoginUser {
    private String id;
    private String username;
    private String password;
    private Date createTime;
}
