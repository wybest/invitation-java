package com.wndxf.invitation.web.admin;

import com.wndxf.invitation.GlobalDefine;
import com.wndxf.invitation.persistence.UsersDAO;
import com.wndxf.invitation.persistence.WyPowerDAO;
import com.wndxf.invitation.persistence.model.Users;
import com.wndxf.invitation.persistence.model.WyPower;
import com.wndxf.invitation.web.Base;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author wy
 */
@Controller
public class AdminEdit extends Base{

    @Resource
    private UsersDAO usersDAO;

    @Resource
    private WyPowerDAO wyPowerDAO;

    @RequestMapping(value = "/admin/open")
    public ModelAndView userAdmin(ModelMap modelMap) {
        modelMap.put("menu","open");
        return new ModelAndView("admin/open",modelMap);
    }

    @RequestMapping(value = "/admin/doOpen")
    public ModelAndView doOpen(@RequestParam("username") String name,HttpSession session,ModelMap modelMap) {
        WyPower wyPower = (WyPower) session.getAttribute(GlobalDefine.admin);
        Users users = new Users();
        users.setIsPay(1);
        users.setAdminId(wyPower.getId());
        int count = usersDAO.open(users);
        if(count>0){
            modelMap.put(GlobalDefine.message,"开通成功："+name);
        }else {
            modelMap.put(GlobalDefine.errorMessage,"开通失败：亲确认用户 "+name+"是否存在");
        }
        return new ModelAndView("admin/open",modelMap);
    }

    @RequestMapping(value = "/admin/show", method= RequestMethod.GET)
    public ModelAndView userShow(@RequestParam(value = "template")String template,ModelMap modelMap,HttpSession session) {
        modelMap.put("menu",template);
        if(template.equals("user_list")){
            WyPower wyPower = (WyPower) session.getAttribute(GlobalDefine.admin);
            Users users = new Users();
            List<Users> usersList = usersDAO.getPageList(users, 0, 20);
            modelMap.put("user_list",usersList);
        }
        return new ModelAndView("admin/"+template,modelMap);//edit_slid edit_background edit_background  edit_images
    }
}
