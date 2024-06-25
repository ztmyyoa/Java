package com.example.weblean4.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.weblean4.pojo.CategoryCount;
import com.example.weblean4.pojo.User;
import com.example.weblean4.pojo.userTool;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
//    查询用户是否存在 并返回用户账号和昵称信息
//    @Select("SELECT user_name,nickname FROM user WHERE user_name = #{username} AND password = #{password}")
//    userTool findUsernameByCredentials(@Param("username") String username, @Param("password") String password);

    @Select("SELECT user_name, nickname FROM user1 WHERE user_name = #{username} AND password = #{password}")
    userTool findUsernameByCredentials(@Param("username") String username, @Param("password") String password);
//查询用户账号是否重复
    @Select("SELECT user_name, nickname FROM user1 WHERE user_name = #{username}")
    userTool findUserByUsername(@Param("username") String username);

    @Insert("INSERT INTO user1 (user_name, password) VALUES (#{username}, #{password})")
    int insertUser(@Param("username") String username, @Param("password") String password);


    // 查询用户的地址、昵称和联系方式
    @Select("SELECT  ship_address , nickname,phone_number FROM user1 WHERE user_name = #{username}")
    userTool findUserDetailsByUsername(@Param("username") String username);

    // 更新用户的地址、昵称和联系方式
    @Update("UPDATE user1 SET ship_address = #{shipAddress}, nickname = #{nickname}, phone_number = #{phoneNumber} WHERE user_name = #{username}")
    int updateUserDetails(userTool user);

//    管理员
@Select("select * from user1 where user_name=#{userName}")
User getByUserIdAndPassword(User user);
    @Update("UPDATE user1 SET password = #{newPassword} WHERE user_name = #{userName}")
    void updatePassword(@Param("userName") String userName, @Param("newPassword") String newPassword);

//    @Insert("insert into user1(user_id,user_name, password, nickname,phone_number) " +
//            "values (#{userId},#{userName},#{password},#{nickname},#{phoneNumber})")
//    int insert(User user);

    @Select("select * from user1")
    List<User> list();

    @Update("update user1 set user_name=#{userName},password=#{password},nickname=#{nickname},gender=#{gender},age=#{age},phone_number=#{phoneNumber}," +
            "ship_address=#{shipAddress},email=#{email},registration_date=#{registrationDate},avatar=#{avatar} where user_id=#{userId}")
    void update(User user);
    @Delete("delete from user1 where user_id=#{userId}")
    void delete(Integer userId);

    @Select("select gender as category,count(*) as count from user1 group by gender")
    List<CategoryCount> getGenderList();

    @Select("select * from user1 where user_id=#{userId}")
    List<User> query(Integer userId);

    @Select("SELECT " +
            "    CASE " +
            "        WHEN age BETWEEN 0 AND 18 THEN '0-18' " +
            "        WHEN age BETWEEN 19 AND 30 THEN '19-30' " +
            "        WHEN age BETWEEN 31 AND 50 THEN '31-50' " +
            "        WHEN age BETWEEN 51 AND 70 THEN '51-70' " +
            "        ELSE '70+' " +
            "    END AS category, " +
            "    COUNT(*) AS count " +
            "FROM user1 " +
            "GROUP BY category")

    List<CategoryCount> ageList();
    @Select("select * from user1 where user_name=#{userName}")
    User getByUserName(String userName);
}
