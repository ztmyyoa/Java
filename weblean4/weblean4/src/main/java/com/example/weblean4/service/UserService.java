package com.example.weblean4.service;

import com.example.weblean4.pojo.CategoryCount;
import com.example.weblean4.pojo.User;

import java.util.List;

public interface UserService {

    void update(User user);

    List<User> list();

    void delete(Integer userId);

    List<CategoryCount> genderList();

    List<User> query(Integer userId);

    List<CategoryCount> ageList();
    public User getByUserName(String userName);
    void updatePassword(String userName, String newPassword);

}
