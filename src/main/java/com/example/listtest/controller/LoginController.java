package com.example.listtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    //@RequestMapping(value = "/user/adlogin",method = RequestMethod.POST)
    @PostMapping(value = "/test/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            //登录成功,防止表单重复提交可以重定向
            session.setAttribute("loginUser", username);
            map.put("username", "2313");
            return "redirect:/main.html";
        } else {
            //登录失败
            map.put("msg", "用户名或密码错误");
            return "login";
        }
    }
}
