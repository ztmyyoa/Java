package com.example.weblean4.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("trolley") // 对应数据库中的表名
public class Trolley {

    @TableId(value = "CartID", type = IdType.AUTO) // 主键策略为自增，并指定对应数据库字段名
    private int cartID;

    @TableField("UserAccount") // 对应数据库中的列名
    private String userAccount;

    @TableField("BookID") // 对应数据库中的列名
    private int bookID;

    @TableField("Quantity") // 对应数据库中的列名
    private int quantity;

    @TableField("Amount") // 对应数据库中的列名
    private BigDecimal amount;

    @TableField(value = "CreateTime", fill = FieldFill.INSERT) // 对应数据库中的列名，并设置自动填充
    private Timestamp createTime;

    @TableField("imageUrl") // 对应数据库中的列名
    private String imageUrl;
    @TableField("currentBook") // 对应数据库中的列名
    private int currentBook;

    @Override
    public String toString() {
        return "Trolley{" +
                "cartID=" + cartID +
                ", userAccount='" + userAccount + '\'' +
                ", bookID=" + bookID +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", createTime=" + createTime +
                '}';
    }
}
