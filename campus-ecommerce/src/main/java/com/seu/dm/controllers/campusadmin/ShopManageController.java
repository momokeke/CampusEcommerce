package com.seu.dm.controllers.campusadmin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seu.dm.annotations.permissions.CampusAdminPermission;
import com.seu.dm.dto.UserBaseDTO;
import com.seu.dm.entities.Product;
import com.seu.dm.entities.SchoolAdmin;
import com.seu.dm.entities.Seller;
import com.seu.dm.helpers.PageGenerateHelper;
import com.seu.dm.services.ProductService;
import com.seu.dm.services.SchoolAdminService;
import com.seu.dm.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * 校区管理员管理店铺
 */
@Controller("/campusadmin/shopmanage")
@RequestMapping(value="/campusadmin/shopmanage")
public class ShopManageController {
    @Autowired
    private SellerService sellerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SchoolAdminService schoolAdminService;


    @RequestMapping("/")
    @CampusAdminPermission
    public String index(HttpServletRequest request,
                        @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                        HttpSession httpSession,Model model){

        Integer schoolAdminId = ((UserBaseDTO)httpSession.getAttribute("userBase")).getId();
        SchoolAdmin schoolAdmin = schoolAdminService.findAdmin(schoolAdminId);
        PageHelper.startPage(pageNum,10);
        List<Seller> sellers = sellerService.findAllSellers(schoolAdmin.getCampusId());
        PageInfo pageInfo = new PageInfo(sellers);
        PageGenerateHelper.generatePage(request,model,pageInfo);
        model.addAttribute("sellers",sellers);
        return "admin/campusadmin/shop/manage";
    }

//    @RequestMapping("/{id}")
//    @CampusAdminPermission
//    public String indexWithAdminId(@PathVariable Integer id, Model model){
//        SchoolAdmin schoolAdmin = schoolAdminService.findAdmin(id);
//        if(schoolAdmin == null) System.out.println("s");
//        List<Seller> sellers = sellerService.findAllSellers(schoolAdmin.getSchoolId());
//
//        model.addAttribute("sellers",sellers);
//        return "admin/campusadmin/shop/manage";
//    }

    @RequestMapping("/editshop/{id}")
    @CampusAdminPermission
    public String editShop(@PathVariable Integer id, Model model){
        Seller seller = sellerService.findSeller(id);
        model.addAttribute("seller",seller);
        Integer sellerId = seller.getId();
        List<Product> products = productService.findProductsBySellerId(sellerId);
        System.out.println(products.size());
        model.addAttribute("products",products);
        return "admin/campusadmin/shop/edit_shop";
    }

    @RequestMapping("/editshop/updateshopname/{sellerId}")
    @CampusAdminPermission
    public String updateShopName(@PathVariable Integer sellerId,
                                 @RequestParam(value = "shopName")String shopName,
                                 HttpServletRequest request){
        Seller seller = sellerService.findSeller(sellerId);
        seller.setShopName(shopName);
        sellerService.updateSeller(seller);
        return "redirect:/campusadmin/shopmanage/";
    }
    @RequestMapping("/unshelfproduct/{sellerId}/{productId}")
    @CampusAdminPermission
    public String unshelfProduct(@PathVariable Integer sellerId, @PathVariable Integer productId,
                                 Model model, HttpServletRequest request){
        int i = productService.unshelfProduct(productId);
        return "redirect:/campusadmin/shopmanage/editshop/"+sellerId;
    }

    @RequestMapping("/deleteproduct/{sellerId}/{productId}")
    @CampusAdminPermission
    public String deleteProduct(@PathVariable Integer sellerId,@PathVariable Integer productId,
                                HttpServletRequest request){
        int i = productService.deleteProduct(productId);
        return "redirect:/campusadmin/shopmanage/editshop/"+sellerId;
    }

    @RequestMapping(value = "/banshop/{sellerId}")
    @CampusAdminPermission
    public String banShop(@PathVariable Integer sellerId, HttpServletRequest request, HttpSession httpSession){
        int i = sellerService.banSeller(sellerId);
        Integer schoolAdminId = ((UserBaseDTO)httpSession.getAttribute("userBase")).getId();
        System.out.println(((UserBaseDTO)httpSession.getAttribute("userBase")).getId());
        return "redirect:/campusadmin/shopmanage/";
    }

    @RequestMapping(value = "/unbanshop/{sellerId}")
    @CampusAdminPermission
    public String unBanShop(@PathVariable Integer sellerId, HttpServletRequest request, HttpSession httpSession){
        int i = sellerService.unBanSeller(sellerId);
        Integer schoolAdminId = ((UserBaseDTO)httpSession.getAttribute("userBase")).getId();
        return "redirect:/campusadmin/shopmanage/";
    }

    @RequestMapping(value = "/deleteshop/{sellerId}")
    @CampusAdminPermission
    public String deleteShop(@PathVariable Integer sellerId, HttpServletRequest request, HttpSession httpSession){
        int i = sellerService.deleteSeller(sellerId);
        return "redirect:/campusadmin/shopmanage/";
    }
}
