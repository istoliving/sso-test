package com.security.jwt.service.impl;

import com.security.jwt.pojo.ZTCUser;
import com.security.jwt.repository.ZTCUserRepository;
import com.security.jwt.repository.ZTCUserRoleRepository;
import com.security.jwt.service.ZTCUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author shitie
 * @Date 2020/11/3 0003 上午 10:47
 */
@Service
public class ZTCUserServiceImpl implements ZTCUserService {

    @Autowired
    ZTCUserRepository userRepository;

    @Autowired
    private ZTCUserRoleRepository userRoleRepository;

    /**
     * 加密工具
     * */
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public ZTCUser findByUserName(String username) {
        return userRepository.findByName(username);
    }

    @Override
    public List<String> getRolesByUserName(String userName) {
        return userRepository.getRolesByUserName(userName);
    }

    @Override
    public ZTCUser insert(String userName, String password) {

        ZTCUser ztcUser = new ZTCUser();
        ztcUser.setName(userName);
        //将密码加密后存入数据库
        ztcUser.setPassword(bCryptPasswordEncoder.encode(password));
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        ztcUser.setRoles(roles);
        //将用户信息存入ZTC_USER表中
        ZTCUser result = userRepository.save(ztcUser);
        if (result.getName()!=null){
            //插入用户成功时成功用户的角色信息
            userRoleRepository.save(result.getName(),"ROLE_USER");
            result.setRoles(roles);
            return result;
        }
        return null;
    }
}
