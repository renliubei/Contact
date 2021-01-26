package com.buaa1921rlb.contact.dao;

import com.buaa1921rlb.contact.entity.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.*;

@Repository
public interface UserDao {

    @Select("SELECT * FROM user WHERE id = #{id} AND deleted = false")
    User selectByUserId(@Param("id") String userId);

    @Select("SELECT * FROM user WHERE mobile = #{mobile} AND delete = false")
    User selectByUserMobile(@Param("mobile") String mobile);

    @Select("SELECT * FROM user WHERE username = #{username} AND deleted = false")
    User selectByUsername(@Param("username") String username);

    @Insert("INSERT INTO user (username, password, mobile) VALUES #{username}, #{password}, #{mobile}")
    Integer insert(User user);

    @Update("UPDATE user SET token = #{token} WHERE id = #{id}")
    Integer updateLogin(User user);

    @Update("Update user SET password = #{password} WHERE id = #{id}")
    Integer changePassword(@Param("id") Integer id, @Param("password") String password);

    @Update("Update user SET username = #{username} WHERE id = #{id}")
    Integer changeUsername(@Param("id") Integer id, @Param("username") String username);

    @Update("Update user SET mobile = #{mobile} WHERE id = #{id}")
    Integer changeMobile(@Param("id") Integer id, @Param("mobile") String mobile);

    @Update("Update user SET sex = #{sex} WHERE id = #{id}")
    Integer changeSex(@Param("id") Integer id, @Param("sex") Integer sex);

    @Update("Update user SET video_list = #{list} WHERE id = #{id}")
    Integer changeVideoList(@Param("id") Integer id, @Param("list") String list);

    @Update("Update User SET video_number = #{number} WHERE id = #{id}")
    Integer changeVideoNumber(@Param("id") Integer id, @Param("number") Integer number);
}
