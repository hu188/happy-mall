package com.mogui.mall.happymall.Seivice;

import com.mogui.mall.happymall.common.ResponseVO;
import com.mogui.mall.happymall.dto.MgCmCommodityTypeDto;
import com.mogui.mall.happymall.pojo.MgCmCommodityType;

import java.util.List;

/**
 * 商品管理
 */
public interface MgCmCommodityTypeService {

    /**
     * 添加商品类型
     */
    ResponseVO insertCommodityType(MgCmCommodityTypeDto mgCmCommodityTypeDto);



    /**
     * 批量删除
     */
    ResponseVO deleteCommodityTypes(List ids);

    /**
     * 修改商品类型
     */
    ResponseVO updateCommodityType(MgCmCommodityType mgCmCommodityType);
    /**
     *
     */
    ResponseVO updateCommodityTypeStatus(List ids,int status);

    /**
     * 查找类型
     */
    ResponseVO selectCommodityType(MgCmCommodityTypeDto mgCmCommodityTypeDto);

}
