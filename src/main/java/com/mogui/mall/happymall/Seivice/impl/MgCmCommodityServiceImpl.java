package com.mogui.mall.happymall.Seivice.impl;

import com.github.pagehelper.PageHelper;
import com.mogui.mall.happymall.Seivice.MgCmCommodityService;
import com.mogui.mall.happymall.mapper.MgCmCommodityMapper;
import com.mogui.mall.happymall.pojo.MgCmCommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MgCmCommodityServiceImpl implements MgCmCommodityService {

    private final static Logger logger = LoggerFactory.getLogger(MgCmCommodityServiceImpl.class);

    private MgCmCommodityMapper mgCmCommodityMapper;
    /**
     * 添加商品
     */
    @Override
    public int addCommodity(MgCmCommodity mgCmCommodity) {
        return mgCmCommodityMapper.addCommodity(mgCmCommodity);
    }
    /***
     * 删除商品
     */
    @Override
    public int deleteCommodity(List<Integer> ids) {
        return mgCmCommodityMapper.deleteCommodity(ids);
    }
    /**
     * 修改商品
     */
    @Override
    public int updateCommodity(MgCmCommodity mgCmCommodity) {
        return mgCmCommodityMapper.updateCommodity(mgCmCommodity);
    }
    /**
     * 查询商品
     */
    @Override
    public List<MgCmCommodity> selectCommodity(String commodityName, Integer commodityType,
                                               Integer start,Integer pageSize) {
        PageHelper.startPage(start,pageSize);
        return mgCmCommodityMapper.selectCommodity(commodityName,commodityType);
    }
}
