package com.mogui.mall.happymall.mapper;


import com.mogui.mall.happymall.dto.MgUmUserDto;
import com.mogui.mall.happymall.pojo.MgUmUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sun.awt.SunHints;

import java.util.List;


@Repository
@Mapper
public interface MgUmUserMapper {
    /**
     * 添加用户
     * @param mgUmUser
     * @return
     */
    int insertMgUmUser(MgUmUser mgUmUser);
    /**
     * 修改用户
     */
    int updateMgUmUser(MgUmUser mgUmUser);
    /**
     * 删除用户
     */
    int deleteMgUmUser(int id);
    /**
     * 查找用户
     */
    MgUmUser selectMgUmUser(@Param("userName") String userName);

    /**
     * 查找用户信息
     * @param mgUmUserDto
     * @return
     */
    MgUmUser selectMgUmUserDetail(MgUmUserDto mgUmUserDto);

    List<MgUmUserDto> selectMgUmUserRoles(MgUmUserDto mgUmUserDto);

}
