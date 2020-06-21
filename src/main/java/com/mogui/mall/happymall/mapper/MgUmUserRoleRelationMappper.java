package com.mogui.mall.happymall.mapper;

import com.mogui.mall.happymall.pojo.MgUmUserRoleRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ke nan
 * @date 2020/6/21 17:04
 * @declare
 */
@Repository
@Mapper
public interface MgUmUserRoleRelationMappper {
    /**
     * 删除用户角色
     */
    int deleteUserRoles(Integer userId);
    /**
     * 添加用户角色
     */
    int insertUserRoleInfo(@Param("list")List<MgUmUserRoleRelation> mgUmUserRoleRelation);
}
