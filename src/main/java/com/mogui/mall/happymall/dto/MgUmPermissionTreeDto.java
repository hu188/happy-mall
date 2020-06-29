package com.mogui.mall.happymall.dto;

import com.mogui.mall.happymall.pojo.MgUmPermission;

import java.util.List;

/**
 * @author ke nan
 * @date 2020/6/29 22:48
 * @declare
 */
public class MgUmPermissionTreeDto  extends MgUmPermission {
    private List<MgUmPermission> children;

    public List<MgUmPermission> getChildren() {
        return children;
    }

    public void setChildren(List<MgUmPermission> children) {
        this.children = children;
    }
}
