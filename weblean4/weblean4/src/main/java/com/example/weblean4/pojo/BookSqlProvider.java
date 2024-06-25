package com.example.weblean4.pojo;

import org.apache.ibatis.jdbc.SQL;

public class BookSqlProvider {
    public String findBooksByNameOrAuthor(String bookName, String author) {
        return new SQL() {{
            SELECT("*");
            FROM("books");
            if (bookName != null && !bookName.isEmpty()) {
                WHERE("bookName LIKE CONCAT('%', #{bookName}, '%')");
            }
            if (author != null && !author.isEmpty()) {
                WHERE("author LIKE CONCAT('%', #{author}, '%')");
            }
        }}.toString();
    }
}
