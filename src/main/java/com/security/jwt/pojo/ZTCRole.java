package com.security.jwt.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author shitie
 * @Date 2020/11/3 0003 上午 9:52
 */

@Data
@Entity
@Table(name = "ZTC_ROLE")
public class ZTCRole implements Serializable {

    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id自增长
    private Integer id;

    @Column(name = "ROLE_NAME",nullable = false)
    private String name;
}
