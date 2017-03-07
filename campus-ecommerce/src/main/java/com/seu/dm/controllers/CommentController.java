package com.seu.dm.controllers;

import com.seu.dm.entities.Comment;
import com.seu.dm.entities.Seller;
import com.seu.dm.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by 张老师 on 2017/3/7.
 */
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
//
//    @RequestMapping(value = "/getCommentsByProductId")
//    public String getCommentsByProductId(@PathVariable Integer id, Model model){
//        List<Comment> comments = commentService.getCommentByProductId(id);
//        for (Comment comment : comments) {
//            Seller seller = ;
//
//
//        }

//        List<Comment> comments = commentService.getCommentByProductId(id);
//        for(Comment comment : comments){
//            Seller seller = SellerService.getSellerById(comment.getSellerId);
//            comment.setSeller(seller);
//        }
//        model.addAttribute("comments",comments);







//
//        return "";
//    }
}
