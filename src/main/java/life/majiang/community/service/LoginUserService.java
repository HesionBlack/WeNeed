package life.majiang.community.service;

import life.majiang.community.mapper.LoginUserMapper;
import life.majiang.community.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: LoginUserService <br/>
 * Description: <br/>
 * date: 2020/2/4 8:47 下午<br/>
 *
 * @author Hesion <br/>
 * @since JDK 1.8
 */
@Service
public class LoginUserService {
    @Autowired
    LoginUserMapper loginUserMapper;

    public LoginUser login(LoginUser loginUser) {
        return loginUserMapper.login(loginUser);
    }

    public int isRegister(String username) {
        return loginUserMapper.isRegister(username);
    }

    public void goRegister(LoginUser login) {
        loginUserMapper.doRegister(login);
    }
}
