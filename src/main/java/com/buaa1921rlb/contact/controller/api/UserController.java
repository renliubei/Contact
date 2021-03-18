package com.buaa1921rlb.contact.controller.api;

import com.buaa1921rlb.contact.entity.User;
import com.buaa1921rlb.contact.entity.other.RestResp;
import com.buaa1921rlb.contact.services.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.buaa1921rlb.contact.constant.StatusType.SUCCESS;
import static com.buaa1921rlb.contact.constant.UserType.USER;

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
                              @RequestParam("password") String password,
                              HttpServletRequest request) {
        boolean isMobileRegistered = userService.checkMobileExists(mobile);
        if(!isMobileRegistered) return RestResp.fail("账号未注册");

        User user = userService.loginByMobile(mobile, password);
        if(user == null) return RestResp.fail("密码错误或账号已被删除");

        request.getSession().setAttribute("user_type",USER);
        request.getSession().setMaxInactiveInterval(240 * 60);
        Map<String, String> data = new HashMap<>();
        data.put("id",user.getId().toString());
        data.put("token", user.getToken());
        data.put("username", user.getUsername());
        return RestResp.ok(data);
    }

    @PostMapping("logout")
    public RestResp userLogout(@RequestParam("id") Integer id, HttpServletRequest request) {
        userService.logout(id);
        request.getSession().invalidate();
        return RestResp.ok("注销成功!");
    }

    @PostMapping("/changePassword")
    public RestResp changePassword(@RequestParam("id") Integer id,
                                   @RequestParam("password") String password) {
        int res = userService.changePassword(id, password);
        if(1 == res) return RestResp.OK;
        return RestResp.fail("修改失败");
    }
}
