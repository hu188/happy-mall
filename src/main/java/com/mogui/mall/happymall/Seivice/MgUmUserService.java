package com.mogui.mall.happymall.Seivice;

import com.mogui.mall.happymall.common.ResponseVO;
import com.mogui.mall.happymall.dto.MgUmUserDto;
import com.mogui.mall.happymall.pojo.MgUmUser;

import java.util.List;

public interface MgUmUserService {

    /**
     * 根据用户名查找用户
     */
    MgUmUser selectMgUmUserByUserName(String userName);
    /**
     * 查找用户
     */
    ResponseVO selectMgUmUser(String userName, String userPwd);

    /**
     * 添加用户
     */
    ResponseVO insertMgUmUser(MgUmUser mgUmUser);

    /**
     * 修改用户
     */
    int saveUpdateUser(MgUmUser mgUmUser);

    /**
     * 删除用户
     */
    int deleteMgUmUser(int id);

    /**
     * 查找用户和角色
     */
    List<MgUmUserDto> selectUserAndRoles(String userName,int start,int pageSize);

    /**
     * 编辑用户角色
     */
    int updataUserRoleInfo(Integer userId,List<Integer> roleIds);
}
