package com.ruoyi.system.domain;

import java.util.List;
import java.util.ArrayList;
import javax.validation.constraints.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 菜单权限表
 */
@Data
@Entity
@Table(name = "ZTC_MENU")
public class ZTCMenu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 菜单ID */
    @Id
    @Column(name = "MENU_ID")
    private Long menuId;

    /** 菜单名称 */
    @Column(name = "MENU_NAME")
    private String menuName;

    /** 父菜单名称 */
    @Column(name = "MENU_PARENTNAME")
    private String parentName;

    /** 父菜单ID */
    @Column(name = "MENU_PARENTID")
    private Long parentId;

    /** 显示顺序 */
    @Column(name = "MENU_ORDERNUM")
    private String orderNum;

    /** 菜单URL */
    @Column(name = "MENU_URL")
    private String url;
    
}
