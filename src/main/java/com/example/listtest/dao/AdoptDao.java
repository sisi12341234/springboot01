package com.example.listtest.dao;

import com.example.listtest.model.Adopt;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdoptDao {
    //查询所有信息
    List<Adopt> getAll();
    //新增宠物领养信息
    void insertAll(Adopt adopt);
}
