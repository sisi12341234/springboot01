package com.example.listtest.controller;

import com.example.listtest.model.Order;
import com.example.listtest.model.User;
import com.example.listtest.service.OrderService;
import com.example.listtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;

    @GetMapping(value = "/admin/orderselect")
    public String getAll(Map<String,Object> map){
        List<Order> list = orderService.getOrderName();
        map.put("orderlist",list);
        return "admin/order.html";
    }
    //新增预约信息
    @PostMapping(value = "/admin/orderinsert")
    public String orderSelect(@RequestParam("event") String event,
                             @RequestParam("telephone") String telephone,
                              @RequestParam("date") String date,
                             Map<String, Object> map) {
        List<User> list = userService.getAll();
        for (User user: list) {
            if(telephone.equals(user.getUser_telephone())){
                Order order = new Order();
                order.setOrder_user_id(user.getUser_id());
                order.setOrder_date(date);
                order.setOrder_event(event);
                order.setOrder_telephone(telephone);
                order.setOrder_sign(true);
                orderService.insertAll(order);
                map.put("msg", "添加成功");
                return "redirect:/admin/orderselect";
            }
        }
        map.put("msg", "该用户不存在");
        return "admin/orderselect.html";
    }
    //获取需要修改的预约信息显示
    @GetMapping(value = "/orderupdate/{id}")
    public String orderupdate(@PathVariable("id") Integer orderid, Map<String,Object> map){
        Order order = new Order();
        order = orderService.getOrNameById(orderid);
        map.put("updateorder",order);
        return "admin/orderupdate.html";
    }
    //更改预约的信息
    @PostMapping(value = "/admin/orderupdate")
    public String orderUpdate(@RequestParam("orderid") Integer orderid,
                            @RequestParam("username") String username,
                            @RequestParam("date") String date,
                            @RequestParam("event") String event,
                            @RequestParam("telephone") String telephone,
                            @RequestParam("sign") String sign,
                            Map<String,Object> map) throws ParseException {
        Order order = new Order();
        order.setOrder_id(orderid);
        List<User> list = userService.getAll();
        for (User user: list) {
            if(username.equals(user.getUser_name())){
                order.setOrder_user_id(user.getUser_id());
            }
        }
        order.setOrder_date(date);
        order.setOrder_event(event);
        order.setOrder_telephone(telephone);
        if(sign.equals("是")){
            order.setOrder_sign(true);
        }
        else {
            order.setOrder_sign(false);
        }
        orderService.updateorder(order);
        map.put("msg", "修改成功");
        return "redirect:/admin/orderselect";
    }
    //获取该用户的预约信息
    @GetMapping(value = "/reserve/orderselect")
    public String getUserAll(Map<String,Object> map){
        /*RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
        String d = (String) request.getSession().getAttribute("loginId");
        System.out.println(d);*/
        List<Order> list = orderService.getByUser(5);
        map.put("orderlist",list);
        return "reserve/bath.html";
    }
}
