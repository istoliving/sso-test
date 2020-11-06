package com.security.jwt.service;

import com.security.jwt.pojo.ZTCUser;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author shitie
 * @Date 2020/11/3 0003 上午 10:37
 */
@Transactional(rollbackOn = Exception.class)
public interface ZTCUserService {

    /**
     *  通过用户名查找用户
     *
     * @param username
     * @return
     */
    ZTCUser findByUserName(String username);

    /**
     *
     * 通过用户名得到角色列表
     *
     * @param userName
     * @return
     */
    List<String> getRolesByUserName(String userName);

    /**
     *
     * 通过用户名密码创建用户，默认角色为ROLE_USER
     *
     * @param userName
     * @param password
     * @return
     */
    ZTCUser insert(String userName,String password);

}
