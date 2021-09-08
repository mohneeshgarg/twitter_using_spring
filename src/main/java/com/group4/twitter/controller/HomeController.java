package com.group4.twitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

    @RequestMapping("/home")
    public ModelAndView test() {
        return new ModelAndView("newtweet");
    }

    @RequestMapping("/admin")
    public ModelAndView test2() {
        return new ModelAndView("newtweet");
    }
}
