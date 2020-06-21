package com.mogui.mall.happymall.dto;

import com.mogui.mall.happymall.pojo.MgUmRole;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class MgUmUserDto {

    private Integer id;
    @ApiModelProperty(value="用户名")
    private String userName;

    @ApiModelProperty(value="昵称")
    private String nickName;

    @ApiModelProperty(value="密码")
    private String userPwd;

    @ApiModelProperty(value="性别")
    private String sex;

    @ApiModelProperty(value="头像地址")
    private String headImgUrl;

    @ApiModelProperty(value="发布状态")
    private Integer status;

    @ApiModelProperty(value="创建时间")
    private Date createTime;

    private Integer start;

    private Integer pageSize;

    private List<MgUmRole> roleList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<MgUmRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<MgUmRole> roleList) {
        this.roleList = roleList;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
