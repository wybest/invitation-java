package com.wndxf.invitation.inteceptor;

import com.wndxf.invitation.GlobalDefine;
import com.wndxf.invitation.persistence.UsersDAO;
import com.wndxf.invitation.persistence.WyPowerDAO;
import com.wndxf.invitation.persistence.model.Users;
import com.wndxf.invitation.persistence.model.WyPower;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author wy
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private WyPowerDAO wyPowerDAO;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        WyPower wyPower = (WyPower) session.getAttribute(GlobalDefine.admin);
        if(wyPower==null){
            request.getRequestDispatcher("/admin_login?"+ GlobalDefine.errorMessage+"您未登陆").forward(request,response);
            return false;
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HttpSession session = request.getSession();
        WyPower wyPower = (WyPower) session.getAttribute(GlobalDefine.admin);
        modelAndView.getModelMap().put("admin",wyPower);
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
