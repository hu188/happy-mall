package com.mogui.mall.happymall.Controller;

import com.mogui.mall.happymall.Seivice.MgCmCommodityTypeService;
import com.mogui.mall.happymall.dto.MgCmCommodityTypeDto;

import com.mogui.mall.happymall.pojo.MgCmCommodityType;
import com.mogui.mall.happymall.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "MgCommodityController", description = "商品管理")
public class MgCommodityController {


    @Autowired
    private MgCmCommodityTypeService mgCmCommodityTypeService;

    @PostMapping(value = "addCommodityType")
    @ApiOperation("添加商品类型")
    public String addCommodityType(@RequestBody MgCmCommodityTypeDto mgCmCommodityTypeDto){
            return mgCmCommodityTypeService.insertCommodityType(mgCmCommodityTypeDto).toJSON();
    }

    @GetMapping(value = "getCommodityType")
    @ApiOperation("查找商品类型")
    public String getCommodityType(MgCmCommodityTypeDto mgCmCommodityTypeDto){
        return mgCmCommodityTypeService.selectCommodityType(mgCmCommodityTypeDto).toJSON();
    }

    @PostMapping(value="deleteCommodityType")
    @ApiOperation("删除商品类型")
    public String deleteCommodityType(@RequestParam("ids[]")List<Integer> ids){
        System.out.println(ids);
        return mgCmCommodityTypeService.deleteCommodityTypes(ids).toJSON();
    }
    @PostMapping(value="updateCommodityType")
    @ApiOperation("修改商品类型")
    public String updateCommodityType(@RequestBody MgCmCommodityType mgCmCommodityType){
        return mgCmCommodityTypeService.updateCommodityType(mgCmCommodityType).toJSON();
    }

    @PostMapping(value="updateCommodityTypeStatus")
    @ApiOperation("修改商品类型发布状态")
    public String updateCommodityTypeStatus(@RequestParam("ids[]") List<Integer> ids,@RequestParam int status){
        return mgCmCommodityTypeService.updateCommodityTypeStatus(ids,status).toJSON();
    }
}
