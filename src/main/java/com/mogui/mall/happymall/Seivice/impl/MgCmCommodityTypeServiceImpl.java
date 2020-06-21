package com.mogui.mall.happymall.Seivice.impl;

import com.mogui.mall.happymall.mapper.MgCmCommodityTypeMapper;
import com.mogui.mall.happymall.Seivice.MgCmCommodityTypeService;
import com.mogui.mall.happymall.common.ResponseVO;
import com.mogui.mall.happymall.dto.MgCmCommodityTypeDto;
import com.mogui.mall.happymall.pojo.MgCmCommodityType;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MgCmCommodityTypeServiceImpl implements MgCmCommodityTypeService {


    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MgCmCommodityTypeServiceImpl.class);
    @Autowired
    private MgCmCommodityTypeMapper mgCmCommodityTypeMapper;
    /**
     * 添加商品
     * @param
     * @return
     */


    @Override
    public ResponseVO insertCommodityType(MgCmCommodityTypeDto mgCmCommodityTypeDto) {
        List<MgCmCommodityType>   type =  mgCmCommodityTypeMapper.selectCommodityType(mgCmCommodityTypeDto);
        if(type.size()<=0){
            mgCmCommodityTypeDto.setStatus(0);
            //没有此类型则添加
            int result =  mgCmCommodityTypeMapper.insertCommodityType(mgCmCommodityTypeDto);
            if(result>0){
                return  ResponseVO.build();
            }else{
                return   ResponseVO.build().setMsg(400,"添加失败！");
            }
        }else{
            return  ResponseVO.build().setMsg(400,"此类型已存在，不可重复添加！");
        }


    }



    @Override
    public ResponseVO deleteCommodityTypes(List ids) {
        int result = mgCmCommodityTypeMapper.deleteCommodityTypes(ids);
        if(result>0){
            return ResponseVO.build();
        }else{
            return ResponseVO.build().setMsg(400,"删除失败，请重试！");
        }

    }

    @Override
    public ResponseVO updateCommodityType(MgCmCommodityType mgCmCommodityType) {
        int result = mgCmCommodityTypeMapper.updateCommodityType(mgCmCommodityType);
        if(result>0){
            return ResponseVO.build();
        }else{
            return ResponseVO.build().setMsg(400,"提交失败，请重试！");
        }
    }

    @Override
    public ResponseVO updateCommodityTypeStatus(List ids, int status) {
        int result = mgCmCommodityTypeMapper.updateCommodityTypeStatus(ids,status);
        if(result>0){
            return ResponseVO.build();
        }else{
            return ResponseVO.build().setMsg(400,"修改失败，请重试！");
        }
    }


    @Override
    public ResponseVO selectCommodityType(MgCmCommodityTypeDto mgCmCommodityTypeDto) {

        List<MgCmCommodityType>  type= mgCmCommodityTypeMapper.selectCommodityType(mgCmCommodityTypeDto);
        return ResponseVO.build().setData(type);
    }


}
