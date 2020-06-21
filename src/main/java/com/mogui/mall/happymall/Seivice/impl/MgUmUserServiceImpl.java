package com.mogui.mall.happymall.Seivice.impl;

import com.mogui.mall.happymall.dto.MgUmUserDto;
import com.mogui.mall.happymall.mapper.MgUmUserMapper;
import com.mogui.mall.happymall.Seivice.MgUmUserService;
import com.mogui.mall.happymall.common.ResponseVO;
import com.mogui.mall.happymall.mapper.MgUmUserRoleRelationMappper;
import com.mogui.mall.happymall.pojo.MgUmUser;
import com.mogui.mall.happymall.pojo.MgUmUserRoleRelation;
import com.mogui.mall.happymall.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MgUmUserServiceImpl implements MgUmUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MgUmUserServiceImpl.class);

    @Autowired
    private MgUmUserMapper mgUmUserMapper;
    @Autowired
    private MgUmUserRoleRelationMappper mgUmUserRoleRelationMappper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public  MgUmUser selectMgUmUserByUserName(String userName) {
        MgUmUser user = mgUmUserMapper.selectMgUmUser(userName);
        System.out.println(user);
        return user;
    }

    /**
     * 查找用户
     * @param
     * @return
     */
    @Override
    public ResponseVO selectMgUmUser(String userName,String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        if (token == null) {
            return ResponseVO.build().setMsg(400,"用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return ResponseVO.build().setData(tokenMap);

    }



    /**
     * 添加用户
     * @param mgUmUser
     */
    @Override
    public ResponseVO insertMgUmUser(MgUmUser mgUmUser) {
        MgUmUser m = mgUmUserMapper.selectMgUmUser(mgUmUser.getUserName());
        if(m == null){
            int result = mgUmUserMapper.insertMgUmUser(mgUmUser);
            if (result>0){
                return ResponseVO.build();
            }else {
                return ResponseVO.build().setMsg(400,"注册失败,请重试");
            }
        }else{
            return ResponseVO.build().setMsg(200,"此号码已注册，您可直接登录");
        }


    }

    /**
     * 编辑用户
     * @param mgUmUser
     * @return
     */
    @Override
    public int saveUpdateUser(MgUmUser mgUmUser) {
        return mgUmUserMapper.updateMgUmUser(mgUmUser);
    }

    /**
     * 删除用户
     * @param
     * @return
     */
    @Override
    public int deleteMgUmUser(int id) {
        return mgUmUserMapper.deleteMgUmUser(id);
    }

    /**
     * 查找用户和角色
     */
    @Override
    public List<MgUmUserDto> selectUserAndRoles(String userName, int start, int pageSize) {
        MgUmUserDto mgUmUserDto = new MgUmUserDto();
        mgUmUserDto.setPageSize(pageSize);
        mgUmUserDto.setStart(start);
        mgUmUserDto.setUserName(userName);
        List<MgUmUserDto>  userList = mgUmUserMapper.selectMgUmUserRoles(mgUmUserDto);
        return userList;
    }

    @Override
    public int updataUserRoleInfo(Integer userId, List<Integer> roleIds) {
        //删除用户原有角色
        mgUmUserRoleRelationMappper.deleteUserRoles(userId);
        //添加用户新的角色
        List<MgUmUserRoleRelation> list = new ArrayList<>();
        roleIds.forEach(item->{
            MgUmUserRoleRelation mgUmUserRoleRelation = new MgUmUserRoleRelation();
            mgUmUserRoleRelation.setRoleId(item);
            mgUmUserRoleRelation.setUserId(userId);
            list.add(mgUmUserRoleRelation);
        });


        return  mgUmUserRoleRelationMappper.insertUserRoleInfo(list);
    }
}
