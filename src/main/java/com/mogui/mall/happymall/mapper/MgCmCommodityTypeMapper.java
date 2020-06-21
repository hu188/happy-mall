package com.mogui.mall.happymall.mapper;

import com.mogui.mall.happymall.dto.MgCmCommodityTypeDto;
import com.mogui.mall.happymall.pojo.MgCmCommodityType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MgCmCommodityTypeMapper {
    /**
     * 添加商品类型
     */
    int insertCommodityType(MgCmCommodityTypeDto mgCmCommodityTypeDto);



    /**
     * 批量删除
     */
    int deleteCommodityTypes(@Param("ids")List ids);

    /**
     * 修改商品类型
     */
    int updateCommodityType(MgCmCommodityType mgCmCommodityType);
    /**
     * 修改商品类型发布状态
     */
    int updateCommodityTypeStatus(@Param("ids") List ids,@Param("status") int status);

    /**
     * 查找类型
     */
    List<MgCmCommodityType>  selectCommodityType(MgCmCommodityTypeDto mgCmCommodityTypeDto);


}
