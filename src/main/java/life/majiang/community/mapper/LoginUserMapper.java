package life.majiang.community.mapper;

import life.majiang.community.model.LoginUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * ClassName: LoginUserMapper <br/>
 * Description: <br/>
 * date: 2020/2/4 8:49 下午<br/>
 *
 * @author Hesion <br/>
 * @since JDK 1.8
 */
@Mapper
public interface LoginUserMapper {
    @Select("select id,username,createTime from loginuser where username = #{loginUser.username} AND password = #{loginUser.password}")
    LoginUser login(@Param("loginUser") LoginUser loginUser);
}
