package com.example.weblean4.service;




import com.example.weblean4.pojo.Book;
import com.example.weblean4.pojo.CategoryCount;

import java.util.List;

public interface BookService {
    List<Book> list();
    void add(Book book);
    void update(Book book);

    void delete(Integer bookId);


    List<CategoryCount> getClassifyList();



    List<Book> query(String message);

    List<CategoryCount> getCommonBookClassifyList();

    List<CategoryCount> getBookClassifyList();

    List<Book> getPromotionlist();
}
