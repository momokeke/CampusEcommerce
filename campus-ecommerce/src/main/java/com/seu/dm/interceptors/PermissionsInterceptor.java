package com.seu.dm.interceptors;

import com.seu.dm.annotations.permissions.BuyerPermission;
import com.seu.dm.annotations.permissions.CampusAdminPermission;
import com.seu.dm.annotations.permissions.SellerPermission;
import com.seu.dm.annotations.permissions.SuperAdminPermission;
import com.seu.dm.dto.UserBaseDTO;
import com.seu.dm.entities.Campus;
import com.seu.dm.entities.Seller;
import com.seu.dm.serviceimpls.CampusServiceImpl;
import com.seu.dm.services.CampusService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Greeting on 2017/3/9.
 * 检查用户权限的拦截器
 */
public class PermissionsInterceptor extends HandlerInterceptorAdapter {




    @Autowired
    private CampusService campusService;


    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //return forTesting(request,method);
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




        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);


        if (campusService == null) {//解决service为null无法注入问题
            System.out.println("campusService is null!!!");
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            campusService = (CampusService) factory.getBean("campusServiceImpl");
        }

        List<Campus> campuses = campusService.findAllCampuses();
        request.setAttribute("campuses",campuses);
        HttpSession httpSession = request.getSession();
        Integer campusId = (Integer)httpSession.getAttribute("campusId");
        if(campusId == null){
            //有时间的话就换
            campusId = 1;
            httpSession.setAttribute("campusId",1);
        }
        request.setAttribute("campusId",campusId);





    }

    private boolean forTesting(HttpServletRequest request, Method method){
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
            userBase.setCampusName("东南大学苏州校区");
            httpSession.setAttribute("userBase",userBase);
        }
        if(method.getAnnotation(SellerPermission.class)!=null){
            HttpSession session = request.getSession();
            UserBaseDTO userBase = new UserBaseDTO();
            userBase.setSellerId(10);
        }
        return true;
    }




    private boolean verifySuperAdmin(HttpServletRequest request,HttpServletResponse response) throws IOException{
        HttpSession httpSession = request.getSession();
        UserBaseDTO userBase = (UserBaseDTO)httpSession.getAttribute("userBase");
        if(userBase == null){
            response.sendRedirect("/superadmin/login/");
            return false;
        }else if(!"superAdmin".equals(userBase.getRole())){
            response.sendRedirect("/superadmin/login/");
            return false;
        }
        return true;
    }

    private boolean verifyCampusAdmin(HttpServletRequest request,HttpServletResponse response) throws IOException{
        HttpSession httpSession = request.getSession();
        UserBaseDTO userBase = (UserBaseDTO)httpSession.getAttribute("userBase");
        if(userBase == null){
            response.sendRedirect("/campusadmin/login/");
            return false;
        }else if(!"campusAdmin".equals(userBase.getRole())){
            response.sendRedirect("/campusadmin/login/");
            return false;
        }
        return true;
    }

    private boolean verifySeller(HttpServletRequest request,HttpServletResponse response) throws IOException{
        HttpSession httpSession = request.getSession();
        UserBaseDTO userBase = (UserBaseDTO)httpSession.getAttribute("userBase");
        if(userBase == null){
            response.sendRedirect("/notlogin/xxx");
            return false;
        }else if(!"seller".equals(userBase.getRole())){
            response.sendRedirect("/notlogin/xxx");
            return false;
        }
        return true;
    }

    private boolean verifyBuyer(HttpServletRequest request,HttpServletResponse response) throws IOException{
        HttpSession httpSession = request.getSession();
        UserBaseDTO userBase = (UserBaseDTO)httpSession.getAttribute("userBase");
        if(userBase == null){
            response.sendRedirect("/notlogin/xxx");
            return false;
        }else if(!"buyer".equals(userBase.getRole())){
            response.sendRedirect("/notlogin/xxx");
            return false;
        }
        return true;
    }


}
