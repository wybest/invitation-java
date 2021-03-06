package com.wndxf.invitation.web.user;

import com.google.code.kaptcha.Constants;
import com.wndxf.invitation.GlobalDefine;
import com.wndxf.invitation.persistence.BlessingDAO;
import com.wndxf.invitation.persistence.UsersDAO;
import com.wndxf.invitation.persistence.model.Blessing;
import com.wndxf.invitation.persistence.model.Users;
import com.wndxf.invitation.web.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wy
 */
@Controller
public class UserEdit extends Base{

    @Resource
    private UsersDAO usersDAO;

    @Autowired
    private BlessingDAO blessingDAO;

    @RequestMapping(value = "/user/admin")
    public ModelAndView userAdmin(ModelMap modelMap) {
        modelMap.put("menu","home");
        return new ModelAndView("user/home",modelMap);
    }

    @RequestMapping(value = "/user/edit", method= RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> userEdit(@ModelAttribute Users user,HttpSession session) {
        Map<String, Object> returnMap = new HashMap<>();
        user.setId(getUserId(session));
        int num = usersDAO.update(user);
        if(num>0){
            returnMap.put(GlobalDefine.MESSAGE, "发送成功");
        }else{
            returnMap.put(GlobalDefine.ERROR, "您页面有错误!");
        }
        return returnMap;
    }

    @RequestMapping(value = "/user/show", method= RequestMethod.GET)
    public ModelAndView userShow(@RequestParam(value = "template")String template,ModelMap modelMap,HttpSession session) {
        modelMap.put("menu",template);
        if(template.equals("blessing")){
            Blessing bs = new Blessing();
            bs.setUserId(getUserId(session));
            List<Blessing> blessings = blessingDAO.query(bs);
            modelMap.put("blesses",blessings);
        }
        return new ModelAndView("user/"+template,modelMap);//edit_slid edit_background edit_background  edit_images
    }

    @RequestMapping(value = "/regist", method= RequestMethod.POST)
    public String userRegist(@ModelAttribute("userRegist")Users user,@RequestParam("code") String code,RedirectAttributes redirectAttributes,HttpSession session) {
        String sessionCode = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(code.trim().equals(sessionCode)){
            Users users = usersDAO.loadByName(user.getUsername());
            if(users==null){
                int num = usersDAO.insert(user);
                if(num>0){
                    redirectAttributes.addFlashAttribute(GlobalDefine.message, user.getUsername()+" 注册成功");
                }else{
                    redirectAttributes.addFlashAttribute(GlobalDefine.message, user.getUsername()+" 注册失败");
                }
                return "redirect:/login";
            }else {
                redirectAttributes.addFlashAttribute(GlobalDefine.errorMessage, user.getUsername()+" 用户已经存在，重新注册");
                return "redirect:/loginError";
            }
        }else{
            redirectAttributes.addFlashAttribute(GlobalDefine.errorMessage, "验证码填写错误,重新注册");
            return "redirect:/loginError";
        }
    }
}
