package com.mogui.mall.happymall.Controller;

import com.mogui.mall.happymall.Seivice.MgUmPermissionService;
import com.mogui.mall.happymall.Seivice.MgUmUserService;
import com.mogui.mall.happymall.common.ResponseVO;
import com.mogui.mall.happymall.dto.MgUmUserDto;
import com.mogui.mall.happymall.pojo.MgUmUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "MgUmUserController", description = "用户管理")
@Controller
@RequestMapping("/admin")
public class MgUmUserController {

    @Autowired
    private MgUmUserService mgUmUserService;

    @Autowired
    private MgUmPermissionService mgUmPermissionService;


    @ApiOperation("用户登录,并返回token")
    @GetMapping(value="/login")
    @ResponseBody
    public String login(@RequestParam String userName,@RequestParam String password){

        return mgUmUserService.selectMgUmUser(userName,password).toJSON();
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestBody MgUmUser mgUmUser){

        return mgUmUserService.insertMgUmUser(mgUmUser).toJSON();
    }

    @ApiOperation("修改用户信息")
    @PostMapping("/saveUpdateUser")
    @ResponseBody
    public String saveUpdateUser(@RequestBody MgUmUser mgUmUser){
        int result = mgUmUserService.saveUpdateUser(mgUmUser);
        if(result>0){
            return ResponseVO.build().toJSON();
        }else{
            return ResponseVO.build().setMsg(400,"修改失败").toJSON();
        }

    }

    @ApiOperation("删除用户")
    @PostMapping("/deleteUser/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable Integer id){
        int result = mgUmUserService.deleteMgUmUser(id);
        if(result>0){
            return ResponseVO.build().toJSON();
        }else{
            return ResponseVO.build().setMsg(400,"删除失败").toJSON();
        }
    }

    @ApiOperation("用户退出登录")
    @GetMapping
    @ResponseBody
    public String logout(){
        return "成功";
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public String getUserInfo(Principal principal) {

        String userName = principal.getName();
        MgUmUser mgUmUser = mgUmUserService.selectMgUmUserByUserName(userName);
        Map<String, Object> data = new HashMap<>();
        data.put("username", mgUmUser.getUserName());
        data.put("roles", new String[]{"TEST"});
        data.put("menus", mgUmPermissionService.mgUmPermissionList(mgUmUser.getId()));
        data.put("icon", mgUmUser.getHeadImgUrl());
        return ResponseVO.build().setData(data).toJSON();
    }

    @ApiOperation(value="获取用户信息")
    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    @ResponseBody
    public String getUserList(@RequestParam String userName,@RequestParam Integer start,@RequestParam Integer pageSize){
        List<MgUmUserDto> userAndRoles = mgUmUserService.selectUserAndRoles(userName,start,pageSize);
        return ResponseVO.build().setData(userAndRoles).toJSON();
    }


    @PostMapping("/editUserRole")
    @ApiOperation(value="编辑用户角色")
    @ResponseBody
    public String editUserRole(@RequestParam Integer userId,@RequestParam List<Integer> roleIds){
        int result = mgUmUserService.updataUserRoleInfo(userId,roleIds);
        if(result>0){
            return ResponseVO.build().toJSON();
        }else{
            return ResponseVO.build().setMsg(400,"操作失败").toJSON();
        }

    }
}
