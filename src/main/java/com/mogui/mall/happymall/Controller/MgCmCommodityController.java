package com.mogui.mall.happymall.Controller;

import com.mogui.mall.happymall.Seivice.MgCmCommodityService;
import com.mogui.mall.happymall.common.ResponseVO;
import com.mogui.mall.happymall.pojo.MgCmCommodity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "MgCmCommodityController",description = "商品管理类")
@RequestMapping(value = "/commodity")
public class MgCmCommodityController {

    @Autowired
    private MgCmCommodityService mgCmCommodityService;

    @ApiOperation(value = "添加商品")
    @RequestMapping(value = "/addCommodity",method = RequestMethod.POST)
    @ResponseBody
    public String addCommodity(@RequestBody MgCmCommodity mgCmCommodity){
        int result = mgCmCommodityService.addCommodity(mgCmCommodity);
        if(result>0){
            return ResponseVO.build().toJSON();
        }else{
            return ResponseVO.build().setMsg(400,"添加失败，请重试！").toJSON();
        }
    }
    @ApiOperation(value = "删除商品")
    @RequestMapping(value = "/deleteCommodity",method = RequestMethod.POST)
    @ResponseBody
    public String deleteCommodity(@RequestParam List<Integer> ids){
        int result = mgCmCommodityService.deleteCommodity(ids);
        if(result>0){
            return ResponseVO.build().toJSON();
        }else{
            return ResponseVO.build().setMsg(400,"删除失败，请重试！").toJSON();
        }
    }
    @ApiOperation(value = "修改商品")
    @RequestMapping(value = "/updateCommodity",method = RequestMethod.POST)
    @ResponseBody
    public String updateCommodity(@RequestBody MgCmCommodity mgCmCommodity){
        int result = mgCmCommodityService.updateCommodity(mgCmCommodity);
        if(result>0){
            return ResponseVO.build().toJSON();
        }else{
            return ResponseVO.build().setMsg(400,"修改失败，请重试！").toJSON();
        }
    }
    @ApiOperation(value = "查询商品")
    @RequestMapping(value = "/selectCommodity",method = RequestMethod.GET)
    @ResponseBody
    public String selectCommodity(@RequestParam String commodityName,@RequestParam Integer commodityType,
                                  @RequestParam Integer start,@RequestParam Integer pageSize){
        List<MgCmCommodity> mgCmCommodities = mgCmCommodityService.selectCommodity(commodityName,commodityType,start,pageSize);
        return ResponseVO.build().setData(mgCmCommodities).toJSON();
    }
}
