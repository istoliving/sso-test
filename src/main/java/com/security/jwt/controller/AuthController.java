package com.security.jwt.controller;

import com.security.jwt.pojo.ZTCUser;
import com.security.jwt.service.ZTCUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author shitie
 * @Date 2020/11/3 0003 上午 11:18
 */
@Controller
@RequestMapping(path = "/auth",produces = "application/json;charset=utf-8")
public class AuthController {

    @Autowired
    private ZTCUserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String,String> registerUser){
        String userName = registerUser.get("username");
        String password = registerUser.get("password");
        ZTCUser user = userService.insert(userName, password);
        if (user==null){
            return "新建用户失败！！！！！";
        }
        return "registerPage";
    }

}
