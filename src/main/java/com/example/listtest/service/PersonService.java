package com.example.listtest.service;

import com.example.listtest.dao.PersonDao;
import com.example.listtest.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonDao personDao;

    /*
        Service层介于controller和dao之间作为服务层进行一些逻辑处理，
        这里逻辑太简单所以知识单纯调用dao所以不做注释
     */
    public List<Person> getAll(){
        return personDao.getAll();
    }

    public Person getPersonByID(int id){
        return personDao.getPersonByID(id);
    }

    public void  delete(int id){
        personDao.delete(id);
    }

    public void update(Person p){
        personDao.update(p);
    }

    public void newp(Person p){
        personDao.newp(p);
    }
}