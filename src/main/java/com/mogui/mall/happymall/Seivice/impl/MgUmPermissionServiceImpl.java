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


    @Override
    public List<MgUmPermission> mgUmPermissionList(int userId) {
        return mgUmPermissionMapper.selectPermissionListByUserId(userId);
    }
}
