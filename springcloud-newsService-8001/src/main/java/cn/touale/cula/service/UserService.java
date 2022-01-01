package cn.touale.cula.service;

import org.springframework.stereotype.Service;

/**
 * @author Touale
 * @description UserSerice
 * @date 2021/12/31 15:39
 */
@Service
public interface UserService {
    boolean tryLogin(String user, String pwd);
}
