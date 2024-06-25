package com.example.weblean4.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("admins") // 对应数据库中的表名
public class Admin {

    @TableId(value = "AdminID",type = IdType.AUTO) // 对应数据库中的列名，并指定为主键
    private int adminID;

    @TableField("AdminName") // 对应数据库中的列名
    private String adminName;

    @TableField("Password") // 对应数据库中的列名
    private String password;

    @TableField("Nickname") // 对应数据库中的列名
    private String nickname;

    @TableField("ContactInfo") // 对应数据库中的列名
    private String contactInfo;

    @Override
    public String toString() {
        return "Admin{" +
                "adminID=" + adminID +
                ", adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                '}';
    }
}
