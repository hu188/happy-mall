package com.mogui.mall.happymall.Seivice;

import com.mogui.mall.happymall.mapper.MgUmUserMapper;
import com.mogui.mall.happymall.pojo.MgUmPermission;

import java.util.List;

/**
 * @author ke nan
 * @date 2020/6/13 14:56
 * @declare 资源业务类
 */
public interface MgUmPermissionService {

    List<MgUmPermission> mgUmPermissionList(int userId);
}
