package com.example.weblean4.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class TrolleyDto {
    private String userAccount;
    private int bookID;
    private String imageUrl;
    private BigDecimal price;
    private int quantity;
    private BigDecimal amount;
    private int currentBook;
}