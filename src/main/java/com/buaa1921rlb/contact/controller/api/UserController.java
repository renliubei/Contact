package com.buaa1921rlb.contact.controller.api;

import com.buaa1921rlb.contact.entity.User;
import com.buaa1921rlb.contact.entity.other.RestResp;
import com.buaa1921rlb.contact.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/register")
    public RestResp register(@RequestParam("mobile") String mobile,
                             @RequestParam("password") String password,
                             @RequestParam("username") String username,
                             @RequestParam("sex") String sex) {
        boolean isMobileRegistered  = userService.checkMobileExists(mobile);
        if(isMobileRegistered) return RestResp.fail("该手机号已注册，请直接登录");
        Integer sex_int = Integer.parseInt(sex);
        int res = userService.register(mobile,password,username,sex_int);
        if(1 == res) return RestResp.OK;
        return RestResp.fail("注册失败，请再尝试一次");
    }

    @PostMapping("/login")
    public RestResp userLogin(@RequestParam("mobile") String mobile,
                              @RequestParam("password") String password) {
        boolean isMobileRegistered = userService.checkMobileExists(mobile);
        if(!isMobileRegistered) return RestResp.fail("账号未注册");

        User user = userService.loginByMobile(mobile, password);
        if(user == null) return RestResp.fail("密码错误或账号已被删除");
        Map<String, String> data = new HashMap<>();
        data.put("id",user.getId().toString());
        data.put("token", user.getToken());
        return RestResp.ok(data);
    }

    @PostMapping("/changePassword")
    public RestResp changePassword(@RequestParam("id") Integer id,
                                   @RequestParam("password") String password) {
        int res = userService.changePassword(id, password);
        if(1 == res) return RestResp.OK;
        return RestResp.fail("修改失败");
    }
}
