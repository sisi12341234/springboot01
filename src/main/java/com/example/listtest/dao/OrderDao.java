package com.example.listtest.dao;

import com.example.listtest.model.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {
    //查询所有信息
    List<Order> getAll();
    //查询
    List<Order> getOrderName();
    //新增预约信息
    void insertAll(Order order);
    //根据id查询预约信息
    Order getOrderById(Integer id);
    Order getOrNameById(Integer id);
    //修改预约信息
    void updateorder(Order order);
    //删除预约信息
    void deleteorder(Integer id);
    //查询改用户的预约信息
    List<Order> getByUser(Integer userid);
}
