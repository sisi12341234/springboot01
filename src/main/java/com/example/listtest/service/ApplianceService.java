package com.example.listtest.service;

import com.example.listtest.dao.ApplianceDao;
import com.example.listtest.model.Appliance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplianceService {
    @Autowired
    ApplianceDao applianceDao;
    public List<Appliance> getAll(){
        return applianceDao.getAll();
    }
    //新增商品信息
    public void insertAll(Appliance appliance){
        applianceDao.insertAll(appliance);
    }
    //根据id查询商品信息
    public Appliance getApplianceById(Integer id){
        return applianceDao.getApplianceById(id);
    }
    //修改商品信息
    public void updateappliance(Appliance appliance){
        applianceDao.updateappliance(appliance);
    }
    //删除商品信息
    public void deleteappliance(Integer id){
        applianceDao.deleteappliance(id);
    }
}
