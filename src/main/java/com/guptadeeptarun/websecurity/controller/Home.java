package com.guptadeeptarun.websecurity.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Home {

    @GetMapping(path = "/")
    public String home(HttpServletResponse response){
        Cookie mySecureCookie = new Cookie("my-httponly-cookie", "12345");
        mySecureCookie.setHttpOnly(true);
        response.addCookie(mySecureCookie);

        Cookie myCookie = new Cookie("my-cookie", "12345");
        myCookie.setHttpOnly(false);
        response.addCookie(myCookie);


        return "welcome";
    }

    @GetMapping(path = "/next")
    @ResponseBody
    public String next(Model model, HttpServletResponse response){
        return "This is next page";
    }

    @GetMapping(path = "/home")
    public String home(Model model, HttpServletResponse response){
        return "welcome";
    }

}
