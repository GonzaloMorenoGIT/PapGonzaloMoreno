package com.morenomolina.gonzalomoreno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("root")
public class rootController {
    @GetMapping("/")
    public String root(ModelMap m){
        m.put("view","root/panel");
        return "_t/frame";
    }

}
