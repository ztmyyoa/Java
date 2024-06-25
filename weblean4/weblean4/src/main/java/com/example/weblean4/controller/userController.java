package com.example.weblean4.controller;

import com.example.weblean4.mapper.UserMapper;
import com.example.weblean4.pojo.*;
import com.example.weblean4.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Book")  // 设置统一的请求路径前缀
public class userController {
    @Autowired
    private UserMapper userMapper;

//    验证是否存在该账户
@GetMapping("/verifyLogin")
public userTool verifyCredentials(@RequestParam String username, @RequestParam String password) {
    userTool result = userMapper.findUsernameByCredentials(username, password);
    if (result != null) {
        return result;
    } else {
        throw new RuntimeException("不存在该用户或密码错误");
    }
}


    // 添加一个新用户的接口
    @PostMapping("/registAction")
    public ResponseEntity<String> registerUser(@RequestBody Map<String, String> userCredentials) {
        String username = userCredentials.get("username");
        String password = userCredentials.get("password");

        // 检查用户是否已经存在（只检查用户名）
        userTool existingUser = userMapper.findUserByUsername(username);
        if (existingUser != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("用户已存在");
        }

        // 插入新用户
        userMapper.insertUser(username, password);
        return ResponseEntity.status(HttpStatus.CREATED).body("用户注册成功");
    }

    // 查询用户详细信息（地址、昵称和联系方式）
    @GetMapping("/getUserDetails")
    public ResponseEntity<userTool> getUserDetails(@RequestParam String username) {
        userTool userDetails = userMapper.findUserDetailsByUsername(username);
        if (userDetails != null) {
            return ResponseEntity.ok(userDetails);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    // 更新用户详细信息
    @PutMapping("/updateUserDetails")
    public ResponseEntity<Map<String, String>> updateUserDetails(@RequestBody userTool user) {
        int result = userMapper.updateUserDetails(user);
        if (result > 0) {
            Map<String, String> response = new HashMap<>();
            response.put("success", "true");
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("success", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

//    管理员
@Autowired
private UserService userService;

    @GetMapping("/getAllList")
    public Result list(){
        List<User> list = userService.list();
        return Result.success(list);
    }
    @GetMapping("/getSelf/{userId}")
    public Result query(@PathVariable Integer userId){
        log.info("根据orderId查询订单：{}",userId);
        if(userId==null){
            return Result.error("id为空");
        }
        userService.query(userId);
        return Result.success();
    }

    @DeleteMapping("/users/{userId}")
    public Result delete(@PathVariable Integer userId){
        log.info("根据id删除顾客：{}",userId);
        userService.delete(userId);
        return Result.success();
    }
    @PutMapping("/update")
    public Result update(@RequestBody User user){
        log.info("修改顾客：{}",user);
        userService.update(user);
        return Result.success();
    }

    @GetMapping("/gender")
    public Result genderList(){
        log.info("统计男女性别数量");
        List<CategoryCount> genderCategoryCounts = userService.genderList();
        return Result.success(genderCategoryCounts);
    }

    @GetMapping("/age")
    public Result ageList(){
        log.info("统计年龄数量");
        List<CategoryCount> categoryCounts = userService.ageList();
        return Result.success(categoryCounts);
    }
    @GetMapping("/getSelfUser/username/{username}")
    public Result getByUserName(@PathVariable String userName){
        log.info("根据userName查询用户信息：{}", userName);
        User user = userService.getByUserName(userName);
        return user != null ? Result.success(user) : Result.error("用户不存在");
    }

    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody UpdatePasswordRequest request) {
        log.info("更新密码请求：{}", request);

        try {
            userService.updatePassword(request.getUserName(), request.getNewPassword());
            return Result.success();
        } catch (Exception e) {
            log.error("更新密码时发生错误", e);
            return Result.error("更新密码时发生错误");
        }
    }
}
