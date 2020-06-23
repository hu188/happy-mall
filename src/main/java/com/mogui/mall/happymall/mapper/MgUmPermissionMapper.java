package com.mogui.mall.happymall.mapper;

import com.mogui.mall.happymall.pojo.MgUmPermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ke nan
 * @date 2020/6/13 0:04
 * @declare
 */
@Mapper
@Repository
public interface MgUmPermissionMapper {

    /**
     * 根据用户id查找用户权限
     */
    List<MgUmPermission> selectPermissionListByUserId(Integer id);


    /**
     * 添加权限
     */
    int addPermission(MgUmPermission mgUmPermission);

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
