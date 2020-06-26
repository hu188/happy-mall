package com.mogui.mall.happymall.Controller;

import com.mogui.mall.happymall.Seivice.MgUmRoleService;
import com.mogui.mall.happymall.common.ResponseVO;
import com.mogui.mall.happymall.pojo.MgUmRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ke nan
 * @date 2020/6/19 23:57
 * @declare
 */
@Controller
@Api(tags = "MgUmRoleController", description = "角色管理")
@RequestMapping("/role")
public class MgUmRoleController {

    @Autowired
    private MgUmRoleService mgUmRoleService;


    /**
     * 获取角色
     */
    @GetMapping("/getAllRole")
    @ApiOperation(value="获取所有角色")
    @ResponseBody
    public String getAllRole(){
      List<MgUmRole> roles =  mgUmRoleService.selectAllRole();
      return ResponseVO.build().setData(roles).toJSON();
    }
    /**
     * 获取角色-分页
     */
    @GetMapping("/getRoleByPageSize")
    @ApiOperation(value="获取所有角色")
    @ResponseBody
    public String getRoleByPageSize(@RequestParam String roleName,@RequestParam Integer start,@RequestParam Integer pageSize){
        List<MgUmRole> roles =  mgUmRoleService.getRoleByPageSize(roleName,start,pageSize);
        return ResponseVO.build().setData(roles).toJSON();
    }
    /**
     * 添加角色
     */
    @PostMapping("/addRole")
    @ApiOperation(value="添加角色")
    @ResponseBody
    public String addRole(@RequestBody MgUmRole mgUmRole){
        int result = mgUmRoleService.addRole(mgUmRole);
        if(result>0){
            return ResponseVO.build().toJSON();
        }else{
            return ResponseVO.build().setMsg(400,"添加失败,请重试！").toJSON();
        }

    }

    /**
     *
     */
    @PostMapping("/deleteRole")
    @ApiOperation(value="删除角色")
    @ResponseBody
    public String deleteRole(@RequestParam Integer id){
        int result = mgUmRoleService.deleteRole(id);
        if(result>0){
            return ResponseVO.build().toJSON();
        }else{
            return ResponseVO.build().setMsg(400,"删除失败,请重试！").toJSON();
        }

    }
    @PostMapping("/saveUpdateRole")
    @ApiOperation(value="修改角色")
    @ResponseBody
    public String saveUpdateRole(@RequestBody MgUmRole mgUmRole){
        int result = mgUmRoleService.updateRole(mgUmRole);
        if(result>0){
            return ResponseVO.build().toJSON();
        }else{
            return ResponseVO.build().setMsg(400,"修改失败,请重试！").toJSON();
        }

    }
}
