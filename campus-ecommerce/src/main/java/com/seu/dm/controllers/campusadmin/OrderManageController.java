package com.seu.dm.controllers.campusadmin;

import com.seu.dm.annotations.permissions.CampusAdminPermission;
import com.seu.dm.dto.UserBaseDTO;
import com.seu.dm.entities.Buyer;
import com.seu.dm.entities.Order;
import com.seu.dm.services.BuyerService;
import com.seu.dm.services.OrderService;
import com.seu.dm.services.SchoolAdminService;
import com.seu.dm.services.SellerService;
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
    @Autowired
    private SellerService sellerService;
    @Autowired
    private BuyerService buyerService;

    @RequestMapping("/")
    @CampusAdminPermission
    public String index(HttpSession httpSession, Model model){
        Integer schoolAdminId = ((UserBaseDTO)httpSession.getAttribute("userBase")).getId();
        Integer campusId = schoolAdminService.findAdmin(schoolAdminId).getCampusId();
        List<Order> orders = orderService.findOrdersByCampusId(campusId);
        Integer stayCount = orderService.getCountByStatus(1);
        Integer backCount = orderService.getCountByStatus(2);
        Integer backFinishCount = orderService.getCountByStatus(3);
        Integer normalFinishCount = orderService.getCountByStatus(4);
        model.addAttribute("stayCount",stayCount);
        model.addAttribute("backCount",backCount);
        model.addAttribute("finishCount",backFinishCount.intValue() + normalFinishCount.intValue());
        model.addAttribute("totalCount",stayCount+backCount.intValue()+backFinishCount.intValue()+normalFinishCount.intValue());

        model.addAttribute("orders",orders);
        return "admin/campusadmin/order/manage";
    }

    @RequestMapping("/screen")
    @CampusAdminPermission
    public String screenOrders(@RequestParam(value = "orderId")Integer orderId, @RequestParam(value = "orderStatus")Integer orderStatus,
                               @RequestParam(value = "userId")Integer userId, @RequestParam(value = "sellerId")Integer sellerId
                               ,HttpSession httpSession,Model model, HttpServletRequest request){

        Integer schoolAdminId = ((UserBaseDTO)httpSession.getAttribute("userBase")).getId();
        Integer campusId = schoolAdminService.findAdmin(schoolAdminId).getCampusId();
        List<Order> orders = orderService.screenOrders(orderId,orderStatus,campusId);
        System.out.println(orders);
        for(Order order : orders){
            System.out.println(buyerService.findBuyer(order.getUserId()));
            System.out.println(sellerService.findSeller(order.getSellerId()));
            order.setBuyer(buyerService.findBuyer(order.getUserId()));
            order.setSeller(sellerService.findSeller(order.getSellerId()));
        }

        for(Order order : orders){
            Buyer buyer = order.getBuyer();
            System.out.println(buyer);
        }

        model.addAttribute("orders",orders);
        return "redirect:/campusadmin/ordermanage";
    }
}
