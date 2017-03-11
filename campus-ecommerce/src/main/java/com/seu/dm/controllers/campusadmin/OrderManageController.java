package com.seu.dm.controllers.campusadmin;

import com.seu.dm.annotations.permissions.CampusAdminPermission;
import com.seu.dm.dto.UserBaseDTO;
import com.seu.dm.entities.Order;
import com.seu.dm.services.OrderService;
import com.seu.dm.services.SchoolAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Greeting on 2017/3/9.
 * 校区管理员管理订单
 */
@Controller("/campusadmin/ordermanage")
@RequestMapping(value="/campusadmin/ordermanage")
public class OrderManageController {
    @Autowired
    private SchoolAdminService schoolAdminService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/")
    @CampusAdminPermission
    public String index(HttpSession httpSession, Model model){
        Integer schoolAdminId = ((UserBaseDTO)httpSession.getAttribute("userBase")).getId();
        Integer campusId = schoolAdminService.findAdmin(schoolAdminId).getCampusId();
        List<Order> orders = orderService.findOrdersByCampusId(campusId);
        model.addAttribute("orders",orders);
        return "admin/campusadmin/order/manage";
    }

    @RequestMapping("/screen")
    @CampusAdminPermission
    public String screenOrders(@RequestParam(value = "orderId")Integer orderId, @RequestParam(value = "orderStatus")String orderStatus,
                               @RequestParam(value = "userId")Integer userId, @RequestParam(value = "sellerId")Integer sellerId
                               ,HttpSession httpSession,Model model, HttpServletRequest request){
        Integer schoolAdminId = ((UserBaseDTO)httpSession.getAttribute("userBase")).getId();
        Integer campusId = schoolAdminService.findAdmin(schoolAdminId).getCampusId();
        System.out.println(orderStatus);
        System.out.println("id: "+orderId+"   orderStatus: "+orderStatus);
        List<Order> orders = orderService.screenOrders(orderId,orderStatus,campusId);
        model.addAttribute("orders",orders);
        return "redirect:/campusadmin/ordermanage";
    }
}
