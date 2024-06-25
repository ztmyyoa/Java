package com.example.weblean4.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.weblean4.pojo.Book;
import com.example.weblean4.pojo.BookSqlProvider;
import com.example.weblean4.pojo.PromoBook;
import com.example.weblean4.pojo.promoBookSqlProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface proMapper extends BaseMapper<PromoBook> {
    @Select("SELECT * FROM promo_books WHERE bookID >=10000 ")
    List<PromoBook> selectAllPromoBook();
    @Select("SELECT * FROM promo_books WHERE bookID = #{id}")
    PromoBook selectByPromoId(@Param("id") int id);

    @Select("SELECT * FROM promo_books WHERE category = #{category}")
    List<PromoBook> selectBooksByCategory(@Param("category") String category);

    @SelectProvider(type = promoBookSqlProvider.class, method = "findBooksByNameOrAuthor")
    List<PromoBook> findPromoBooks(@Param("bookName") String bookName, @Param("author") String author);

}
