package sdm.admin.api;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("user")
@Component
@RestController
public class UserApi {

    @RequestMapping("/queryCurrent")
    @ResponseBody
    public String queryCurrent(HttpServletRequest request) {
        return "Hello World!!!!!!!!" ;
    }

}
