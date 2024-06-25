package com.example.weblean4.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class userTool{
    private String username;
    private String nickname;
    private String gender;
    private String phoneNumber;
    private String shipAddress;
    private String email;

    // 其他字段和方法...

}
