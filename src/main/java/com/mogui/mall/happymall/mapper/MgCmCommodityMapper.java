package com.mogui.mall.happymall.mapper;

import com.mogui.mall.happymall.pojo.MgCmCommodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MgCmCommodityMapper {

    /**
     * 添加商品
     */
    int addCommodity(MgCmCommodity mgCmCommodity);

    /***
     * 删除商品
     */
    int deleteCommodity(@Param("ids") List<Integer> ids);

    /**
     * 修改商品
     */
    int updateCommodity(MgCmCommodity mgCmCommodity);

    /**
     * 查询商品
     */
    List<MgCmCommodity> selectCommodity(@Param("commodityName") String commodityName,@Param("commodityType")Integer commodityType);
}
