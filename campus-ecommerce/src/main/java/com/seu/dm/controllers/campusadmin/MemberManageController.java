package com.seu.dm.controllers.campusadmin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seu.dm.annotations.permissions.CampusAdminPermission;
import com.seu.dm.dto.UserBaseDTO;
import com.seu.dm.entities.Buyer;
import com.seu.dm.entities.Order;
import com.seu.dm.entities.SchoolAdmin;
import com.seu.dm.entities.Seller;
import com.seu.dm.helpers.PageGenerateHelper;
import com.seu.dm.services.BuyerService;
import com.seu.dm.services.SchoolAdminService;
import com.seu.dm.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Greeting on 2017/3/9.
 * 校区管理员管理会员（买家和卖家）
 */
@Controller("campusadmin/membermanage")
@RequestMapping("campusadmin/membermanage")
public class MemberManageController {
    @Autowired
    private SchoolAdminService schoolAdminService;
    @Autowired
    private BuyerService buyerService;
    @Autowired
    private SellerService sellerService;

    @RequestMapping("/")
    @CampusAdminPermission
    public String index(
            @RequestParam(required = false,defaultValue = "1") Integer pageNum,
            HttpSession httpSession,Model model){
        Integer schoolAdminId = ((UserBaseDTO)httpSession.getAttribute("userBase")).getId();
        SchoolAdmin schoolAdmin = schoolAdminService.findAdmin(schoolAdminId);
        Integer campusId = schoolAdmin.getCampusId();
        List<Buyer> buyers = buyerService.findBuyersByCampusId(campusId);
        List<Seller> sellers = sellerService.findAllSellers(schoolAdmin.getCampusId());
        model.addAttribute("schoolAdmin",schoolAdmin);
        model.addAttribute("buyers",buyers);
        model.addAttribute("sellers",sellers);
        return "admin/campusadmin/member/manage";

    }

    @RequestMapping("/buyer")
    @CampusAdminPermission
    public String buyer(
            HttpServletRequest request,
            @RequestParam(required = false,defaultValue = "1") Integer pageNum,
            HttpSession httpSession,Model model){
        Integer schoolAdminId = ((UserBaseDTO)httpSession.getAttribute("userBase")).getId();
        SchoolAdmin schoolAdmin = schoolAdminService.findAdmin(schoolAdminId);
        Integer campusId = schoolAdmin.getCampusId();
        PageHelper.startPage(pageNum,10);
        List<Buyer> buyers = buyerService.findBuyersByCampusId(campusId);
        PageInfo pageInfo = new PageInfo(buyers);
        PageGenerateHelper.generatePage(request,model,pageInfo);
        model.addAttribute("schoolAdmin",schoolAdmin);
        model.addAttribute("buyers",buyers);
        return "admin/campusadmin/member/buyer";
    }

    @RequestMapping("/seller")
    @CampusAdminPermission
    public String seller(
            HttpServletRequest request,
            @RequestParam(required = false,defaultValue = "1") Integer pageNum,
            HttpSession httpSession,Model model){
        Integer schoolAdminId = ((UserBaseDTO)httpSession.getAttribute("userBase")).getId();
        SchoolAdmin schoolAdmin = schoolAdminService.findAdmin(schoolAdminId);
        Integer campusId = schoolAdmin.getCampusId();
        PageHelper.startPage(pageNum,10);
        List<Seller> sellers = sellerService.findAllSellers(campusId);
        PageInfo pageInfo = new PageInfo(sellers);
        PageGenerateHelper.generatePage(request,model,pageInfo);
        model.addAttribute("schoolAdmin",schoolAdmin);
        model.addAttribute("sellers",sellers);
        return "admin/campusadmin/member/seller";
    }

//    @RequestMapping("/{id}")
//    @CampusAdminPermission
//    public String indexWithAdminId(@PathVariable Integer Id,Model model){
//        SchoolAdmin schoolAdmin = schoolAdminService.findAdmin(Id);
//        Integer campusId = schoolAdmin.getSchoolId();
//        List<Buyer> buyers = buyerService.findBuyersByCampusId(campusId);
//        List<Seller> sellers = sellerService.findAllSellers(schoolAdmin.getSchoolId());
//        model.addAttribute("schoolAdmin",schoolAdmin);
//        model.addAttribute("buyers",buyers);
//        model.addAttribute("sellers",sellers);
//        return "admin/campusadmin/member/manage";
//    }

    @RequestMapping(value = "/banbuyer/{schoolAdminId}/{buyerId}")
    @CampusAdminPermission
    public String banBuyer(@PathVariable Integer schoolAdminId, @PathVariable Integer buyerId,
                           HttpServletRequest request){
        int i = buyerService.banBuyer(buyerId);
        return "redirect:/campusadmin/membermanage/";
    }

    @RequestMapping(value = "/unbanbuyer/{schoolAdminId}/{buyerId}")
    @CampusAdminPermission
    public String unBanBuyer(@PathVariable Integer schoolAdminId, @PathVariable Integer buyerId,
                           HttpServletRequest request){
        int i = buyerService.unBanBuyer(buyerId);
        return "redirect:/campusadmin/membermanage/";
    }

    @RequestMapping(value = "/deletebuyer/{schoolAdminId}/{buyerId}")
    @CampusAdminPermission
    public String deleteBuyer(@PathVariable Integer schoolAdminId, @PathVariable Integer buyerId,
                             HttpServletRequest request){
        int i = buyerService.deleteBuyer(buyerId);
        return "redirect:/campusadmin/membermanage/";
    }

    @RequestMapping(value = "/banseller/{schoolAdminId}/{sellerId}")
    @CampusAdminPermission
    public String banSeller(@PathVariable Integer schoolAdminId, @PathVariable Integer sellerId,
                           HttpServletRequest request){
        int i = sellerService.banSeller(sellerId);
        return "redirect:/campusadmin/membermanage/";
    }

    @RequestMapping(value = "/unbanseller/{schoolAdminId}/{sellerId}")
    @CampusAdminPermission
    public String unBanSeller(@PathVariable Integer schoolAdminId, @PathVariable Integer sellerId,
                             HttpServletRequest request){
        int i = sellerService.unBanSeller(sellerId);
        return "redirect:/campusadmin/membermanage/";
    }

    @RequestMapping(value = "/deleteseller/{schoolAdminId}/{sellerId}")
    @CampusAdminPermission
    public String deleteSeller(@PathVariable Integer schoolAdminId, @PathVariable Integer sellerId,
                              HttpServletRequest request){
        int i = sellerService.deleteSeller(sellerId);
        return "redirect:/campusadmin/membermanage/";
    }
}
