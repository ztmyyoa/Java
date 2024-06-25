package com.example.weblean4.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("books") // 对应数据库中的表名
public class Book {

    @TableField("bookID") // 对应数据库中的列名
    private int bookID;

    @TableField("bookName") // 对应数据库中的列名
    private String bookName;

    @TableField("author") // 对应数据库中的列名
    private String author;

    @TableField("ISBN") // 对应数据库中的列名
    private String ISBN;

    @TableField("category") // 对应数据库中的列名
    private String category;

    @TableField("publisher") // 对应数据库中的列名
    private String publisher;

    @TableField("price") // 对应数据库中的列名
    private BigDecimal price;

    @TableField("stock") // 对应数据库中的列名
    private int stock;

    @TableField("imageUrl") // 对应数据库中的列名
    private String imageUrl;

    @TableField("description") // 对应数据库中的列名
    private String description;

    @TableField("promoPrice") // 对应数据库中的列名
    private BigDecimal promoPrice;

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", category='" + category + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", promoPrice=" + promoPrice +
                '}';
    }
}
