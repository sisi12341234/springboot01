package com.example.listtest.dao;

import com.example.listtest.model.Ser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ServiceDao {
    //查询所有信息
    List<Ser> getAll();
    //新增服务信息
    void insertAll(Ser service);
    //根据id查询服务信息
    Ser getServiceById(Integer id);
    //修改服务信息
    void updateservice(Ser service);
    //删除服务信息
    void deleteservice(Integer id);
}
