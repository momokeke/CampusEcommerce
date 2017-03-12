package com.seu.dm.controllers;

import com.seu.dm.annotations.permissions.CampusAdminPermission;
import com.seu.dm.dto.UserBaseDTO;
import com.seu.dm.entities.Product;
import com.seu.dm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 张老师 on 2017/3/2.
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public String addProduct(@RequestBody Product product, Model model){
//
//    }
//
//    /**
//     * 找到所有商品  测试用
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "/findAll")
//    public String findAllProducts( Model model){
//        Product product = ;
//        model.addAttribute("product",product);
//        int i = productService.addProduct(product);
//        System.out.println(product);
//       return "demo/helloworld";
//    }

//    /**
//     * 通过商品名称，社团名称，商品种类，价格以及商品图片向数据库中添加记录
//     * @return
//     */
//    @RequestMapping(value = "/addProduct")
//    public String submitProduct(){
//        return "";
//    }


    /**
     * 根据商品名找到相关信息并用特定实体包装传入model
     * @param name
     * @param model
     * @return
     */
    @RequestMapping(value = "/searchGood",method = RequestMethod.GET)
    public String searchEntityByName(@RequestParam(value = "search")String name,Model model,
                                     HttpSession httpSession){
        List<Product> products = productService.findProductsByName(name);
        System.out.println(products.size());
//        List<SearchGoodEntity> searchGoodEntities = productService.searchEntitiesByName(name);
//        model.addAttribute("entities",searchGoodEntities);
        model.addAttribute("entities",products);
        httpSession.setAttribute("name",name);
        return "product/product_list";
    }

    @RequestMapping(value = "/screenByPrice", method = RequestMethod.GET)
    public String screenByPrice(@RequestParam(value = "minPrice")Double minPrice,
                                @RequestParam(value = "maxPrice")Double maxPrice,Model model,HttpSession httpSession){
        String name = (String) httpSession.getAttribute("name");
        System.out.println("s" + name);
        List<Product> products = productService.findProductsByNameAndScreenByPrice(name,minPrice,maxPrice);
        System.out.println(products.size());
//        httpSession.setAttribute("products",products);
        model.addAttribute("entities",products);
        return "product/product_list";
    }

    /**
     * 根据ID找到指定商品
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/search/{id}")
    public String findProduct(@PathVariable Integer id,Model model){
        Product product =productService.findProduct(id);
        model.addAttribute("product",product);
        System.out.println("OK");
        return "productDetails";
    }

    /**
     * 根据商品名模糊查询找到相关商品列表
     * @param name
     * @param model
     * @return
     */
    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public String findProductsByName(@RequestParam(value = "name")String name,Model model){
        List<Product> products = productService.findProductsByName(name);
        for (Product product : products) {
            System.out.println(product.getName());
        }
        model.addAttribute("products",products);
       // System.out.println("ok");
        return "productDetails";
    }

    /**
     * 根据标签返回对应的商品列表
     * @param category
     * @param model
     * @return
     */
    @RequestMapping(value = "/findByCategory", method = RequestMethod.GET)
    public String findProductsByCategory(@RequestParam(value = "category")String category, Model model){
        List<Product> products = productService.findProductsByCategory(category);
        model.addAttribute("products",products);
        return "";
    }

    /**
     * 根据ID得到商品对应的价格
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/getPrice")
    public String getProductPriceById(@RequestParam(value = "id")Integer id, Model model){
        BigDecimal price = productService.getProductPriceById(id);
        System.out.println(price);
        model.addAttribute("price",price);
        return "productDetails";
    }


    /**
     * 根据商品名得到模糊查询的结果数
     * @param name
     * @param model
     * @return
     */
    @RequestMapping(value = "/getCount")
    public String getCounts(@RequestParam(value = "name")String name, Model model){
        int i = productService.getCountOfResultsByName(name);
        System.out.println("find"+i+"messages");
        return "demo/helloworld";
    }

//    @RequestMapping(value = "/male")
//    public String getMaleCount(Model model){
//        int i = productService.getMaleCount();
//        System.out.println("get "+i+"results");
//        return "/demo/helloworld";
//    }

    /**
     * 添加商品
     * @param product
     * @param model
     * @return
     */
    @RequestMapping(value = "/addProduct")
    @CampusAdminPermission
    public String addProduct(Product product, HttpSession httpSession,Model model){
        Integer sellerId = ((UserBaseDTO)httpSession.getAttribute("userBase")).getSellerId();
        product.setSellerId(sellerId);
        int i = productService.addProduct(product);
        model.addAttribute("product",product);
        return "seller/new_products";
    }


    /**
     * 根据ID删除指定商品
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Integer id, Model model){
        int i = productService.deleteProduct(id);
        return "/";
    }


    /**
     * 更新商品信息
     * @param product
     * @param model
     * @return
     */
    @RequestMapping(value = "updateProduct")
    public String updateProduct(Product product, Model model){
        int i = productService.updateProduct(product);
        if(i == 1) System.out.println("update success");
        System.out.println("update failed");
        return "";
    }


}
