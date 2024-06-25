package com.example.weblean4.service.impl;


import com.example.weblean4.mapper.orderMapper;
import com.example.weblean4.pojo.CategoryCount;
import com.example.weblean4.pojo.Order;
import com.example.weblean4.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private orderMapper orderMapper

            ;

    @Override
    public List<Order> list() {
        return orderMapper.list();
    }

    @Override
    public void update(Order order) {
        orderMapper.update(order);
    }

    @Override
    public void delete(Integer orderId) {
        orderMapper.delete(orderId);
    }

    @Override
    public Order query1(Integer orderId, Integer bookId) {
        return orderMapper.query1(orderId, bookId);
    }
    public List<Order> listByUserName(String userName) {
        return orderMapper.listByUserName(userName);
    }
    @Override
    public List<CategoryCount> getClassifyOrderList() {
        return orderMapper.getClassifyOrderList();
    }

    @Override
    public List<CategoryCount> getPromotionClassifyOrderList() {
        return orderMapper.getPromotionClassifyOrderList();
    }

    @Override
    public List<Order> query(Integer orderId) {
        return orderMapper.query(orderId);
    }

    @Override
    public List<CategoryCount> getStatusList() {
        return orderMapper.getStatusList();
    }

    @Override
    public List<CategoryCount> getDataList() {
        return orderMapper.getDataList();
    }


}
