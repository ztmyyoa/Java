package com.example.weblean4.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.weblean4.pojo.CategoryCount;
import com.example.weblean4.pojo.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface orderMapper extends BaseMapper<Order> {
    @Select("select * from orders")
    List<Order> list();


    @Update("update orders set UserAccount=#{userAccount},BookID=#{bookId},Quantity=#{quantity},ShippingAddress=#{shippingAddress}" +
            ",ContactInfo=#{contactInfo},OrderAmount=#{orderAmount},OrderStatus=#{orderStatus},OrderTime=#{orderTime} where OrderID=#{orderId}")
    void update(Order order);

    @Delete("delete from orders where OrderID=#{orderId}")
    void delete(Integer orderId);

    @Select("select book.category, sum(orders.Quantity) as count " +
            "from books book " +
            "inner join orders orders on book.bookID = orders.BookID " +
            "group by book.category")
    List<CategoryCount> getClassifyOrderList();

    @Select("select * from orders where UserAccount=#{userName}")
    List<Order> listByUserName(String userName);

    @Select("select * from orders where OrderID=#{orderId} and BookID=#{bookId}")
    Order query1(@Param("orderId") Integer orderId, @Param("bookId") Integer bookId);
    @Select("select book.category, sum(Quantity) as count " +
            "from books book " +
            "inner join orders orders on book.bookID = orders.BookID " +
            "where book.promoPrice != 0 " +
            "group by category")
    List<CategoryCount> getPromotionClassifyOrderList();

    @Select("select * from orders where OrderID=#{orderId}")
    List<Order> query(Integer orderId);

    @Select("select OrderStatus as category,count(*) as count from orders group by OrderStatus")
    List<CategoryCount> getStatusList();

    @Select("SELECT " +
            "  CASE " +
            "    WHEN QUARTER(OrderTime) = 1 THEN 'Q1' " +
            "    WHEN QUARTER(OrderTime) = 2 THEN 'Q2' " +
            "    WHEN QUARTER(OrderTime) = 3 THEN 'Q3' " +
            "    WHEN QUARTER(OrderTime) = 4 THEN 'Q4' " +
            "  END AS category, " +
            "  COUNT(*) AS count " +
            "FROM orders " +
            "WHERE OrderStatus != '已取消' " +
            "GROUP BY category")
    List<CategoryCount> getDataList();
}
