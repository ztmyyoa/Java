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
@TableName("orders") // 对应数据库中的表名
public class Order {

    @TableId(value = "OrderID", type = IdType.AUTO) // 主键策略为自增
    private int orderID;

    @TableField("UserAccount") // 对应数据库中的列名
    private String userAccount;

    @TableField("BookID") // 对应数据库中的列名
    private int bookID;

    @TableField("Quantity") // 对应数据库中的列名
    private int quantity;

    @TableField("ShippingAddress") // 对应数据库中的列名
    private String shippingAddress;

    @TableField("ContactInfo") // 对应数据库中的列名
    private String contactInfo;

    @TableField("OrderAmount") // 对应数据库中的列名
    private BigDecimal orderAmount;

    @TableField("OrderStatus") // 对应数据库中的列名
    private OrderStatus orderStatus;

    @TableField("OrderTime") // 对应数据库中的列名
    private Timestamp orderTime;

    // 枚举类 OrderStatus 定义在 Order 类内部
    public enum OrderStatus {
        已发货, 未发货
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", userAccount='" + userAccount + '\'' +
                ", bookID=" + bookID +
                ", quantity=" + quantity +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", orderAmount=" + orderAmount +
                ", orderStatus=" + orderStatus +
                ", orderTime=" + orderTime +
                '}';
    }
}
