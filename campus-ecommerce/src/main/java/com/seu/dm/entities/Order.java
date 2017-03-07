package com.seu.dm.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer id;

    private Integer oederInfoId;

    private Integer userId;

    private Integer sellerId;

    private Date createTime;

    private BigDecimal totalPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOederInfoId() {
        return oederInfoId;
    }

    public void setOederInfoId(Integer oederInfoId) {
        this.oederInfoId = oederInfoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}