package com.security.jwt.repository;

import com.security.jwt.pojo.ZTCRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @Author shitie
 * @Date 2020/11/3 0003 上午 10:20
 */
@Repository
public interface ZTCRoleRepository extends JpaRepository<ZTCRole,Integer> {

}
