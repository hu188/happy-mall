package com.mogui.mall.happymall.pojo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

import java.util.Date;

public class MgUmUser {

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

    @ApiModelProperty(value="创建时间")
    private Date createTime;

    @ApiModelProperty(value="是否启用")
    private Integer status;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MgUmUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", sex='" + sex + '\'' +
                ", headImgUrl='" + headImgUrl + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                '}';
    }
}
