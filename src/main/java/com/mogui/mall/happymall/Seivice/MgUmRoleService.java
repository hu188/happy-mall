package com.mogui.mall.happymall.Seivice;

import com.mogui.mall.happymall.pojo.MgUmRole;

import java.util.List;

/**
 * @author ke nan
 * @date 2020/6/19 23:54
 * @declare
 */
public interface MgUmRoleService {

    //查找所有角色
    List<MgUmRole> selectAllRole();

    List<MgUmRole> getRoleByPageSize(String roleName,Integer start,Integer pageSize);

    //添加角色
    int addRole(MgUmRole mgUmRole);

    //删除角色
    int deleteRole(Integer id);

    //修改角色
    int updateRole(MgUmRole mgUmRole);
}
