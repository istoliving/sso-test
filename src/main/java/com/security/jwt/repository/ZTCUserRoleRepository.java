package com.security.jwt.repository;

import com.security.jwt.pojo.ZTCUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @Author shitie
 * @Date 2020/11/3 0003 上午 10:28
 */
@Repository
@Transactional(rollbackOn = Exception.class)
public interface ZTCUserRoleRepository extends JpaRepository<ZTCUserRole,ZTCUserRole> {

    /**
     *
     * 根据用户名和角色名保存用户角色表
     *
     * @param userName
     * @param roleName
     */
    @Modifying
    @Query(nativeQuery = true,value = "INSERT INTO ztc_user_role VALUES((SELECT USER_ID from ztc_user where USER_NAME=?1),(SELECT ROLE_ID FROM ztc_role WHERE ROLE_NAME=?2));")
    void save(String userName,String roleName);

}
