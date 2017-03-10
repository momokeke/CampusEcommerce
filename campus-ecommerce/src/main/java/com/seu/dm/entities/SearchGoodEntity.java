package com.seu.dm.entities;

/**
 * Created by 张老师 on 2017/3/8.
 */
public class SearchGoodEntity {
    private String productName;
    private int productId;
    private double productPrice;
    private String productDescription;
    private int pictureId;
    private String pictureUrl;
    private int sellId;
    private String sellName;
    private int orderProductId;
    private int sellAmount;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public int getSellId() {
        return sellId;
    }

    public void setSellId(int sellId) {
        this.sellId = sellId;
    }

    public String getSellName() {
        return sellName;
    }

    public void setSellName(String sellName) {
        this.sellName = sellName;
    }

    public int getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(int sellAmount) {
        this.sellAmount = sellAmount;
    }

    public SearchGoodEntity(){

    }

    public SearchGoodEntity(Product product,Picture picture,Seller seller,OrderProduct orderProduct){
        this.productId = product.getId();
        this.productName = product.getName();
        this.productPrice = product.getPrice().doubleValue();
        this.productDescription = product.getDescription();
        this.pictureId = picture.getId();
        this.pictureUrl = picture.getUrl();
        this.sellId = seller.getId();
        this.sellName = seller.getName();
        this.orderProductId = orderProduct.getId();
        this.sellAmount = orderProduct.getProductNum();
    }
}
