package cn.touale.cula.controller;

import cn.touale.cula.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Touale
 * @description UserService
 * @date 2021/12/31 15:43
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/doLogin")
    public Boolean doLogin(@RequestParam(name = "user") String user,
                           @RequestParam(name = "pwd") String pwd) {
        return userService.tryLogin(user, pwd);
    }
}
