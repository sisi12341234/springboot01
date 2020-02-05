package com.example.listtest.service;

import com.example.listtest.dao.AdoptDao;
import com.example.listtest.model.Adopt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdoptService {
    @Autowired
    AdoptDao adoptDao;
    public List<Adopt> getAll(){
        return adoptDao.getAll();
    }
    public void insertAll(Adopt adopt){
        adoptDao.insertAll(adopt);
    }
}
