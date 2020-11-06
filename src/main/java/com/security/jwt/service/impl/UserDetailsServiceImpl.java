package com.security.jwt.service.impl;

import com.security.jwt.pojo.JwtAuthUser;
import com.security.jwt.pojo.ZTCUser;
import com.security.jwt.repository.ZTCUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author shitie
 * @Date 2020/11/4 0004 下午 1:13
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ZTCUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        ZTCUser user = userRepository.findByName(userName);
        if (user==null){
            throw new UsernameNotFoundException("该用户不存在！！！");
        }
        user.setRoles(userRepository.getRolesByUserName(userName));
        System.out.println("UserDetailsServiceImpl==>loadUserByUsername:"+user.toString());
        return new JwtAuthUser(user);
    }
}
