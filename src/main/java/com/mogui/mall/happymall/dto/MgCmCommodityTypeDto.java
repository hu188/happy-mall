package com.mogui.mall.happymall.dto;


import io.swagger.annotations.ApiModelProperty;

public class MgCmCommodityTypeDto {
    @ApiModelProperty("商品类型")
    private String commodityType;

    @ApiModelProperty("商品描述")
    private String commodityDescription;

    @ApiModelProperty("发布状态")
    private Integer status;

    public String getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(String commodityType) {
        this.commodityType = commodityType;
    }

    public String getCommodityDescription() {
        return commodityDescription;
    }

    public void setCommodityDescription(String commodityDescription) {
        this.commodityDescription = commodityDescription;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MgCmCommodityTypeDto{" +
                "commodityType='" + commodityType + '\'' +
                ", commodityDescription='" + commodityDescription + '\'' +
                ", status=" + status +
                '}';
    }
}
