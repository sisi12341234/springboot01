package com.example.listtest.controller;

import com.example.listtest.model.Person;
import com.example.listtest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    PersonService personService;

    // 设置访问路由值为路径
    @RequestMapping("/test")
    public ModelAndView index(){
        // 顾名思义 实体和数据 同时返回页面模板和数据
        ModelAndView mav = new ModelAndView("test");
        List<Person> list = personService.getAll();
        mav.addObject("list",list);
        return mav;
    }


}