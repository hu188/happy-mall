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

    /**
     * 根据名称查找角色
     * @param roleName
     * @param start
     * @param pageSize
     * @return
     */
    @Override
    public List<MgUmRole> getRoleByPageSize(String roleName,Integer start,Integer pageSize) {
        PageHelper.startPage(start,pageSize);
        MgUmRole mgUmRole = new MgUmRole();
        mgUmRole.setRoleName(roleName);
        return mgUmRoleMapper.selectRole(mgUmRole);
    }

    /**
     * 添加角色
     * @param mgUmRole
     * @return
     */
    @Override
    public int addRole(MgUmRole mgUmRole) {

        return mgUmRoleMapper.addRole(mgUmRole);
    }

    @Override
    public int deleteRole(Integer id) {
        return mgUmRoleMapper.deleteRole(id);
    }

    @Override
    public int updateRole(MgUmRole mgUmRole) {
        return mgUmRoleMapper.updateRole(mgUmRole);
    }
}
