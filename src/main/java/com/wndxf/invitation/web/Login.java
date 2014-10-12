package com.wndxf.invitation.web;

import com.google.code.kaptcha.Constants;
import com.wndxf.invitation.GlobalDefine;
import com.wndxf.invitation.persistence.UsersDAO;
import com.wndxf.invitation.persistence.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author wy
 */
@Controller
public class Login {

    @Resource
    private UsersDAO usersDAO;

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
            .getLogger(Login.class);

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView("login",null);
    }

    @RequestMapping(value = "/tryLogin", method= RequestMethod.POST)
    public String tryLogin(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("code") String code,RedirectAttributes redirectAttributes,HttpSession session) {
        String sessionCode = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(code.trim().equals(sessionCode)){
            Users users = usersDAO.load(username,password);
            if(users==null){
                redirectAttributes.addFlashAttribute(GlobalDefine.errorMessage, "用户名或密码错误");
                return "redirect:/loginError";
            }
            session.setAttribute(GlobalDefine.user,users);
            usersDAO.touch(users);
        }else{
            redirectAttributes.addFlashAttribute(GlobalDefine.errorMessage, "验证码错误");
            return "redirect:/loginError";
        }
        return "redirect:/user/admin";
    }

    @RequestMapping(value = "/loginError", method=RequestMethod.GET)
    public String errorLogin() {
        return "login";
    }

}
