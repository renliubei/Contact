package com.buaa1921rlb.contact.services;

import com.buaa1921rlb.contact.entity.User;

public interface UserService {

    /**
     * 用户注册
     *
     * @param mobile   手机号
     * @param password 密码
     * @param username 用户名
     * @param sex      性别
     * @return 成功返回用户
     */
    Integer register(String mobile, String password, String username, Integer sex);

    /**
     * 用户登录
     *
     * @param mobile   用户手机号
     * @param password 用户密码
     * @return 成功返回用户
     */
    User loginByMobile(String mobile, String password);

    /**
     * 用户修改密码
     *
     * @param id          用户 id
     * @param newPassword 新密码
     * @return 成功返回 1
     */
    Integer changePassword(Integer id, String newPassword);

    /**
     * 用户修改用户名
     *
     * @param id          用户 id
     * @param newUsername 新用户名
     * @return 成功返回 1
     */
    Integer changeUsername(Integer id, String newUsername);

    /**
     * 用户修改性别
     *
     * @param id     用户 id
     * @param newSex 新性别
     * @return 成功返回 1
     */
    Integer changeSex(Integer id, Integer newSex);

    /**
     * 用户销户
     *
     * @param id 用户 id
     * @return 成功返回 1
     */
    Integer deleteAccount(Integer id);

    /**
     * 检查手机号是否存在
     *
     * @param mobile 手机号
     * @return 存在返回 true
     */
    boolean checkMobileExists(String mobile);
}
