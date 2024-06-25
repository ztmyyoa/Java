package com.example.weblean4.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@Data
public  class TrolleyRequest {
    private String userAccount;
    private String bookID;
    private String price;
    private String quantity;
    private String amount;
    private String imageUrl;
    private String currentBook;
}