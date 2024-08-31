package com.learn.learnboot.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Testing {



    @RequestMapping("/test")
    @ResponseBody
    public String test()
    {
        return "Hello One Time Is tis is ne time :  "+new java.util.Date();
    }

    @RequestMapping("/home")
    public String home()
    {
        return "home";
    }
}
