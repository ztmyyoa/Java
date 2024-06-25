package com.example.weblean4.service;


import com.example.weblean4.pojo.CategoryCount;
import com.example.weblean4.pojo.Order;

import java.util.List;

public interface OrderService {

    List<Order> list();

    void update(Order order);

    public List<Order> listByUserName(String userName) ;

    void delete(Integer orderId);

    List<CategoryCount> getClassifyOrderList();

    Order query1(Integer orderId, Integer bookId);

    List<CategoryCount> getPromotionClassifyOrderList();

    List<Order> query(Integer orderId);

    List<CategoryCount> getStatusList();

    List<CategoryCount> getDataList();
}
