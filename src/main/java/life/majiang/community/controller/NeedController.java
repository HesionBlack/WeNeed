package life.majiang.community.controller;
/**
 * ClassName: NeedController <br/>
 * Description: <br/>
 * date: 2020/2/5 7:42 上午<br/>
 *
 * @author Hesion <br/>
 * @version
 * @since JDK 1.8
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: community
 * @description:
 * @author: hesion
 * @create: 2020-02-05 07:42
 **/
@Controller
@ResponseBody
public class NeedController {
    @GetMapping("needList")
    public String needList(){

        return "2";
    }
}
