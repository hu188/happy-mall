package com.mogui.mall.happymall.Seivice;

import com.mogui.mall.happymall.dto.MgUmPermissionTreeDto;
import com.mogui.mall.happymall.mapper.MgUmUserMapper;
import com.mogui.mall.happymall.pojo.MgUmPermission;
import io.swagger.models.auth.In;

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

    /**
     * 查找权限-分页
     */
    List<MgUmPermission> selectPermissionList(String name, Integer type, Integer start, Integer pageSize);

    /**
     * 查找权限资源数
     */
    List<MgUmPermissionTreeDto> selectPermissionTree();
}
