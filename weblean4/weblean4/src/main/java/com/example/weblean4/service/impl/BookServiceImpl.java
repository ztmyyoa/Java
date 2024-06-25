package com.example.weblean4.service.impl;


import com.example.weblean4.mapper.bookMapper;
import com.example.weblean4.pojo.Book;
import com.example.weblean4.pojo.CategoryCount;
import com.example.weblean4.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private bookMapper bookMapper;

    @Override
    public List<Book> list() {
        return bookMapper.list();
    }

    @Override
    public void add(Book book) {
        bookMapper.add(book);
    }

    @Override
    public void update(Book book) {
        bookMapper.update(book);
    }

    @Override
    public void delete(Integer bookId) {
        bookMapper.delete(bookId);
    }


    @Override
    public List<CategoryCount> getClassifyList() {
        return bookMapper.getClassifyList();
    }


    @Override
    public List<Book> query(String message) {
        if (message.matches("\\d+")) {
            return bookMapper.selectBy1Id(Integer.parseInt(message));
        } else {
            return bookMapper.selectByName(message);
        }
    }

    @Override
    public List<CategoryCount> getCommonBookClassifyList() {
        return bookMapper.getCommonBookClassifyList();
    }

    @Override
    public List<CategoryCount> getBookClassifyList() {
        return bookMapper.getBookClassifyList();
    }

    @Override
    public List<Book> getPromotionlist() {
        return bookMapper.getPromotionList();
    }


}
