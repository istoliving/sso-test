package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.SysUserRole;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserService;

/**
 * 角色信息
 *
 */
@Controller
@RequestMapping("/system/role")
public class SysRoleController extends BaseController
{
    private String prefix = "system/role";

    @Autowired
    private ZTCRoleService roleService;

    @Autowired
    private ZTCsUserService userService;
    
    @GetMapping()
    public String role()
    {
        return prefix + "/role";
    }
    
    @PostMapping("/list")
    public TableDataInfo list(SysRole role)
    {
        startPage();
        List<ZTCRole> list = roleService.selectRoleList(role);
        return getDataTable(list);
    }
    
    @PostMapping("/export")
    public AjaxResult export(ZTCRole role)
    {
        List<ZTCRole> list = roleService.selectRoleList(role);
        ExcelUtil<ZTCRole> util = new ExcelUtil<ZTCRole>(ZTCRole.class);
        return util.exportExcel(list, "角色数据");
    }
    
    
    /**
     * 角色分配数据权限
     */
    @GetMapping("/authDataScope/{roleId}")
    public String authDataScope(@PathVariable("roleId") Long roleId, ModelMap mmap)
    {
        mmap.put("role", roleService.selectRoleById(roleId));
        return prefix + "/dataScope";
    }

    /**
     * 校验角色权限
     */
    @PostMapping("/checkRoleKeyUnique")
    public String checkRoleKeyUnique(ZTCRole role)
    {
        return roleService.checkRoleKeyUnique(role);
    }
    
}