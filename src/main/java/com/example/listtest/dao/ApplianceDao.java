package com.example.listtest.dao;

import com.example.listtest.model.Appliance;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplianceDao {
    //查询所有信息
    List<Appliance> getAll();
    //新增商品信息
    void insertAll(Appliance appliance);
    //根据id查询商品信息
    Appliance getApplianceById(Integer id);
    //修改商品信息
    void updateappliance(Appliance appliance);
    //删除商品信息
    void deleteappliance(Integer id);
}
