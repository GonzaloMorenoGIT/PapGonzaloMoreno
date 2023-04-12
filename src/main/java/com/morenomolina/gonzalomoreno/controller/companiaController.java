package com.morenomolina.gonzalomoreno.controller;

import com.morenomolina.gonzalomoreno.services.CompaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("compania")
public class companiaController {
    @Autowired
    CompaniaService companiaService;
    @GetMapping("c")
    public String c(ModelMap m){
        m.put("view","Compañia/c");
        return "_t/frame";
    }
    @PostMapping("c")
    public String cPost(ModelMap m,
                        @RequestParam(name="nombreCompania")String nombreCompania,
                        @RequestParam(name="base")String base){
        companiaService.SaveCompania(nombreCompania,base);
        return "redirect:/root/";
    }
}
