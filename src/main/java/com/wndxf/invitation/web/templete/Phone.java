package com.wndxf.invitation.web.templete;

import com.google.code.kaptcha.Producer;
import com.wndxf.invitation.GlobalDefine;
import com.wndxf.invitation.persistence.UsersDAO;
import com.wndxf.invitation.persistence.model.Users;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author wy
 */
@Controller
public class Phone {

    @Resource
    private UsersDAO usersDAO;

    @RequestMapping(value = "/phone", method = RequestMethod.GET)
    public ModelAndView verificationCode(@RequestParam("path") String path,@RequestParam("user") int userId,ModelMap modelMap) throws IOException {
        Users user = usersDAO.loadById(userId);
        if(StringUtils.isNotEmpty(user.getImage())){
            String images = "";
            for(String image:user.getImage().split(",")){
                images += GlobalDefine.IMAGE_URL+image+",";
            }
            user.setImage(images);
        }
        if(StringUtils.isNotEmpty(user.getBackground())){
            String[] backGround = user.getBackground().split(",");
            modelMap.put("backGround1",GlobalDefine.IMAGE_URL+backGround[0]);
            modelMap.put("backGround2",GlobalDefine.IMAGE_URL+backGround[1]);
            modelMap.put("backGround3",GlobalDefine.IMAGE_URL+backGround[2]);
            modelMap.put("backGround4",GlobalDefine.IMAGE_URL+backGround[3]);
        }
        modelMap.put("user",user);
        return new ModelAndView("templete/"+path,modelMap);
    }

}
