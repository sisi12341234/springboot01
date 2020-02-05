package com.example.listtest.dao;

import com.example.listtest.model.Consume;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConDao {
    //查询所有信息
    List<Consume> getAll();
    //新增统计表信息
    void insertAll(Consume consume);
    //根据id查询统计信息
    Consume getConById(Integer id);
    //修改统计信息
    void updatecon(Consume consume);
    //删除统计信息
    void deletecon(Integer id);
}
