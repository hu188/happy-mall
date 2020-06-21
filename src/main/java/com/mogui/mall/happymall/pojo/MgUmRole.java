package com.mogui.mall.happymall.pojo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

import java.util.Date;

/**
 * @author ke nan
 * @date 2020/6/19 23:42
 * @declare
 */
public class MgUmRole {

    private Integer id;

    @ApiModelProperty(value="角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色描述")
    private String remark;

    @ApiModelProperty(value = "是否发布 0:未发布；1：发布")
    private Integer status;

    @ApiModelProperty(value="创建时间")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MgUmRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
