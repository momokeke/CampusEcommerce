package com.seu.dm.controllers.campusadmin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seu.dm.annotations.permissions.CampusAdminPermission;
import com.seu.dm.dto.UserBaseDTO;
import com.seu.dm.entities.Buyer;
import com.seu.dm.entities.Order;
import com.seu.dm.helpers.PageGenerateHelper;
import com.seu.dm.services.BuyerService;
import com.seu.dm.services.OrderService;
import com.seu.dm.services.SchoolAdminService;
import com.seu.dm.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Greeting on 2017/3/9.
 * 校区管理员管理订单
 * 订单状态，1：待发货，2：已发货 ，3：退货中，4：已退货，5：已完成
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
    public String index(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                        @RequestParam(required = false) Integer status,
                        @RequestParam(required = false) Integer id,
                        HttpSession httpSession,
                        HttpServletRequest request,
                        Model model){
        Integer schoolAdminId = ((UserBaseDTO)httpSession.getAttribute("userBase")).getId();
        Integer campusId = schoolAdminService.findAdmin(schoolAdminId).getCampusId();
        Order order = new Order();
        order.setCampusId(campusId);
        order.setStatus(status);
        order.setId(id);
        PageHelper.startPage(pageNum,10);
        List<Order> orders = orderService.findOrders(order);
        PageInfo pageInfo = new PageInfo(orders);
        PageGenerateHelper.generatePage(request,model,pageInfo);

        order.setStatus(1);
        Integer stayCount = orderService.getCount(order);
        order.setStatus(2);
        Integer sentCount = orderService.getCount(order);
        order.setStatus(3);
        Integer backCount = orderService.getCount(order);
        order.setStatus(4);
        Integer backFinishCount = orderService.getCount(order);
        order.setStatus(5);
        Integer normalFinishCount = orderService.getCount(order);
        model.addAttribute("stayCount",stayCount);
        model.addAttribute("sentCount",sentCount);
        model.addAttribute("backCount",backCount);
        model.addAttribute("finishCount",backFinishCount.intValue() + normalFinishCount.intValue());
        model.addAttribute("totalCount",sentCount.intValue() + stayCount+backCount.intValue() + backFinishCount.intValue() + normalFinishCount.intValue());
        model.addAttribute("orders",orders);
        return "admin/campusadmin/order/manage";
    }

    @RequestMapping("/changeStatus/{id}/{action}")
    @CampusAdminPermission
    public String changeStatus(@PathVariable Integer id,@PathVariable String action, Model model){
        String message = null;
        Integer status = null;
        if(action.equals("send")){
            status = 2;
            message = "该货单已发货";
        }else if(action.equals("back")){
            status = 3;
            message = "该货单退货中";
        }else if(action.equals("finishBack")){
            status = 4;
            message = "该货单退货完成";
        }else if(action.equals("finish")){
            status = 5;
            message = "该货单完成";
        }else if(action.equals("cancelBack")){
            status = 2;
            message = "该货单的退货被撤销，回到已发货状态";
        }else if(action.equals("recover")){
            status = 1;
            message = "该货单状态回到未发货";
        }
        Order order = new Order();
        order.setId(id);
        order.setStatus(status);
        orderService.updateOrder(order);
        model.addAttribute("message",message);
        model.addAttribute("jumpUrl","/campusadmin/ordermanage/");
        return "common/alert";
    }


}
