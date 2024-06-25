package com.example.weblean4;

import com.example.weblean4.mapper.UserMapper;
import com.example.weblean4.mapper.bookMapper;
import com.example.weblean4.mapper.orderMapper;
import com.example.weblean4.mapper.trolleyMapper;
import com.example.weblean4.pojo.Book;
import com.example.weblean4.pojo.Order;
import com.example.weblean4.pojo.Trolley;
import com.example.weblean4.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Weblean4ApplicationTests {
    @Autowired
   private bookMapper  bookMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private trolleyMapper trolleyMapper;
    @Autowired
    private orderMapper orderMapper;


    @Test
    public void getAllBooks() {
        List<Book> books = bookMapper.selectList(null);
        books.forEach(System.out::println);
    }


    @Test
    public void getAllUsers() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void getAllOrders() {
        List<Order> orders = orderMapper.selectList(null);
        orders.forEach(System.out::println);
    }

    @Test
    public void getAllTrolleys() {
        List<Trolley> trolleys = trolleyMapper.selectList(null);
        trolleys.forEach(System.out::println);
    }
    @Test
    public void getAllImageUrl() {
        Book book = bookMapper.selectById(10001);
        System.out.println(book);
    }

}
