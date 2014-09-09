package com.wndxf.invitation.web;

import com.wndxf.invitation.GlobalDefine;
import com.wndxf.invitation.persistence.UsersDAO;
import com.wndxf.invitation.persistence.model.Users;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author wy
 */
public class Base {

    @Resource
    protected UsersDAO usersDAO;

    public int getUserId(HttpSession session){
        Users user = (Users) session.getAttribute(GlobalDefine.user);
        return user.getId();
    }

    public Users getUser(HttpSession session){
        Users user = (Users) session.getAttribute(GlobalDefine.user);
        user = usersDAO.load(user.getUsername(),user.getPassword());
        return user;
    }
}
