package com.example.weblean4.controller;

import com.example.weblean4.mapper.bookMapper;
import com.example.weblean4.pojo.Book;
import com.example.weblean4.pojo.CategoryCount;
import com.example.weblean4.pojo.Result;
import com.example.weblean4.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Book")  // 设置统一的请求路径前缀
public class bookController {

    @Autowired
    private bookMapper bookMapper;

    // 新增的 API 端点，用于获取 bookID 大于 10000 的书籍编号和 URL 地址
    @GetMapping("/highIdBooks")
    public List<Book> getHighIdBooks() {
        return bookMapper.selectBookIdsAndUrls();
    }
    // 新增的 API 端点，用于获取 bookID 大于 10000 的书籍编号和 URL 地址
    @GetMapping("/highIdBook")
    public String getHighIdBook() {
        return "Ok";
    }

    @GetMapping("/getUnique/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookMapper.selectById(id);
    }

    @GetMapping("/getAllBook")
    public List<Book> getAll(){
        return bookMapper.selectAllBook();
    }

    @GetMapping("/category/{category}")
    public List<Book> getBooksByCategory(@PathVariable String category) {
        return bookMapper.selectBooksByCategory(category);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(
            @RequestParam(value = "bookName", required = false) String bookName,
            @RequestParam(value = "author", required = false) String author) {

        if (bookName == null && author == null) {
            return ResponseEntity.badRequest().body(null);
        }

        List<Book> books = bookMapper.findBooks(bookName, author);
        return ResponseEntity.ok(books);
    }

//    管理员
@Autowired
private BookService bookService;

    @GetMapping
    public Result list(){
        log.info("查询所有书籍");
        List<Book> list = bookService.list();
        return Result.success(list);
    }

    @PostMapping("/add")
    public Result addBook(@RequestBody Book book){
        log.info("增加书籍：{}",book);
        bookService.add(book);
        return Result.success();
    }

    @GetMapping("/{message}")
    public Result query(@PathVariable String message){
        log.info("根据id或书名查询书名：{}", message);
        if (message == null || message.isEmpty()) {
            return Result.error("message为空");
        }
        List<Book> books = bookService.query(message);
        return Result.success(books);
    }

    @PutMapping
    public Result update(@RequestBody Book book){
        log.info("根据id修改书籍：{}",book);
        bookService.update(book);
        return Result.success();
    }

    @DeleteMapping("/manager/{bookId}")
    public Result delete(@PathVariable Integer bookId){
        log.info("根据id删除书籍：{}",bookId);
        bookService.delete(bookId);
        return Result.success();
    }

    @GetMapping("/getPromotionList")
    public Result getPromotionList(){
        log.info("查询促销书籍");
        List<Book> list = bookService.getPromotionlist();
        return Result.success(list);
    }

    @GetMapping("/classify")
    public Result classifyList(){
        log.info("查询统计所有书籍数量");
        List<CategoryCount> classifyList = bookService.getClassifyList();
        return Result.success(classifyList);
    }

    @GetMapping("/classifyBook")
    public Result bookClassifyList(){
        log.info("查询统计种类原价书籍数量");
        List<CategoryCount> promotionClassifyList = bookService.getBookClassifyList();
        return Result.success(promotionClassifyList);
    }

    @GetMapping("/classifyCommon")
    public Result promotionBookClassifyList(){
        log.info("查询统计种类原价书籍数量");
        List<CategoryCount> promotionClassifyList = bookService.getCommonBookClassifyList();
        return Result.success(promotionClassifyList);
    }
}
