package com.ruoyi.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import ilg.security.jwt.demo.pojo.ZTCMenu;

/**
 * 菜单表 数据层
 */
public interface ZTCMenuRepository
{
    /**
     * 查询系统所有菜单（含按钮）
     * 
     * @return 菜单列表
     */
    public List<ZTCMenu> selectMenuAll();

    /**
     * 根据用户ID查询菜单
     * 
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<ZTCMenu> selectMenuAllByUserId(Long userId);

    /**
     * 查询系统正常显示菜单（不含按钮）
     * 
     * @return 菜单列表
     */
    public List<ZTCMenu> selectMenuNormalAll();

    /**
     * 根据用户ID查询菜单
     * 
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<ZTCMenu> selectMenusByUserId(Long userId);

    /**
     * 根据用户ID查询权限
     * 
     * @param userId 用户ID
     * @return 权限列表
     */
    public List<String> selectPermsByUserId(Long userId);

}
