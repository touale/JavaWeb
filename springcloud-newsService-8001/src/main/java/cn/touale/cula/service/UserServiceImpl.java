package cn.touale.cula.service;

import cn.touale.cula.entity.NewsUser;
import cn.touale.cula.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Touale
 * @description UserServiceImpl
 * @date 2021/12/31 15:39
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean tryLogin(String user, String pwd) {
        NewsUser newUser = new NewsUser();
        newUser.setUname(user);
        newUser.setUpwd(pwd);
        return userMapper.tryLogin(newUser) == 1 ? true : false;
    }
}

