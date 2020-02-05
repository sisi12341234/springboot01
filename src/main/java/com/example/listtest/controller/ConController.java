package com.example.listtest.controller;

import com.example.listtest.model.Consume;
import com.example.listtest.service.ConService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class ConController {
    @Autowired
    ConService conService;
    @GetMapping(value = "/admin/conselect")
    public String getAll(Map<String,Object> map){
        List<Consume> list = conService.getAll();
        System.out.println(list.size());
        map.put("conlist",list);
        return "admin/consume.html";
    }
    //新增消费表单信息
    @PostMapping(value = "/admin/coninsert")
    public String userSelect(@RequestParam("name") String name,
                             @RequestParam("userid") int userid,
                             @RequestParam("money") int money,
                             Map<String, Object> map) {
        Consume consume = new Consume();
        consume.setConsume_name(name);
        consume.setConsume_user_id(userid);
        consume.setConsume_money(money);
        conService.insertAll(consume);
        map.put("msg", "添加成功");
        return "redirect:/admin/conselect";
    }
}
