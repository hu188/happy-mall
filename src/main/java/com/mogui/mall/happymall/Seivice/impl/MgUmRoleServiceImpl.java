package com.mogui.mall.happymall.Seivice.impl;

import com.github.pagehelper.PageHelper;
import com.mogui.mall.happymall.Seivice.MgUmRoleService;
import com.mogui.mall.happymall.mapper.MgUmRoleMapper;
import com.mogui.mall.happymall.pojo.MgUmRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ke nan
 * @date 2020/6/19 23:55
 * @declare
 */
@Service
public class MgUmRoleServiceImpl implements MgUmRoleService {

    @Autowired
    private MgUmRoleMapper mgUmRoleMapper;

    /**
     * 查找所有角色
     * @return
     */
    @Override
    public List<MgUmRole> selectAllRole() {

        return mgUmRoleMapper.selectAllRole();
    }

    @Override
    public List<MgUmRole> getRoleByPageSize(String roleName,Integer start,Integer pageSize) {
        PageHelper.startPage(start,pageSize);
        return mgUmRoleMapper.selectAllRole();
    }
}
