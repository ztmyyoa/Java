package com.example.weblean4.controller;

import com.example.weblean4.pojo.CategoryCount;
import com.example.weblean4.pojo.Order;
import com.example.weblean4.pojo.Result;
import com.example.weblean4.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Book")  // 设置统一的请求路径前缀
public class orderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getSelfOrder/{orderId}/{bookId}")
    public Result query(@PathVariable Integer orderId, @PathVariable Integer bookId) {
        log.info("根据orderId和bookId查询订单：{} {}", orderId, bookId);
        if (orderId == null || bookId == null) {
            return Result.error("订单ID或书籍ID为空");
        }
        Order order = orderService.query1(orderId, bookId);
        if (order != null) {
            return Result.success(order);
        } else {
            return Result.error("未找到订单");
        }
    }
    @GetMapping("/user/{userName}")
    public Result listByUserName(@PathVariable String userName){
        log.info("根据userName获取订单：{}", userName);
        if(userName == null || userName.isEmpty()){
            return Result.error("用户名为空");
        }
        List<Order> orders = orderService.listByUserName(userName);
        if (orders == null || orders.isEmpty()) {
            return Result.error("没有找到订单");
        }
        return Result.success(orders);
    }
    @GetMapping("/getAllOrderList")
    public Result list(){
        log.info("获取所有订单");
        List<Order> list = orderService.list();
        return Result.success(list);
    }

    @GetMapping("/getOrderId/{orderId}")
    public Result query(@PathVariable Integer orderId){
        log.info("根据orderId查询订单：{}",orderId);
        if(orderId==null){
            return Result.error("id为空");
        }
        orderService.query(orderId);
        return Result.success();
    }

    @PutMapping("/order/update")
    public Result update(@RequestBody Order order){
        log.info("修改订单");
        orderService.update(order);
        return Result.success(order);
    }

    @GetMapping("/order/classify")
    public Result classifyList(){
        log.info("查询统计不同书籍类型的订单数量");
        List<CategoryCount> classifyList = orderService.getClassifyOrderList();
        return Result.success(classifyList);
    }

    @GetMapping("/order/promotionClassify")
    public Result promotionClassifyList(){
        log.info("查询统计不同书籍促销类型数量");
        List<CategoryCount> promotionClassifyList = orderService.getPromotionClassifyOrderList();
        return Result.success(promotionClassifyList);
    }

    @GetMapping("/status")
    public Result statusList(){
        log.info("查询统计订单状态数量");
        List<CategoryCount> statusList = orderService.getStatusList();
        return Result.success(statusList);
    }

    @GetMapping("/data")
    public Result dataList(){
        log.info("查询统计不同季度订单数量");
        List<CategoryCount> dataList = orderService.getDataList();
        return Result.success(dataList);
    }
}
