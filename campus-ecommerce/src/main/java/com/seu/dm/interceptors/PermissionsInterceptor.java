package com.seu.dm.interceptors;

import com.seu.dm.annotations.permissions.BuyerPermission;
import com.seu.dm.annotations.permissions.CampusAdminPermission;
import com.seu.dm.annotations.permissions.SellerPermission;
import com.seu.dm.annotations.permissions.SuperAdminPermission;
import com.seu.dm.dto.UserBaseDTO;
import com.seu.dm.entities.Seller;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * Created by Greeting on 2017/3/9.
 * 检查用户权限的拦截器
 */
public class PermissionsInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {



        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        return forTesting(request,method);
        /*
        if(method.getAnnotation(SuperAdminPermission.class)!=null){
            return verifySuperAdmin(request,response);
        }
        if(method.getAnnotation(CampusAdminPermission.class)!=null){
            return verifyCampusAdmin(request,response);
        }
        if(method.getAnnotation(SellerPermission.class)!=null){
            return verifySeller(request,response);
        }
        if(method.getAnnotation(BuyerPermission.class)!=null){
            return verifyBuyer(request,response);
        }


        return forTesting(request);

        //return true;
        */
    }

    private boolean forTesting(HttpServletRequest request,Method method){
        if(method.getAnnotation(SuperAdminPermission.class)!=null){
            HttpSession httpSession = request.getSession();
            UserBaseDTO userBase = new UserBaseDTO();
            userBase.setRole("superAdmin");
            httpSession.setAttribute("userBase",userBase);
        }
        if(method.getAnnotation(CampusAdminPermission.class)!=null){
            HttpSession httpSession = request.getSession();
            UserBaseDTO userBase = new UserBaseDTO();
            userBase.setRole("campusAdmin");
            userBase.setId(110);
            userBase.setSellerId(10);
            userBase.setCampusId(4);
            httpSession.setAttribute("userBase",userBase);
        }
        if(method.getAnnotation(SellerPermission.class)!=null){
            HttpSession session = request.getSession();
            UserBaseDTO userBase = new UserBaseDTO();
            userBase.setSellerId(10);
        }
        return true;
    }




    private boolean verifySuperAdmin(HttpServletRequest request,HttpServletResponse response){
        //response.sendRedirect("/");
        return true;
    }

    private boolean verifyCampusAdmin(HttpServletRequest request,HttpServletResponse response){
        return true;
    }

    private boolean verifySeller(HttpServletRequest request,HttpServletResponse response){
        return true;
    }

    private boolean verifyBuyer(HttpServletRequest request,HttpServletResponse response){
        return true;
    }


}
