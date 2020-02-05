package com.example.listtest.dao;

import com.example.listtest.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserDao {
    //查询所有人员信息
    List<User> getAll();
    //新增人员信息
    void insertAll(User user);
    //修改管理员信息
    void updateAdmin(User user);
    //查询人员信息（不包括管理员）
    List<User> getUser();
    //根据id查询人员信息
    User getUserById(Integer id);
    //修改人员信息
    void updateuser(User user);
    //删除人员信息
    void deleteuser(Integer id);
}
