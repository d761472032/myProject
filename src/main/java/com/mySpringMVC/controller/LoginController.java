package com.mySpringMVC.controller;

import com.mySpringMVC.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public String check(User user, HttpServletRequest httpServletRequest, Model model) {
        if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
            httpServletRequest.getSession().setAttribute("user", user);
            return "redirect:/login/home";
        } else {
            model.addAttribute("msg", "用户名或密码错误！");
            return "../../index";
        }
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String directHome() {
        return "home";
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String directPage() {
        return "page1";
    }
}
