package com.example.listtest.service;

import com.example.listtest.dao.PetDao;
import com.example.listtest.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PetService {
    @Autowired
    PetDao petDao;

    public List<Pet> getAll(){
        return petDao.getAll();
    }
    //新增宠物信息
    public void insertAll(Pet pet){
        petDao.insertAll(pet);
    }
    //根据id查询宠物信息
    public Pet getPetById(Integer id){
        return petDao.getPetById(id);
    }
    //修改宠物信息
    public void updatepet(Pet pet){
        petDao.updatepet(pet);
    }
    //删除宠物信息
    public void deletepet(Integer id){
        petDao.deletepet(id);
    }
}
