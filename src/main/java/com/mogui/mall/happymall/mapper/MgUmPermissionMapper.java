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
     * 根据用户id查找用户资源
     */
    List<MgUmPermission> selectPermissionListByUserId(Integer id);

}
