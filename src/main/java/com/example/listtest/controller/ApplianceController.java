package com.example.listtest.controller;

import com.example.listtest.model.Appliance;
import com.example.listtest.service.ApplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class ApplianceController {
    @Autowired
    ApplianceService applianceService;
    @GetMapping(value = "/admin/appselect")
    public String getAll(Map<String,Object> map){
        List<Appliance> list = applianceService.getAll();
        map.put("appliancelist",list);
        return "admin/appliance.html";
    }
    //新增商品信息
    @PostMapping(value = "/admin/appinsert")
    public String applianceSelect(@RequestParam("name") String name,
                             @RequestParam("picture") String picture,
                             @RequestParam("price") int price,
                             @RequestParam("company") String company,
                             @RequestParam("quantity") int quantity,
                                  @RequestParam("amount") int amount,
                             Map<String, Object> map) {
        Appliance appliance = new Appliance();
        appliance.setAppliance_name(name);
        appliance.setAppliance_picture(picture);
        appliance.setAppliance_price(price);
        appliance.setAppliance_company(company);
        appliance.setAppliance_quantity(quantity);
        appliance.setAppliance_amount(amount);
        applianceService.insertAll(appliance);
        map.put("msg", "添加成功");
        return "redirect:/admin/appselect";
    }
    //获取需要修改的商品信息显示
    @GetMapping(value = "/appupdate/{id}")
    public String applianceupdate(@PathVariable("id") Integer applianceid, Map<String,Object> map){
        Appliance appliance = new Appliance();
        appliance = applianceService.getApplianceById(applianceid);
        map.put("updateapp",appliance);
        return "admin/appupdate.html";
    }
    //更改商品的信息
    @PostMapping(value = "/admin/appupdate")
    public String applianceUpdate(@RequestParam("appid") int appid,
                                  @RequestParam("name") String name,
                                  @RequestParam("picture") String picture,
                                  @RequestParam("price") int price,
                                  @RequestParam("company") String company,
                                  @RequestParam("quantity") int quantity,
                                  @RequestParam("amount") int amount,
                                  Map<String,Object> map){
        System.out.println(appid);
        Appliance appliance = new Appliance();
        appliance.setAppliance_id(appid);
        appliance.setAppliance_name(name);
        appliance.setAppliance_picture(picture);
        appliance.setAppliance_price(price);
        appliance.setAppliance_company(company);
        appliance.setAppliance_quantity(quantity);
        appliance.setAppliance_amount(amount);
        applianceService.updateappliance(appliance);
        map.put("msg", "修改成功");
        return "redirect:/admin/appselect";
    }
    //删除商品的信息
    @GetMapping(value = "/appdelete/{id}")
    public String appliancedelete(@PathVariable("id") Integer appid, Map<String,Object> map){
        applianceService.deleteappliance(appid);
        map.put("msg","删除成功");
        return "redirect:/admin/appselect";
    }
}
