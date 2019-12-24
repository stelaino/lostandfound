package com.qf.laf.controller;

import com.qf.laf.entity.User;
import com.qf.laf.service.IUserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RequestMapping("/user")
@RestController
public class UserController {
    @Resource
    IUserService userService;

    @RequestMapping("/login")
    public String login(@RequestBody User user, HttpSession session) {
        Integer uid = userService.login(user);
        if (uid != null) {
            session.setAttribute("uId", uid);
            //if have save surl in session,will return surl to request,else return userlost.html
            if (session.getAttribute("surl") != null) {
                return (String) session.getAttribute("surl");
            }
            return "userlost.html";
        }
        return "登录失败";
    }

    @RequestMapping("/getUser")
    public User getUserById(HttpSession session) {
        Integer uId = (Integer) session.getAttribute("uId");
        if (uId != null) {
            return userService.getUserByUId(uId);
        }
        return null;
    }
    @RequestMapping("/logout")
    public Boolean logout(HttpSession session) {
        if (session.getAttribute("uId") != null) {
            session.removeAttribute("uId");
            return true;
        }
        return false;
    }

    @RequestMapping("/checkLoginStatus")
    public Boolean checkLoginStatus(String surl, HttpSession session) {
        if (session.getAttribute("uId") != null) {
            return true;
        }
        session.setAttribute("surl", surl);
        return false;
    }
}
