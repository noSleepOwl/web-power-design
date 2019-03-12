package com.example.springstartertester.business.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {
    private static final String INDEX = "index";
    @GetMapping
    public ModelAndView user() {
        ModelAndView modelAndView = new ModelAndView(INDEX);
        modelAndView.addObject("phone","18602538923");
        return modelAndView;
    }
}
