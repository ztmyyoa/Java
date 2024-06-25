package com.example.weblean4.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.weblean4.pojo.Trolley;
import com.example.weblean4.pojo.TrolleyDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

public interface trolleyMapper extends BaseMapper<Trolley> {
    @Select("SELECT COUNT(*) FROM (SELECT bookID FROM books WHERE bookID = #{bookID} UNION SELECT bookID FROM promo_books WHERE bookID = #{bookID}) AS combined")
    int bookExists(@Param("bookID") int bookID);
    @Insert("INSERT INTO trolley (UserAccount, BookID, price, Quantity, Amount,imageUrl,currentBook) VALUES (#{userAccount}, #{bookID}, #{price}, #{quantity}, #{amount},#{imageUrl},#{currentBook})")
    int insertTrolley(@Param("userAccount") String userAccount,
                      @Param("bookID") int bookID,
                      @Param("price") BigDecimal bookPrice,
                      @Param("quantity") int quantity,
                      @Param("amount") BigDecimal amount,
                      @Param("imageUrl") String imageUrl,
                      @Param("currentBook") int currentBook);




    @Select("SELECT t.UserAccount, t.BookID, t.imageUrl, t.price AS price, t.Quantity, t.Amount " +
            "FROM trolley t " +
            "WHERE t.UserAccount = #{userAccount} AND t.currentBook = 2")
    List<TrolleyDto> getTrolleyByUserAccount(@Param("userAccount") String userAccount);

    @Select("SELECT t.UserAccount, t.BookID, t.imageUrl, t.price AS price, t.Quantity, t.Amount, t.CreateTime " +
            "FROM trolley t " +
            "WHERE t.UserAccount = #{userAccount} AND t.currentBook = 1 " +
            "ORDER BY t.CreateTime DESC " +
            "LIMIT 1")
    List<TrolleyDto> getTrolleyByUserAccountOne(@Param("userAccount") String userAccount);


    @Select("SELECT t.UserAccount, t.BookID, b.imageUrl AS imageUrl, t.price AS price, t.Quantity, t.Amount " +
            "FROM trolley t " +
            "INNER JOIN promo_books b ON t.BookID = b.bookID " +
            "WHERE t.UserAccount = #{userAccount}")
    List<TrolleyDto> getTrolleyPromoteByUserAccount(@Param("userAccount") String userAccount);

    @Delete("DELETE FROM trolley WHERE UserAccount = #{userAccount} AND BookID = #{bookID}")
    int deleteTrolley(@Param("userAccount") String userAccount, @Param("bookID") int bookID);
}
