package com.example.listtest.service;

import com.example.listtest.dao.ServiceDao;
import com.example.listtest.model.Ser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerService {
    @Autowired
    ServiceDao serviceDao;
    public List<Ser> getAll(){
        return serviceDao.getAll();
    }
    //新增宠物信息
    public void insertAll(Ser service){
        serviceDao.insertAll(service);
    }
    //根据id查询宠物信息
    public Ser getServiceById(Integer id){
        return serviceDao.getServiceById(id);
    }
    //修改宠物信息
    public void updateservice(Ser service){
        serviceDao.updateservice(service);
    }
    //删除宠物信息
    public void deleteservice(Integer id){
        serviceDao.deleteservice(id);
    }
}
