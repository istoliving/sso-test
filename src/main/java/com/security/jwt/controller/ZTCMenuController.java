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
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysMenu;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.service.ISysMenuService;

/**
 * 菜单信息
 */
@Controller
@RequestMapping("/system/menu")
public class ZTCMenuController
{
    @Autowired
    private ZTCMenuService menuService;

    @GetMapping()
    public String menu()
    {
        return prefix + "/menu";
    }

    @PostMapping("/list")
    public List<ZTCMenu> list(ZTCMenu menu)
    {
        Long userId = ShiroUtils.getUserId();
        List<ZTCMenu> menuList = menuService.selectMenuList(menu, userId);
        return menuList;
    }
    
    /**
     * 校验菜单名称
     */
    @ResponseBody
    public String checkMenuNameUnique(SysMenu menu)
    {
        return menuService.checkMenuNameUnique(menu);
    }

}