package com.example.listtest.service;

import com.example.listtest.dao.OrderDao;
import com.example.listtest.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;
    public List<Order> getAll(){
        return orderDao.getAll();
    }
    //查询
    public List<Order> getOrderName(){
        return orderDao.getOrderName();
    }
    //新增预约信息
    public void insertAll(Order order){
        orderDao.insertAll(order);
    }
    //根据id查询预约信息
    public Order getOrderById(Integer id){
        return orderDao.getOrderById(id);
    }
    public Order getOrNameById(Integer id){
        return orderDao.getOrNameById(id);
    }
    //修改预约信息
    public void updateorder(Order order){
        orderDao.updateorder(order);
    }
    /*//删除预约信息
    public void deleteorder(Integer id){
        orderDao.deleteorder(id);
    }*/
    //查询该用户的预约信息
    public List<Order> getByUser(Integer userid){
        return orderDao.getByUser(userid);
    }
}
