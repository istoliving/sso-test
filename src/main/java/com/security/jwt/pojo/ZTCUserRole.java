package com.security.jwt.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author shitie
 * @Date 2020/11/3 0003 上午 10:00
 */
@Data
@Entity
@Table(name = "ZTC_USER_ROLE")
@IdClass(ZTCUserRole.class)
public class ZTCUserRole implements Serializable {

    @Id
    @Column(name = "USER_ID",nullable = false)
    private Integer userId;

    @Id
    @Column(name = "ROLE_ID",nullable = false)
    private Integer roleId;

}
