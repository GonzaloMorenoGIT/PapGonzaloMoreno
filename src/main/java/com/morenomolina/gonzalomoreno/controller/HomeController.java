package com.morenomolina.gonzalomoreno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String menu(ModelMap m){
        m.put("view","Home/home");
        return "_t/frame";
    }
}
