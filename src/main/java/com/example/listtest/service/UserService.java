package com.example.listtest.service;

import com.example.listtest.dao.UserDao;
import com.example.listtest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    UserDao userDao;
    //查询
    public List<User> getAll(){
        return userDao.getAll();
    }
    //新增用户
    public void insertAll(User user){
        userDao.insertAll(user);
    }
    //修改管理员
    public void updateAdmin(User user){ userDao.updateAdmin(user);}
    //查询用户（不包括管理员）
    public List<User> getUser(){
        return userDao.getUser();
    }
    //根据id查询用户
    public User getUserById(Integer id){
        return userDao.getUserById(id);
    }
    //修改用户信息
    public void updateuser(User user){
        userDao.updateuser(user);
    }
    //删除用户信息
    public void deleteuser(Integer id){
        userDao.deleteuser(id);
    }
}
