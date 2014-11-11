package com.wndxf.invitation.web;

import com.google.code.kaptcha.Constants;
import com.wndxf.invitation.GlobalDefine;
import com.wndxf.invitation.persistence.UsersDAO;
import com.wndxf.invitation.persistence.WyPowerDAO;
import com.wndxf.invitation.persistence.model.WyPower;
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
public class AdminLogin extends Base{
    @Resource
    private WyPowerDAO wyPowerDAO;

    @RequestMapping(value = "/admin_tryLogin", method= RequestMethod.POST)
    public String tryLogin(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("code") String code,RedirectAttributes redirectAttributes,HttpSession session) {
        String sessionCode = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(code.trim().equals(sessionCode)){
            WyPower wyPower = wyPowerDAO.load(username,password);
            if(wyPower==null){
                redirectAttributes.addFlashAttribute(GlobalDefine.errorMessage, "用户名或密码错误");
                return "redirect:/admin_login";
            }
            session.setAttribute(GlobalDefine.admin, wyPower);
        }else{
            redirectAttributes.addFlashAttribute(GlobalDefine.errorMessage, "验证码错误");
            return "redirect:/admin_login";
        }
        return "redirect:/admin/open";
    }

    @RequestMapping(value = "/admin_login", method=RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("admin_login");
    }
}
