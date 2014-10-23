package com.wndxf.invitation.web.admin;

import com.google.code.kaptcha.Constants;
import com.wndxf.invitation.GlobalDefine;
import com.wndxf.invitation.persistence.BlessingDAO;
import com.wndxf.invitation.persistence.UsersDAO;
import com.wndxf.invitation.persistence.WyPowerDAO;
import com.wndxf.invitation.persistence.model.Blessing;
import com.wndxf.invitation.persistence.model.Users;
import com.wndxf.invitation.persistence.model.WyPower;
import com.wndxf.invitation.web.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wy
 */
@Controller
public class AdminEdit extends Base{

    @Resource
    private UsersDAO usersDAO;

    @Resource
    private WyPowerDAO wyPowerDAO;

    @RequestMapping(value = "/admin")
    public ModelAndView userAdmin(ModelMap modelMap) {
        modelMap.put("menu","open");
        return new ModelAndView("admin/open",modelMap);
    }
}
