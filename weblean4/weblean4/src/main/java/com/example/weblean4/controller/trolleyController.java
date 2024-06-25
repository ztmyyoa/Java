package com.example.weblean4.controller;

import com.example.weblean4.mapper.trolleyMapper;
import com.example.weblean4.pojo.Trolley;
import com.example.weblean4.pojo.TrolleyDto;
import com.example.weblean4.pojo.TrolleyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Book")  // 设置统一的请求路径前缀
public class trolleyController {
    @Autowired
    private trolleyMapper trolleyMapper;


@PostMapping("/addTrolley")
public ResponseEntity<?> addToTrolley(@RequestBody TrolleyRequest trolleyRequest) {
    try {
        // Convert string values to appropriate types
        int bookID = Integer.parseInt(trolleyRequest.getBookID());
        BigDecimal price = new BigDecimal(trolleyRequest.getPrice());
        int quantity = Integer.parseInt(trolleyRequest.getQuantity());
        BigDecimal amount = new BigDecimal(trolleyRequest.getAmount());
        int currentBook=Integer.parseInt(trolleyRequest.getCurrentBook());

        // Perform null checks for required parameters
        if (trolleyRequest.getUserAccount() == null ||
                trolleyRequest.getBookID() == null ||
                trolleyRequest.getPrice() == null ||
                trolleyRequest.getQuantity() == null ||
                trolleyRequest.getAmount() == null||
                trolleyRequest.getImageUrl() == null ||
                trolleyRequest.getCurrentBook() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("参数不能为空");
        }
        if (trolleyMapper.bookExists(bookID) == 0) {
//            throw new RuntimeException("Book does not exist");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("不存在该书籍id");
        }
        // Insert into database
        int rowsAffected = trolleyMapper.insertTrolley(
                trolleyRequest.getUserAccount(),
                bookID,
                price,
                quantity,
                amount,
                trolleyRequest.getImageUrl(),
                currentBook
        );

        if (rowsAffected > 0) {
            return ResponseEntity.ok("添加成功");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("添加失败");
        }
    } catch (NumberFormatException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("参数格式错误: " + e.getMessage());
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("添加失败: " + e.getMessage());
    }
}

    @GetMapping("/getTrolley")
    public ResponseEntity<?> getTrolleyByAccount(@RequestParam String userAccount) {
        try {
            List<TrolleyDto> trolleyDtoList = trolleyMapper.getTrolleyByUserAccount(userAccount);
            if (!trolleyDtoList.isEmpty()) {
                return ResponseEntity.ok(trolleyDtoList);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("获取购物车信息失败: " + e.getMessage());
        }
    }
    @GetMapping("/getOneTrolley")
    public ResponseEntity<?> getTrolleyByAccountOne(@RequestParam String userAccount) {
        try {
            List<TrolleyDto> trolleyDtoList = trolleyMapper.getTrolleyByUserAccountOne(userAccount);
            if (!trolleyDtoList.isEmpty()) {
                return ResponseEntity.ok(trolleyDtoList);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("获取购物车信息失败: " + e.getMessage());
        }
    }
    @GetMapping("/getPromoTrolley")
    public ResponseEntity<?> getTrolleyPromoByAccount(@RequestParam String userAccount) {
        try {
            List<TrolleyDto> trolleyDtoList = trolleyMapper.getTrolleyPromoteByUserAccount(userAccount);
            if (!trolleyDtoList.isEmpty()) {
                return ResponseEntity.ok(trolleyDtoList);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("获取购物车信息失败: " + e.getMessage());
        }
    }
    @DeleteMapping("/removeFromTrolley")
    public ResponseEntity<String> removeFromTrolley(@RequestParam String userAccount, @RequestParam int bookID) {
        int i = trolleyMapper.deleteTrolley(userAccount, bookID);
        if (i>=1) {
            return ResponseEntity.ok("删除成功");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("删除失败");
        }
    }
}
