package com.buaa1921rlb.contact.dao;

import com.buaa1921rlb.contact.entity.User;

import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.*;

@Repository
public interface UserDao {

    @Select("SELECT * FROM user WHERE id = #{id} AND deleted = false")
    User selectByUserId(@Param("id") Integer userId);

    @Select("SELECT * FROM user WHERE mobile = #{mobile} AND deleted = false")
    User selectByUserMobile(@Param("mobile") String mobile);

    @Select("SELECT COUNT(id) FROM user WHERE mobile = #{mobile}")
    Integer countByMobile(@Param("mobile") String mobile);

    @Select("SELECT * FROM user WHERE username = #{username} AND deleted = false")
    User selectByUsername(@Param("username") String username);

    @Insert("INSERT INTO user (username, password, mobile, sex) VALUES (#{username}, #{password}, #{mobile}, #{sex})")
    Integer register(User user);

    @Update("UPDATE user SET token = #{token} WHERE id = #{id}")
    Integer updateLogin(User user);

    @Update("UPDATE user SET password = #{password} WHERE id = #{id}")
    Integer changePassword(@Param("id") Integer id, @Param("password") String password);

    @Update("UPDATE user SET username = #{username} WHERE id = #{id}")
    Integer changeUsername(@Param("id") Integer id, @Param("username") String username);

    @Update("UPDATE user SET mobile = #{mobile} WHERE id = #{id}")
    Integer changeMobile(@Param("id") Integer id, @Param("mobile") String mobile);

    @Update("UPDATE user SET sex = #{sex} WHERE id = #{id}")
    Integer changeSex(@Param("id") Integer id, @Param("sex") Integer sex);

    @Update("UPDATE user SET video_list = #{list} WHERE id = #{id}")
    Integer changeVideoList(@Param("id") Integer id, @Param("list") String list);

    @Update("UPDATE user SET video_number = #{number} WHERE id = #{id}")
    Integer changeVideoNumber(@Param("id") Integer id, @Param("number") Integer number);

    @Update("UPDATE user SET deleted = true WHERE id = #{id}")
    Integer deleteAccount(@Param("id") Integer id);
}
