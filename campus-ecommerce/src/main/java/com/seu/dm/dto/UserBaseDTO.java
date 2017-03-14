package com.seu.dm.dto;

/**
 * Created by Greeting on 2017/3/9.
 */
public class UserBaseDTO {
    private String role;

    private Integer id;

    private Boolean isLogin;

    private String CampusName;

    public String getCampusName() {
        return CampusName;
    }

    public void setCampusName(String campusName) {
        CampusName = campusName;
    }

    public Integer getCampusId() {
        return campusId;
    }

    public void setCampusId(Integer campusId) {
        this.campusId = campusId;
    }

    private Integer campusId;

    private Integer sellerId;

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getLogin() {
        return isLogin;
    }

    public void setLogin(Boolean login) {
        isLogin = login;
    }
}
