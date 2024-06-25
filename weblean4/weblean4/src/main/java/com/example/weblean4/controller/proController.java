package com.example.weblean4.controller;

import com.example.weblean4.mapper.proMapper;
import com.example.weblean4.pojo.Book;
import com.example.weblean4.pojo.PromoBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Book/Promo")  // 设置统一的请求路径前缀
public class proController {
    @Autowired
    private proMapper proMapper;
    @GetMapping("/{id}")
    public PromoBook getBookById(@PathVariable int id) {
        return proMapper.selectByPromoId(id);
    }

    @GetMapping("/getAllPromoBook")
    public List<PromoBook> getAll() {
        return proMapper.selectAllPromoBook();
    }

    @GetMapping("/category/{category}")
    public List<PromoBook> getBooksByCategory(@PathVariable String category) {
        return proMapper.selectBooksByCategory(category);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PromoBook>> searchBooks(
            @RequestParam(value = "bookName", required = false) String bookName,
            @RequestParam(value = "author", required = false) String author) {

        if (bookName == null && author == null) {
            return ResponseEntity.badRequest().body(null);
        }

        List<PromoBook> books = proMapper.findPromoBooks(bookName, author);
        return ResponseEntity.ok(books);
    }
}
