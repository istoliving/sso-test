package com.security.jwt.model;

import lombok.Data;

/**
 * @Author shitie
 * @Date 2020/11/3 0003 下午 2:56
 */
@Data
public class LoginUser {

    private String username;
    private String password;
    private Boolean rememberUser;

}
