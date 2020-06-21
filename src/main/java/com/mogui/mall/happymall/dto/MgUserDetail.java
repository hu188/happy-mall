package com.mogui.mall.happymall.dto;

import com.mogui.mall.happymall.pojo.MgUmPermission;
import com.mogui.mall.happymall.pojo.MgUmUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ke nan
 * @date 2020/6/12 23:09
 * @declare springSecurity需要的用户详情
 */

public class MgUserDetail implements UserDetails {
    private MgUmUser mgUmUser;

    private List<MgUmPermission> mgUmPermissions;

    public MgUserDetail(MgUmUser mgUmUser,List<MgUmPermission> mgUmPermissions){
        this.mgUmUser = mgUmUser;
        this.mgUmPermissions = mgUmPermissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       //返回当前用户的权限
        return mgUmPermissions.stream()
                .filter(permission->permission.getValue() != null)
                .map(permission -> new SimpleGrantedAuthority(permission.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return mgUmUser.getUserPwd();
    }

    @Override
    public String getUsername() {
        return mgUmUser.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
