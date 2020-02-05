package com.example.listtest.controller;

import com.example.listtest.model.User;
import com.example.listtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Controller
public class UserController {
    @Autowired
    UserService userService;
    // 设置访问路由值为路径
    //管理员和用户登录验证
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session){
        List<User> list = userService.getAll();
        System.out.println(username);
        System.out.println(password);
        if(!StringUtils.isEmpty(username)&&!StringUtils.isEmpty(password)){
            for (User user: list) {
                System.out.println(user.getUser_name());
                if(username.equals(user.getUser_telephone())){
                    if(password.equals(user.getUser_password())){
                        if(user.getUser_power()==0){
                            session.setAttribute("adminId",user.getUser_id());
                            session.setAttribute("adminUser", user.getUser_name());
                            return "redirect:/admin/index.html";
                        }
                        else{
                            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
                            HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
                            request.getSession(true).setAttribute("loginId",Integer.toString(user.getUser_id()));
                            session.setAttribute("loginId", user.getUser_id());
                            session.setAttribute("loginUser", user.getUser_name());
                            return "redirect:/main.html";
                        }
                    }
                    else {
                        map.put("msg", "密码错误");
                        return "/login.html";
                    }
                }

            }
            map.put("msg", "用户名不存在");
            return "/login.html";
        }
        else {
            map.put("msg", "用户名和密码不能为空");
            return "/login.html";
        }
    }
    //管理员退出登录
    @GetMapping(value = "/admin/logout")
    public String logout(HttpSession session){
        session.removeAttribute("adminUser");
        session.removeAttribute("adminId");
        return "login.html";
    }
    //注册验证
    @PostMapping(value = "/test/register")
    public String login(@RequestParam("username") String username,
                        @RequestParam("paw") String paw,
                        @RequestParam("telephone") String telephone,
                        @RequestParam("address") String address,
                        @RequestParam("email") String email,
                        Map<String, Object> map) {
        System.out.println(username);
        System.out.println(paw);
        List<User> list = userService.getAll();
        for (User user: list) {
            if(telephone.equals(user.getUser_telephone())){
                map.put("msg", "该用户已存在");
                return "register";
            }
        }
        Date d = new Date();
        User user = new User();
        user.setUser_name(username);
        user.setUser_password(paw);
        user.setUser_telephone(telephone);
        user.setUser_address(address);
        user.setUser_email(email);
        user.setUser_power(1);
        user.setUser_date(d);
        userService.insertAll(user);
        map.put("msg", "注册成功");
        return "register";
    }
    //获取管理员的信息
    @GetMapping(value = "/admin/select")
    public String profileSelect(HttpSession session, Map<String,Object> map){
        User admin = new User();
        int id = (int)session.getAttribute("adminId");
        List<User> list = userService.getAll();
        System.out.println(id);
        for (User user:list) {
            if(user.getUser_id()==id){
                admin.setUser_name(user.getUser_name());
                admin.setUser_password(user.getUser_password());
                admin.setUser_telephone(user.getUser_telephone());
                admin.setUser_email(user.getUser_email());
                admin.setUser_address(user.getUser_address());
                break;
            }
        }
        map.put("adminmessage",admin);
        System.out.println(admin.getUser_name());
        return "admin/profile.html";
    }
    //修改管理员的信息
    @PostMapping(value = "/admin/update")
    public String profileUpdate(@RequestParam("username") String username,
                                @RequestParam("password") String paw,
                                @RequestParam("telephone") String telephone,
                                @RequestParam("address") String address,
                                @RequestParam("email") String email,
                                HttpSession session, Map<String,Object> map){
        int id = (int)session.getAttribute("adminId");
        List<User> list = userService.getAll();
        System.out.println(id);
        for (User user:list) {
            if(user.getUser_id()==id){
                user.setUser_name(username);
                user.setUser_password(paw);
                user.setUser_telephone(telephone);
                user.setUser_address(address);
                user.setUser_email(email);
                userService.updateAdmin(user);
                break;
            }
        }
        map.put("msg","修改成功");
        return "redirect:/admin/select";
    }
    //获取用户的信息显示到管理员页面
    @GetMapping(value = "/admin/tableselect")
    public String userSelect(Map<String,Object> map){
        List<User> list = userService.getUser();
        map.put("userlist",list);
        return "admin/user.html";
    }
    //新增用户信息
    @PostMapping(value = "/admin/tableinsert")
    public String userSelect(@RequestParam("username") String username,
                        @RequestParam("paw") String paw,
                        @RequestParam("telephone") String telephone,
                        @RequestParam("address") String address,
                        @RequestParam("email") String email,
                        Map<String, Object> map) {
        System.out.println(username);
        System.out.println(paw);
        List<User> list = userService.getAll();
        for (User user: list) {
            if(telephone.equals(user.getUser_telephone())){
                map.put("msg", "该用户已存在");
                return "admin/userselect.html";
            }
            else {
                if(username.equals(user.getUser_name())){
                    map.put("msg", "名字已经被使用，请换一个名字");
                    return "admin/userselect.html";
                }
            }
        }
        Date d = new Date();
        User user = new User();
        user.setUser_name(username);
        user.setUser_password(paw);
        user.setUser_telephone(telephone);
        user.setUser_address(address);
        user.setUser_email(email);
        user.setUser_power(2);
        user.setUser_date(d);
        userService.insertAll(user);
        map.put("msg", "添加成功");
        return "redirect:/admin/tableselect";
    }
    //获取需要修改的用户信息显示
    @GetMapping(value = "/adminupdate/{id}")
    public String userupdate(@PathVariable("id") Integer userid, Map<String,Object> map){
        User user = new User();
        user = userService.getUserById(userid);
        map.put("updateuser",user);
        return "/admin/userupdate.html";
    }
    //更改用户的信息
    @PostMapping(value = "admin/tableupdate")
    public String userUpdate(@RequestParam("userid") Integer userid,
                             @RequestParam("username") String username,
                             @RequestParam("paw") String paw,
                             @RequestParam("telephone") String telephone,
                             @RequestParam("address") String address,
                             @RequestParam("email") String email,
                             @RequestParam("power") Integer power,
                             Map<String,Object> map){
        System.out.println(userid);
        User user = new User();
        user.setUser_id(userid);
        user.setUser_name(username);
        user.setUser_password(paw);
        user.setUser_telephone(telephone);
        user.setUser_email(email);
        user.setUser_address(address);
        user.setUser_power(power);
        userService.updateuser(user);
        map.put("msg", "修改成功");
        return "redirect:/admin/tableselect";
    }
    //删除用户的信息
    @GetMapping(value = "/admindelete/{id}")
    public String userdelete(@PathVariable("id") Integer userid, Map<String,Object> map){
        userService.deleteuser(userid);
        map.put("msg","删除成功");
        return "redirect:/admin/tableselect";
    }
}
