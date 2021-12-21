package com.example.datawarehouse.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "/mycat")
public class MycatController {

    @GetMapping
    public ModelAndView home() {
        ModelAndView m=new ModelAndView();
        m.setViewName("home");
        return m;
    }

}
