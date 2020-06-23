package com.mogui.mall.happymall.Seivice.impl;

import com.mogui.mall.happymall.Seivice.MgUmPermissionService;
import com.mogui.mall.happymall.mapper.MgUmPermissionMapper;
import com.mogui.mall.happymall.pojo.MgUmPermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ke nan
 * @date 2020/6/13 14:58
 * @declare 资源业务类
 */
@Service
public class MgUmPermissionServiceImpl implements MgUmPermissionService {

    private static final  Logger logger = LoggerFactory.getLogger(MgUmPermissionServiceImpl.class);

    @Autowired
    private MgUmPermissionMapper mgUmPermissionMapper;

    /**
     * 根据用户id查找用户权限
     */
    @Override
    public List<MgUmPermission> mgUmPermissionList(int userId) {
        return mgUmPermissionMapper.selectPermissionListByUserId(userId);
    }
    /**
     * 添加权限
     */
    @Override
    public int addPremission(MgUmPermission mgUmPermission) {
        return mgUmPermissionMapper.addPermission(mgUmPermission);
    }
    /**
     * 删除权限
     */
    @Override
    public int deletePermission(Integer id) {
        return mgUmPermissionMapper.deletePermission(id);
    }
    /**
     * 修改权限
     */
    @Override
    public int updatePermission(MgUmPermission mgUmPermission) {
        return mgUmPermissionMapper.updatePermission(mgUmPermission);
    }
    /**
     * 查找权限
     */
    @Override
    public List<MgUmPermission> selectPermission(MgUmPermission mgUmPermission) {
        return mgUmPermissionMapper.selectPermission(mgUmPermission);
    }
}
