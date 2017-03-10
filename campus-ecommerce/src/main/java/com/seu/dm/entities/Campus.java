package com.seu.dm.entities;

/**
 * Created by 张老师 on 2017/3/9.
 */
public class Campus {
    private Integer id;
    private String name;
    private Integer schoolAdminId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSchoolAdminId() {
        return schoolAdminId;
    }

    public void setSchoolAdminId(Integer schoolAdminId) {
        this.schoolAdminId = schoolAdminId;
    }
}
