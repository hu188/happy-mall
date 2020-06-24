package com.mogui.mall.happymall.Seivice;

import com.mogui.mall.happymall.pojo.MgCmCommodity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MgCmCommodityService {
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
    List<MgCmCommodity> selectCommodity( String commodityName, Integer commodityType,
                                         Integer start,Integer pageSize);
}
