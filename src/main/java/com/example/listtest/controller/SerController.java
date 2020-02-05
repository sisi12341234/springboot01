package com.example.listtest.controller;

import com.example.listtest.model.Ser;
import com.example.listtest.service.SerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class SerController {
    @Autowired
    SerService serService;
    @GetMapping(value = "/admin/serselect")
    public String getAll(Map<String,Object> map){
        List<Ser> list = serService.getAll();
        map.put("serlist",list);
        return "admin/service.html";
    }
    //新增服务信息
    @PostMapping(value = "/admin/serinsert")
    public String serSelect(@RequestParam("name") String name,
                             @RequestParam("price") int price,
                             @RequestParam("introduce") String introduce,
                             Map<String, Object> map) {
        List<Ser> list = serService.getAll();
        for (Ser ser: list) {
            if(name.equals(ser.getService_name())){
                map.put("msg", "该服务已存在");
                return "admin/serselect.html";
            }
        }
        Ser ser = new Ser();
        ser.setService_name(name);
        ser.setService_price(price);
        ser.setService_introduction(introduce);
        serService.insertAll(ser);
        map.put("msg", "添加成功");
        return "redirect:/admin/serselect";
    }
    //获取需要修改的服务信息显示
    @GetMapping(value = "/serupdate/{id}")
    public String serupdate(@PathVariable("id") Integer serid, Map<String,Object> map){
        Ser ser = new Ser();
        ser = serService.getServiceById(serid);
        map.put("updateser",ser);
        return "admin/serupdate.html";
    }
    //更改服务的信息
    @PostMapping(value = "/admin/serupdate")
    public String serUpdate(@RequestParam("serid") Integer serid,
                            @RequestParam("name") String name,
                            @RequestParam("price") Integer price,
                            @RequestParam("introduce") String introduce,
                            Map<String,Object> map){
        Ser ser = new Ser();
        ser.setService_id(serid);
        ser.setService_name(name);
        ser.setService_price(price);
        ser.setService_introduction(introduce);
        serService.updateservice(ser);
        map.put("msg", "修改成功");
        return "redirect:/admin/serselect";
    }
    //删除服务的信息
    @GetMapping(value = "/serdelete/{id}")
    public String serdelete(@PathVariable("id") Integer serid, Map<String,Object> map){
        serService.deleteservice(serid);
        map.put("msg","删除成功");
        return "redirect:/admin/serselect";
    }
}
