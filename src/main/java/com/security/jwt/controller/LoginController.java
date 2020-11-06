package com.security.jwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wangzhipeng
 * @Date 2020/11/4 0004 下午 2:14
 */
@RestController
@CrossOrigin
public class LoginController {

    @GetMapping("/login")
    public String toLoginPage(){
        return "loginPage";
    }

    @GetMapping("/home")
    public String toHomePage(){
        return "homePage";
    }

}
