package com.mogui.mall.happymall.mapper;

import com.mogui.mall.happymall.pojo.MgUmRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ke nan
 * @date 2020/6/19 23:50
 * @declare
 */
@Repository
@Mapper
public interface MgUmRoleMapper {

    //查找所有角色
    List<MgUmRole> selectAllRole();


}
