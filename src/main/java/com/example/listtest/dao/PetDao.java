package com.example.listtest.dao;

import com.example.listtest.model.Pet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PetDao {
    //查询所有信息
    List<Pet> getAll();
    //新增宠物信息
    void insertAll(Pet pet);
    //根据id查询宠物信息
    Pet getPetById(Integer id);
    //修改宠物信息
    void updatepet(Pet pet);
    //删除宠物信息
    void deletepet(Integer id);
}
