package org.example.backend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class UserController {
    /*
    处理所有登录、密码修改相关的请求
    TODO：
        isPasswordCorrect 去数据库中检查密码是否正确
        addUserToDatabase 进行注册时，将用户信息添加到数据库
        addUserInfo 用户信息界面，点击保存后对于非用户名、密码的用户信息直接进行修改
        modifyPassword 用户信息界面支持修改密码的操作
    */

    @PostMapping("/isPasswordCorrect")
    public String isPasswordCorrect(String username, String password) {
        return "passwordCorrect";
    }

    @PostMapping("/addUserToDatabase")
    public String addUserToDatabase(String username, String password) {
        return "addUserToDatabase";
    }

    @PostMapping("/addUserInfo")
    public String addUserInfo(String username, String password) {
        return "addUserInfo";
    }

}
