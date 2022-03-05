package com.wangyuhang.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MyController {

    @RequestMapping("/index")
    public String toIndex(Model model){
        model.addAttribute("msg","hello shiro");

        return "index";
    }
    @RequestMapping("/user/add")
    public String add(Model model){
        model.addAttribute("msg","hello shiro");
        return "user/add";
    }
    @RequestMapping("/user/update")
    public String update(Model model){
        model.addAttribute("msg","hello shiro");
        return "user/update";
    }

    @GetMapping("/tologin")
    public String toLogin(){
        return "mylogin";
    }

    @RequestMapping("/login")
    public String login(String name,String password,Model model){
        //获取当前用户
        Subject subject= SecurityUtils.getSubject();
        //封装数据库
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        try {
            subject.login(token);
            return "index";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名密码错误");
            return "mylogin";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "mylogin";
        }
    }
    @RequestMapping("/unauth")
    @ResponseBody
    public String unauth(){
        return "未授权";
    }
}
