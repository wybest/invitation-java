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
    public ModelAndView doOpen(@RequestParam("userName") String userName,HttpSession session,ModelMap modelMap) {
        WyPower wyPower = (WyPower) session.getAttribute(GlobalDefine.admin);
        Users user = usersDAO.loadByName(userName);
        Users users = new Users();
        users.setIsPay(GlobalDefine.pay);
        users.setAdminId(wyPower.getId());
        users.setId(user.getId());
        int count = usersDAO.open(users);
        if(count>0){
            modelMap.put(GlobalDefine.message,"开通成功："+userName);
        }else {
            modelMap.put(GlobalDefine.errorMessage,"开通失败：亲确认用户 "+userName+"是否存在");
        }
        return new ModelAndView("admin/open",modelMap);
    }

    @RequestMapping(value = "/admin/close")
    public ModelAndView close(@RequestParam("userId") int userId,HttpSession session,ModelMap modelMap) {
        WyPower wyPower = (WyPower) session.getAttribute(GlobalDefine.admin);
        Users user = usersDAO.loadById(userId);
        if(user.getAdminId() != wyPower.getId()){
            modelMap.put(GlobalDefine.errorMessage,"关闭失败：亲确认用户 "+user.getUsername()+"是否存在");
        }else {
            Users users = new Users();
            users.setId(userId);
            users.setIsPay(GlobalDefine.refund);
            int count = usersDAO.update(users);
            if(count>0){
                modelMap.put(GlobalDefine.message,"关闭成功："+user.getUsername());
            }else {
                modelMap.put(GlobalDefine.errorMessage,"关闭失败：亲确认用户 "+user.getUsername()+"是否存在");
            }
        }

        return new ModelAndView("admin/user_list",modelMap);
    }

    @RequestMapping(value = "/admin/show", method= RequestMethod.GET)
    public ModelAndView userShow(@RequestParam(value = "template")String template,ModelMap modelMap,HttpSession session) {
        modelMap.put("menu",template);
        if(template.equals("user_list")){
            WyPower wyPower = (WyPower) session.getAttribute(GlobalDefine.admin);
            Users users = new Users();
            users.setAdminId(wyPower.getId());
            users.setIsConfirm(0);
//            List<Users> usersList = usersDAO.getPageList(users, 0, 20);
            List<Users> usersList = usersDAO.query(users);
            modelMap.put("userList",usersList);
        }
        return new ModelAndView("admin/"+template,modelMap);//edit_slid edit_background edit_background  edit_images
    }
}
