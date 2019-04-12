package com.dtdhehe.ptulife.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Create By Xie_东
 * on 2019/4/11 15:49
 */
@Entity
public class Market {

    @Id
    private String id;

    private String userId;

    private String goodsName;

    private String goodsDesc;

    private String goodsImg;

    private String goodsUser;

    private String goodsPrice;

    private String phone;

    private String createTime;

    @Override
    public String toString() {
        return "Market{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", goodsImg='" + goodsImg + '\'' +
                ", goodsUser='" + goodsUser + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsUser() {
        return goodsUser;
    }

    public void setGoodsUser(String goodsUser) {
        this.goodsUser = goodsUser;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
