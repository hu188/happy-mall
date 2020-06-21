package com.mogui.mall.happymall.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class MgCmCommodityType {

    @ApiModelProperty("id")
    private int id;

    @ApiModelProperty("商品类型")
    private String commodityType;

    @ApiModelProperty("商品描述")
    private String commodityDescription;

    @ApiModelProperty("发布状态")
    private int status;

    @ApiModelProperty("发布时间")
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MgCmCommodityType{" +
                "id=" + id +
                ", commodityType='" + commodityType + '\'' +
                ", commodityDescription='" + commodityDescription + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
