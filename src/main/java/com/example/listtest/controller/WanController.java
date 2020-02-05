package com.example.listtest.controller;

import com.example.listtest.model.Order;
import com.example.listtest.model.Wandering;
import com.example.listtest.service.WanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class WanController {
    @Autowired
    WanService wanService;
    @GetMapping(value = "/admin/wanselect")
    public String getAll(Map<String,Object> map){
        List<Wandering> list = wanService.getAll();
        map.put("wanlist",list);
        return "admin/wandering.html";
    }
    //新增流浪宠物信息
    @PostMapping(value = "/admin/waninsert")
    public String wanSelect(@RequestParam("type") String type,
                            @RequestParam("picture") MultipartFile picture,
                            @RequestParam("health") String health,
                            Map<String, Object> map) {
        String pic = picture.getOriginalFilename();
        pic = "picture/wander/" + pic;
        System.out.println(pic);
        String path = "D:/spring-test/listtest/src/main/resources/static/admin/picture/wander";
        File dest = new File(path,picture.getOriginalFilename());
        try {
            picture.transferTo(dest);
        } catch (IOException e) {
            System.out.println(e);
        }
        Wandering wandering = new Wandering();
        wandering.setWandering_type(type);
        wandering.setWandering_picture(pic);
        Date d = new Date();
        wandering.setWandering_date(d);
        wandering.setWandering_health(health);
        wandering.setWandering_sign(true);
        wanService.insertAll(wandering);
        map.put("msg", "添加成功");
        return "redirect:/admin/wanselect";
    }
    //获取需要修改的流浪宠物信息显示
    @GetMapping(value = "/wanupdate/{id}")
    public String wanupdate(@PathVariable("id") Integer wanid, Map<String,Object> map){
        Wandering wandering = new Wandering();
        wandering = wanService.getWanById(wanid);
        map.put("updatewan",wandering);
        return "admin/wanupdate.html";
    }
    //更改流浪宠物的信息
    @PostMapping(value = "/admin/wanupdate")
    public String petUpdate(@RequestParam("wanid") Integer wanid,
                            @RequestParam("type") String type,
                            @RequestParam("picture") String picture,
                            @RequestParam("health") String health,
                            @RequestParam("sign") String sign,
                            Map<String,Object> map){
        Wandering wandering = new Wandering();
        wandering.setWandering_id(wanid);
        wandering.setWandering_type(type);
        wandering.setWandering_picture(picture);
        Date d = new Date();
        wandering.setWandering_date(d);
        wandering.setWandering_health(health);
        if(sign.equals("是")){
            wandering.setWandering_sign(true);
        }
        else {
            wandering.setWandering_sign(false);
        }
        wanService.updatewan(wandering);
        map.put("msg", "修改成功");
        return "redirect:/admin/wanselect";
    }
    //删除流浪宠物的信息
    @GetMapping(value = "/wandelete/{id}")
    public String wandelete(@PathVariable("id") Integer wanid, Map<String,Object> map){
        wanService.deletewan(wanid);
        map.put("msg","删除成功");
        return "redirect:/admin/wanselect";
    }
}
