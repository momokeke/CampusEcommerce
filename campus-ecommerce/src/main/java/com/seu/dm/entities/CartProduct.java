package com.seu.dm.entities;

/**
 * Created by 张老师 on 2017/3/9.
 */
public class CartProduct {
    private int productId;
    private String productName;
    private Double productPrice;
    private int buyNummber;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public int getBuyNummber() {
        return buyNummber;
    }

    public void setBuyNummber(int buyNummber) {
        this.buyNummber = buyNummber;
    }
}
