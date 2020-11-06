package com.ruoyi.system.service;

import java.util.List;
import java.util.Set;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.SysUserRole;

/**
 * 角色业务层
 */
public interface ISysRoleService
{
    /**
     * 根据用户ID查询角色
     * 
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectRoleKeys(Long userId);

    /**
     * 查询所有角色
     * 
     * @return 角色列表
     */
    public List<SysRole> selectRoleAll();


    /**
     * 校验角色名称是否唯一
     * 
     * @param role 角色信息
     * @return 结果
     */
    public String checkRoleNameUnique(ZTCRole role);

    /**
     * 校验角色权限是否唯一
     * 
     * @param role 角色信息
     * @return 结果
     */
    public String checkRoleKeyUnique(SysRole role);

    




}
