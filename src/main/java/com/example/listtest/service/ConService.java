package com.example.listtest.service;

import com.example.listtest.dao.ConDao;
import com.example.listtest.model.Consume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConService {
    @Autowired
    ConDao conDao;
    public List<Consume> getAll(){
        return conDao.getAll();
    }
    //新增统计信息
    public void insertAll(Consume consume){
        conDao.insertAll(consume);
    }
    //根据id查询统计信息
    public Consume getConById(Integer id){
        return conDao.getConById(id);
    }
}
