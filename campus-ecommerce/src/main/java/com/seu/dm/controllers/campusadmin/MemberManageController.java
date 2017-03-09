package com.seu.dm.controllers.campusadmin;

import com.seu.dm.annotations.permissions.CampusAdminPermission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Greeting on 2017/3/9.
 * 校区管理员管理会员（买家和卖家）
 */
@Controller("campusadmin/membermanage")
@RequestMapping("campusadmin/membermanage")
public class MemberManageController {
    @RequestMapping("/")
    @CampusAdminPermission
    public String index(){
        return "";
    }
}
