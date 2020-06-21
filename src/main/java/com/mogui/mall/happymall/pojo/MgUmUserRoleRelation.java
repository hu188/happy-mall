package com.mogui.mall.happymall.pojo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author ke nan
 * @date 2020/6/21 17:09
 * @declare
 */
public class MgUmUserRoleRelation {

    private Integer id;

    @ApiModelProperty(value="用户id")
    private Integer userId;

    @ApiModelProperty(value = "角色id")
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
