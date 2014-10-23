package com.wndxf.invitation.web.user;

import com.wndxf.invitation.GlobalDefine;
import com.wndxf.invitation.persistence.BlessingDAO;
import com.wndxf.invitation.persistence.model.Blessing;
import com.wndxf.invitation.web.Base;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wy
 */
@Controller
public class BlessingEdit extends Base {

    @Autowired
    private BlessingDAO blessingDAO;

    @RequestMapping(value = "/blessing/add", method= RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> add(@ModelAttribute Blessing blessing) throws IOException {
        Map<String, Object> returnMap = new HashMap<>();
        if(StringUtils.isEmpty(blessing.getBlessStr())){
            returnMap.put(GlobalDefine.ERROR, "祝福语需要填写!");
            return returnMap;
        }
        if(StringUtils.isEmpty(blessing.getName())){
            returnMap.put(GlobalDefine.ERROR, "名字需要填写!");
            return returnMap;
        }
        if(StringUtils.isEmpty(blessing.getPnum())){
            returnMap.put(GlobalDefine.ERROR, "几人参加需要填写名称!");
            return returnMap;
        }
        if(blessing.getUserId() == null){
            returnMap.put(GlobalDefine.ERROR, "您页面有错误!");
            return returnMap;
        }

        Blessing bs = new Blessing();
        bs.setName(blessing.getName());
        List<Blessing> blessings = blessingDAO.query(bs);
        if(blessings.size()>0){
            //todo 修改
            returnMap.put(GlobalDefine.MESSAGE, "发送成功");
        }else{
            int num = blessingDAO.insert(blessing);
            if(num>0){
                returnMap.put(GlobalDefine.MESSAGE, "发送成功");
            }else{
                returnMap.put(GlobalDefine.ERROR, "请重新发送");
            }
        }
        return returnMap;
    }

    @RequestMapping(value = "/user/blessing/delete", method= RequestMethod.GET)
    public ModelAndView delete(int blessingId,ModelMap modelMap,HttpSession session) throws IOException {
        blessingDAO.delete(blessingId);
        Blessing bs = new Blessing();
        bs.setUserId(getUserId(session));
        List<Blessing> blessings = blessingDAO.query(bs);
        modelMap.put("blesses",blessings);
        return new ModelAndView("user/blessing",modelMap);
    }

}
