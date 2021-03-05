package com.buaa1921rlb.contact.services.impl;

import com.buaa1921rlb.contact.dao.UserDao;
import com.buaa1921rlb.contact.entity.User;
import com.buaa1921rlb.contact.services.UserService;
import com.buaa1921rlb.contact.util.HashUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public Integer register(String mobile, String password, String username, Integer sex) {
        User user = new User();
        user.setMobile(mobile);
        user.setUsername(username);
        user.setPassword(HashUtil.sha256(password));
        user.setSex(sex);
        user.setRegistrationTime(new Date());
        return userDao.register(user);
    }

    @Override
    @Transactional
    public User loginByMobile(String mobile, String password) {
        User user = userDao.selectByUserMobile(mobile);
        if (user != null && user.getPassword().equals(HashUtil.sha256(password))) {
            user.setToken(HashUtil.sha256(user.getMobile() + UUID.randomUUID()));
            if (userDao.updateLogin(user) == 1)
                return user;
        }
        return null;
    }

    @Override
    @Transactional
    public Integer changePassword(Integer id, String newPassword) {
        return userDao.changePassword(id, HashUtil.sha256(newPassword));
    }

    @Override
    @Transactional
    public Integer changeUsername(Integer id, String newUsername) {
        return userDao.changeUsername(id, newUsername);
    }

    @Override
    @Transactional
    public Integer changeSex(Integer id, Integer newSex) {
        return userDao.changeSex(id, newSex);
    }

    @Override
    @Transactional
    public Integer deleteAccount(Integer id) {
        return userDao.deleteAccount(id);
    }

    @Override
    public boolean checkMobileExists(String mobile) {
        return userDao.countByMobile(mobile) > 0;
    }
}
