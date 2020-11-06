package com.ruoyi.system.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.system.domain.SysMenu;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.SysUser;

/**
 * 菜单 业务层
 */
public interface ZTCMenuService
{
    /**
     * 根据用户ID查询菜单
     * 
     * @param user 用户信息
     * @return 菜单列表
     */
    public List<ZTCMenu> selectMenusByUser(ZTCUser user);

    /**
     * 查询系统菜单列表
     * 
     * @param menu 菜单信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<ZTCMenu> selectMenuList(ZTCMenu menu, Long userId);

    /**
     * 查询菜单集合
     * 
     * @param userId 用户ID
     * @return 所有菜单信息
     */
    public List<ZTCMenu> selectMenuAll(Long userId);

    /**
     * 根据用户ID查询权限
     * 
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectPermsByUserId(Long userId);


    /**
     * 查询系统所有权限
     * 
     * @param userId 用户ID
     * @return 权限列表
     */
    public Map<String, String> selectPermsAll(Long userId);

    /**
     * 校验菜单名称是否唯一
     * 
     * @param menu 菜单信息
     * @return 结果
     */
    public String checkMenuNameUnique(SysMenu menu);
}
