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

}
