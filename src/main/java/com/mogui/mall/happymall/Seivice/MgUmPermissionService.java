package com.mogui.mall.happymall.Seivice;

import com.mogui.mall.happymall.mapper.MgUmUserMapper;
import com.mogui.mall.happymall.pojo.MgUmPermission;

import java.util.List;

/**
 * @author ke nan
 * @date 2020/6/13 14:56
 * @declare 资源业务类
 */
public interface MgUmPermissionService {
    /**
     * 根据用户id查找用户权限
     */
    List<MgUmPermission> mgUmPermissionList(int userId);
    /**
     * 添加权限
     */
    int addPremission(MgUmPermission mgUmPermission);

    /**
     * 删除权限
     */
    int deletePermission(Integer id);

    /**
     * 修改权限
     */
    int updatePermission(MgUmPermission mgUmPermission);

    /**
     * 查找权限
     */
    List<MgUmPermission> selectPermission(MgUmPermission mgUmPermission);
}
