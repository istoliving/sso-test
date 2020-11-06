package com.security.jwt.repository;


import com.security.jwt.pojo.ZTCUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author shitie
 * @Date 2020/11/3 0003 上午 10:02
 */
@Repository
public interface ZTCUserRepository extends JpaRepository<ZTCUser,Integer> {

    /**
     *
     * 通过UserName查找User
     *
     * @param userName
     * @return
     */
    ZTCUser findByName(String userName);

    /**
     *
     * 通过UserName查找该用户的角色列表
     *
     * @param userName
     * @return
     */
    @Query(nativeQuery = true,value ="SELECT ROLE_NAME from ztc_role WHERE ROLE_ID in (select ROLE_ID from ztc_user_role where USER_ID = (select USER_ID from ztc_user where USER_NAME= ?1));")
    List<String> getRolesByUserName(String userName);

}
