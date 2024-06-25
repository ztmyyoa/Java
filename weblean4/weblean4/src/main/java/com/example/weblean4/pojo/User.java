package com.example.weblean4.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.sql.Timestamp;
import java.util.Arrays;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@TableName("user1") // 对应数据库中的表名
public class User {

    @TableField("user_id") // 对应数据库中的列名
    private int userId;

    @TableField("user_name") // 对应数据库中的列名
    private String userName;

    private String password;
    private String nickname;

    private Gender gender;

    @TableField("phone_number") // 对应数据库中的列名
    private String phoneNumber;

    @TableField("ship_address") // 对应数据库中的列名
    private String shipAddress;

    private String email;
    @TableField("age")
    private int age;
    @TableField("registration_date") // 对应数据库中的列名
    private Timestamp registrationDate;

    private byte[] avatar;

    public enum Gender {
        男, 女, 其它
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", shipAddress='" + shipAddress + '\'' +
                ", email='" + email + '\'' +
                ", registrationDate=" + registrationDate +
                ", avatar=" + Arrays.toString(avatar) +
                '}';
    }
}
