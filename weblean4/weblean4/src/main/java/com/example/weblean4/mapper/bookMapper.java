package com.example.weblean4.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.weblean4.pojo.Book;
import com.example.weblean4.pojo.BookSqlProvider;
import com.example.weblean4.pojo.CategoryCount;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.apache.ibatis.annotations.Mapper;


import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface bookMapper extends BaseMapper<Book> {
    @Select("SELECT * FROM books WHERE bookID > 10000 and bookID<=10008")
    List<Book> selectBookIdsAndUrls();

    @Select("SELECT * FROM books WHERE bookID >=10000 ")
    List<Book> selectAllBook();

    @Select("SELECT * FROM books WHERE bookID = #{id}")
    Book selectById(@Param("id") int id);

    @Select("SELECT * FROM books WHERE category = #{category}")
    List<Book> selectBooksByCategory(@Param("category") String category);

    @SelectProvider(type = BookSqlProvider.class, method = "findBooksByNameOrAuthor")
    List<Book> findBooks(@Param("bookName") String bookName, @Param("author") String author);


//    管理系统
@Select("select * from books")
List<Book> list();

    @Insert("insert into books (bookID, bookName, author, ISBN, category, publisher, price, stock, imageUrl, description, promoPrice) " +
            "value (#{bookId},#{bookName},#{author},#{isbn},#{category},#{publisher},#{price},#{stock},#{imageUrl},#{description},#{promoPrice})")
    void add(Book book);

    @Update("update books set bookName=#{bookName},author=#{author},ISBN=#{isbn},category=#{category},publisher=#{publisher}," +
            "price=#{price},stock=#{stock},imageUrl=#{imageUrl},description=#{description},promoPrice=#{promoPrice} where bookID=#{bookId}")
    void update(Book book);

    @Delete("delete from books where bookID=#{bookId}")
    void delete(Integer bookId);


    @Select("select category,sum(stock) as count from books group by category")
    List<CategoryCount> getClassifyList();

    @Select("SELECT * FROM books WHERE bookID = #{id}")
    List<Book> selectBy1Id(int id);

    @Select("SELECT * FROM books WHERE bookName LIKE #{bookName}")
    List<Book> selectByName(String bookName);

    @Select("select category,count(*) as count from books group by category")
    List<CategoryCount> getBookClassifyList();

    @Select("select category,count(*) as count from books where promoPrice =0 group by category")
    List<CategoryCount> getCommonBookClassifyList();


    @Select("select * from books where promoPrice != 0")
    List<Book> getPromotionList();

}
