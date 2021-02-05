package com.buaa1921rlb.contact.controller.api;

import com.buaa1921rlb.contact.entity.User;
import com.buaa1921rlb.contact.entity.other.RestResp;
import com.buaa1921rlb.contact.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public RestResp userLogin(@RequestParam("mobile") String mobile,
                              @RequestParam("password") String password) {
        boolean isMobileRegister = userService.checkMobileExists(mobile);
        if(!isMobileRegister) return RestResp.fail("账号未注册");

        User user = userService.loginByMobile(mobile, password);
        if(user == null) return RestResp.fail("用户名或密码错误");
        Map<String, String> data = new HashMap<>();
        data.put("id",user.getId().toString());
        data.put("token", user.getToken());
        return RestResp.ok(data);
    }
}
