package com.wndxf.invitation.inteceptor;

import com.wndxf.invitation.GlobalDefine;
import com.wndxf.invitation.persistence.UsersDAO;
import com.wndxf.invitation.persistence.model.Users;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;

/**
 * @author wy
 */
public class UserInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private UsersDAO usersDAO;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute(GlobalDefine.user);
        if(user==null){
            request.getRequestDispatcher("/loginError?"+ GlobalDefine.errorMessage+"您未登陆").forward(request,response);
            return false;
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Users user = (Users) request.getSession().getAttribute(GlobalDefine.user);
        user = usersDAO.load(user.getUsername(),user.getPassword());
        modelAndView.getModelMap().put("user",user);
        if(StringUtils.isNotEmpty(user.getBackground())){
            String[] images = user.getBackground().split(",");
            modelAndView.getModelMap().put("image1",images[0]);
            modelAndView.getModelMap().put("image2",images[1]);
            modelAndView.getModelMap().put("image3",images[2]);
            modelAndView.getModelMap().put("image4",images[3]);
        }
        if(StringUtils.isNotEmpty(user.getImage())){
            modelAndView.getModelMap().put("bigImages",user.getImage().split(","));
        }
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
