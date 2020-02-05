package life.majiang.community.controller;

import life.majiang.community.model.LoginUser;
import life.majiang.community.model.User;
import life.majiang.community.provider.GithubProvider;
import life.majiang.community.service.LoginUserService;
import life.majiang.community.service.UserService;
import life.majiang.community.utils.AjaxResponse;
import life.majiang.community.utils.MyMD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

/**
 * Created by codedrinker on 2019/4/24.
 */
@Controller
@Slf4j
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

//    @Value("${github.client.id}")
//    private String clientId;
//
//    @Value("${github.client.secret}")
//    private String clientSecret;
//
//    @Value("${github.redirect.uri}")
//    private String redirectUri;

    @Autowired
    private UserService userService;
    @Autowired
    private LoginUserService loginUserService;

    @PostMapping("/callback")
    public String callback(LoginUser login,
                           HttpServletResponse response) {
//        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
////        accessTokenDTO.setClient_id(clientId);
////        accessTokenDTO.setClient_secret(clientSecret);
////        accessTokenDTO.setCode(code);
////        accessTokenDTO.setRedirect_uri(redirectUri);
////        accessTokenDTO.setState(state);
////        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
////        GithubUser githubUser = githubProvider.getUser(accessToken);
        login.setPassword(MyMD5Util.encrypt(login.getPassword()));
        LoginUser loginUser = loginUserService.login(login);
        if (loginUser != null && loginUser.getId() != null) {
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(loginUser.getUsername());
            user.setAccountId(String.valueOf(loginUser.getId()));
            user.setAvatarUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1580831055654&di=c32765d5387c858dbf581ee3888fc07e&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201804%2F18%2F20180418185826_skjbx.jpg");
            userService.createOrUpdate(user);
            Cookie cookie = new Cookie("token", token);
            cookie.setMaxAge(60 * 60 * 24 * 30 * 6);
            response.addCookie(cookie);
            return "redirect:/";
        } else {
            log.error("账号或者密码错误", loginUser);
            // 登录失败，重新登录
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }
    @PostMapping("/reg")
    @ResponseBody
    public AjaxResponse reg(LoginUser login){
        login.setPassword(MyMD5Util.encrypt(login.getPassword()));
        login.setCreateTime(new Date());
        int register = loginUserService.isRegister(login.getUsername());
        System.out.println(register);
        if (register == 0 ){
            login.setId(UUID.randomUUID().toString());
            loginUserService.goRegister(login);
            return AjaxResponse.success();
        }else {
            return AjaxResponse.fail("用户已经注册");
        }
    }
}
