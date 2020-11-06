package com.security.jwt.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Author shitie
 * @Date 2020/11/3 0003 上午 9:26
 */
@Data
@Entity
@Table(name = "ZTC_USER")
public class ZTCUser implements Serializable {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id自增长
    private Integer id;

    @Column(name = "USER_NAME",nullable = false)
    private String name;

    @Column(name = "USER_PASSWORD",nullable = false)
    private String password;

    /**
     * @Transient 表明是临时字段,roles是该用户的角色列表
     */
    @Transient
    private List<String> roles;

}
