package com.seu.dm.dto;

/**
 * Created by Greeting on 2017/3/9.
 */
public class UserBaseDTO {
    private String role;

    private Integer id;

    public Integer getCampusId() {
        return campusId;
    }

    public void setCampusId(Integer campusId) {
        this.campusId = campusId;
    }

    private Integer campusId;



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
}
