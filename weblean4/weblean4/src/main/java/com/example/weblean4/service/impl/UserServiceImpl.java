package com.example.weblean4.service.impl;


import com.example.weblean4.mapper.UserMapper;
import com.example.weblean4.pojo.CategoryCount;
import com.example.weblean4.pojo.User;
import com.example.weblean4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void updatePassword(String userName, String newPassword) {
        userMapper.updatePassword(userName, newPassword);
    }
    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public void delete(Integer userId) {
        userMapper.delete(userId);
    }

    @Override
    public List<CategoryCount> genderList() {
        return userMapper.getGenderList();
    }

    @Override
    public List<User> query(Integer userId) {
        return userMapper.query(userId);
    }

    @Override
    public List<CategoryCount> ageList() {
        return userMapper.ageList();
    }
    @Override
    public User getByUserName(String userName) {
        return userMapper.getByUserName(userName);
    }

}
