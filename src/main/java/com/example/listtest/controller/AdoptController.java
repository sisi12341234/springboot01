package com.example.listtest.controller;

import com.example.listtest.model.Adopt;
import com.example.listtest.service.AdoptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class AdoptController {
    @Autowired
    AdoptService adoptService;

    @GetMapping(value = "/admin/adoptselect")
    public String getAll(Map<String,Object> map){
        List<Adopt> list = adoptService.getAll();
        map.put("adoptlist",list);
        return "admin/adopt.html";
    }
}
