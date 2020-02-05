package com.example.listtest.dao;

import com.example.listtest.model.Wandering;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WanDao {
    //查询所有信息
    List<Wandering> getAll();
    //新增流浪宠物信息
    void insertAll(Wandering wandering);
    //根据id查询流浪宠物信息
    Wandering getWanById(Integer id);
    //修改流浪宠物信息
    void updatewan(Wandering wandering);
    //删除流浪宠物信息
    void deletewan(Integer id);
}
