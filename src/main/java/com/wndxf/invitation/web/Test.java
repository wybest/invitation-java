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
public class Test {

    @Resource
    private UsersDAO usersDAO;

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
            .getLogger(Test.class);

    @RequestMapping(value = "/test")
    public ModelAndView login() {
        System.out.print(GlobalDefine.getImagePath());
        return new ModelAndView("login",null);
    }

}
