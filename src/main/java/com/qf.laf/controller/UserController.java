package com.qf.laf.controller;

import com.qf.laf.entity.User;
import com.qf.laf.entity.VerifyCodeUtil;
import com.qf.laf.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    //作用同findUserById()
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

    @RequestMapping(value = "/registerUser")
    public String registerUser(@RequestBody User user) {
        System.out.println(user);
        userService.register(user);
        return "注册成功";
    }

    //邮箱验证 在注册表单填写表单输入邮箱后 由邮箱发送6位数验证码
    @RequestMapping(value = "/email")
    @ResponseBody
    public void codeSend(@Param("eamil")String email, HttpServletRequest request){
        String code = VerifyCodeUtil.getRandomNumCode(6);
        request.getSession().setAttribute("code",code);
        userService.sendMail(email,code);
        request.setAttribute("code",code);
    }

    //注册邮箱验证码验证 接收到6位数的验证码后并进行验证
    @RequestMapping(value = "/codecheck")
    @ResponseBody
    public String codeCheck(@Param("code")String code,HttpServletRequest request){
        String codesave = (String) request.getSession().getAttribute("code");
        System.out.println(codesave);
        if(codesave.equals(code)){
            return "1";
        }else{
            return "0";
        }
    }
}
