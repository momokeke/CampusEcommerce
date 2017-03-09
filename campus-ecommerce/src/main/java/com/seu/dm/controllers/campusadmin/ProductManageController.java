package com.seu.dm.controllers.campusadmin;

import com.seu.dm.annotations.permissions.CampusAdminPermission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Greeting on 2017/3/9.
 * 校区管理员管理商品
 */
@Controller("/campusadmin/productmanage")
@RequestMapping(value="/campusadmin/productmanage")
public class ProductManageController {
    @RequestMapping("/")
    @CampusAdminPermission
    public String index(){
        return "admin/campusadmin/product/manage";
    }
}
