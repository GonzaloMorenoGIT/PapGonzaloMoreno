package com.morenomolina.gonzalomoreno.controller;

import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String menu(ModelMap m, HttpSession http){
        if (http!=null){
            http.invalidate();
            m.put("view","Home/home");
                return "_t/frame";
        }else{
            m.put("view","Home/home");
            return "_t/frame";
        }
    }
}
