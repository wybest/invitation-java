package com.wndxf.invitation.web.user;

import com.google.code.kaptcha.Constants;
import com.wndxf.invitation.GlobleDefine;
import com.wndxf.invitation.persistence.UsersDAO;
import com.wndxf.invitation.persistence.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author wy
 */
@Controller
public class UserEdit {

    @Resource
    private UsersDAO usersDAO;

    @RequestMapping(value = "/user/show", method= RequestMethod.GET)
    public ModelAndView userShow(ModelMap modelMap) {
        return new ModelAndView("user/user_admin",modelMap);
    }

    @RequestMapping(value = "regist", method= RequestMethod.POST)
    public String userRegist(@ModelAttribute("userRegist")Users user,@RequestParam("code") String code,RedirectAttributes redirectAttributes,HttpSession session) {
        String sessionCode = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(code.trim().equals(sessionCode)){
            Users users = usersDAO.load(user.getUsername(),user.getPassword());
            if(users==null){
                user.setLastTime(new Date());
                user.setIsPay(0);
                usersDAO.insert(user);
                redirectAttributes.addFlashAttribute(GlobleDefine.message, user.getUsername()+" 注册成功");
                return "redirect:/login";
            }else {
                redirectAttributes.addFlashAttribute(GlobleDefine.errorMessage, user.getUsername()+" 用户已经存在，重新注册");
                return "redirect:/loginError";
            }
        }else{
            redirectAttributes.addFlashAttribute(GlobleDefine.errorMessage, "验证码填写错误,重新注册");
            return "redirect:/loginError";
        }
    }
}
