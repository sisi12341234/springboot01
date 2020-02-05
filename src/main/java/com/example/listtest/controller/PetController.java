package com.example.listtest.controller;

import com.example.listtest.model.Pet;
import com.example.listtest.model.User;
import com.example.listtest.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class PetController {
    @Autowired
    PetService petService;

    @GetMapping(value = "/admin/petselect")
    public String getAll(Map<String,Object> map){
        List<Pet> list = petService.getAll();
        map.put("petmessage",list);
        return "admin/pet.html";
    }
    //新增宠物信息
    @PostMapping(value = "/admin/petinsert")
    public String userSelect(@RequestParam("type") String type,
                             @RequestParam("age") int age,
                             @RequestParam("picture") MultipartFile picture,
                             @RequestParam("introduce") String introduce,
                             @RequestParam("price") int price,
                             Map<String, Object> map) {
        List<Pet> list = petService.getAll();
        for (Pet pet: list) {
            if(type.equals(pet.getPet_type())){
                map.put("msg", "该宠物已存在");
                return "admin/petselect.html";
            }
        }
        String pic = picture.getOriginalFilename();
        pic = "picture/pet/" + pic;
        System.out.println(pic);
        String path = "D:/spring-test/listtest/src/main/resources/static/admin/picture/pet";
        File dest = new File(path,picture.getOriginalFilename());
        try {
            picture.transferTo(dest);
        } catch (IOException e) {
            System.out.println(e);
        }
        Pet pet = new Pet();
        pet.setPet_type(type);
        pet.setPet_age(age);
        pet.setPet_picture(pic);
        pet.setPet_introduction(introduce);
        pet.setPet_price(price);
        petService.insertAll(pet);
        map.put("msg", "添加成功");
        return "redirect:/admin/petselect";
    }
    //获取需要修改的宠物信息显示
    @GetMapping(value = "/petupdate/{id}")
    public String petupdate(@PathVariable("id") Integer petid, Map<String,Object> map){
        Pet pet = new Pet();
        pet = petService.getPetById(petid);
        map.put("updatepet",pet);
        return "admin/petupdate.html";
    }
    //更改宠物的信息
    @PostMapping(value = "/admin/petupdate")
    public String petUpdate(@RequestParam("petid") Integer petid,
                             @RequestParam("type") String type,
                             @RequestParam("age") Integer age,
                             @RequestParam("picture") String picture,
                             @RequestParam("introduce") String introduce,
                             @RequestParam("price") Integer price,
                             Map<String,Object> map){
        System.out.println(petid);
        Pet pet = new Pet();
        pet.setPet_id(petid);
        pet.setPet_type(type);
        pet.setPet_age(age);
        pet.setPet_picture(picture);
        pet.setPet_introduction(introduce);
        pet.setPet_price(price);
        petService.updatepet(pet);
        map.put("msg", "修改成功");
        return "redirect:/admin/petselect";
    }
    //删除宠物的信息
    @GetMapping(value = "/petdelete/{id}")
    public String petdelete(@PathVariable("id") Integer petid, Map<String,Object> map){
        petService.deletepet(petid);
        map.put("msg","删除成功");
        return "redirect:/admin/petselect";
    }
}
