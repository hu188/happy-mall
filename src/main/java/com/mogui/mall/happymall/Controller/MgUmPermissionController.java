package com.mogui.mall.happymall.Controller;

import com.mogui.mall.happymall.Seivice.MgUmPermissionService;
import com.mogui.mall.happymall.common.ResponseVO;
import com.mogui.mall.happymall.pojo.MgUmPermission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ke nan
 * @date 2020/6/23 22:57
 * @declare
 */
@Controller
@Api(tags = "MgUmPermissionController", description = "权限管理")
@RequestMapping(value = "/permission")
public class MgUmPermissionController {

    @Autowired
    private MgUmPermissionService mgUmPermissionService;


    @ApiOperation(value="添加权限")
    @PostMapping(value = "/addPermission")
    @ResponseBody
    public String addPermission(@RequestBody MgUmPermission mgUmPermission){
        int result = mgUmPermissionService.addPremission(mgUmPermission);
        if(result>0){
            return ResponseVO.build().toJSON();
        }else{
            return ResponseVO.build().setMsg(400,"添加失败，请重试！").toJSON();
        }
    }

    @ApiOperation(value="删除权限")
    @PostMapping(value = "/deletePermission")
    @ResponseBody
    public String deletePermission(@RequestParam Integer id){
        int result = mgUmPermissionService.deletePermission(id);
        if(result>0){
            return ResponseVO.build().toJSON();
        }else{
            return ResponseVO.build().setMsg(400,"删除失败，请重试！").toJSON();
        }
    }

    @ApiOperation(value="修改权限")
    @PostMapping(value = "/updatePermission")
    @ResponseBody
    public String updatePermission(@RequestBody MgUmPermission mgUmPermission){
        int result = mgUmPermissionService.updatePermission(mgUmPermission);
        if(result>0){
            return ResponseVO.build().toJSON();
        }else{
            return ResponseVO.build().setMsg(400,"修改失败，请重试！").toJSON();
        }
    }

    @ApiOperation(value="修改权限")
    @PostMapping(value = "/selectPermission")
    @ResponseBody
    public String selectPermission(@RequestBody MgUmPermission mgUmPermission){
        List<MgUmPermission> mgUmPermissions = mgUmPermissionService.selectPermission(mgUmPermission);

        return ResponseVO.build().setData(mgUmPermissions).toJSON();

    }
}
