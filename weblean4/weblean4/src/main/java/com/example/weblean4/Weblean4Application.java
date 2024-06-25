package com.example.weblean4;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.weblean4.mapper")
public class Weblean4Application {

    public static void main(String[] args) {
        SpringApplication.run(Weblean4Application.class, args);
    }

}
