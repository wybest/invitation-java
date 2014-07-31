package com.wndxf.invitation.web;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.wndxf.invitation.GlobleDefine;
import com.wndxf.invitation.persistence.UsersDAO;
import com.wndxf.invitation.persistence.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author wy
 */
@Controller
public class Login {

    @Autowired
    private Producer captchaProducer;

    @Resource
    private UsersDAO usersDAO;

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
                redirectAttributes.addFlashAttribute(GlobleDefine.errorMessage, "用户名或密码错误");
                return "redirect:/loginError";
            }
            session.setAttribute(GlobleDefine.user,users);
        }else{
            redirectAttributes.addFlashAttribute(GlobleDefine.errorMessage, "验证码错误");
            return "redirect:/loginError";
        }
        return "redirect:/user/show";
    }

    @RequestMapping(value = "/loginError", method=RequestMethod.GET)
    public String errorLogin() {
        return "login";
    }

    @RequestMapping(value = "/code", method=RequestMethod.GET)
    public ModelAndView errorLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String code = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = captchaProducer.createText();
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            ImageIO.write(bi, "jpg", out);
            out.flush();
        }catch (Exception e){

        }finally {
            out.close();
        }
        return null;
    }

}
