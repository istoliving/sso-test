package com.security.jwt.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysPostService;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserService;
import com.security.jwt.pojo.ZTCUser;
import com.security.jwt.service.ZTCUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author shitie
 * @Date 2020/11/3 0003 上午 11:12
 */
@RestController
@RequestMapping(path = "/user")
public class ZTCUserController {

    @Autowired
    private ZTCUserService userService;

    @Autowired
    private ZTCRoleService roleService;
    

    @GetMapping("/{userName}")
    public ZTCUser getUser(@PathVariable String userName){
        ZTCUser user = userService.findByUserName(userName);
        user.setRoles(userService.getRolesByUserName(userName));
        return user;
    }
    
    @PostMapping("/list")
    public TableDataInfo list(ZTCUser user)
    {
        startPage();
        List<ZTCUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public AjaxResult export(ZTCUser user)
    {
        List<ZTCUser> list = userService.selectUserList(user);
        ExcelUtil<ZTCUser> util = new ExcelUtil<ZTCUser>(ZTCUser.class);
        return util.exportExcel(list, "用户数据");
    }

   
    


}
