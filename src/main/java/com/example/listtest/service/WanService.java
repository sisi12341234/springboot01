package com.example.listtest.service;

import com.example.listtest.dao.WanDao;
import com.example.listtest.model.Wandering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WanService {
    @Autowired
    WanDao wanDao;
    public List<Wandering> getAll(){
        return wanDao.getAll();
    }
    //新增流浪宠物信息
    public void insertAll(Wandering wandering){
        wanDao.insertAll(wandering);
    }
    //根据id查询流浪宠物信息
    public Wandering getWanById(Integer id){
        return wanDao.getWanById(id);
    }
    //修改流浪宠物信息
    public void updatewan(Wandering wandering){
        wanDao.updatewan(wandering);
    }
    //删除流浪宠物信息
    public void deletewan(Integer id){
        wanDao.deletewan(id);
    }
}
