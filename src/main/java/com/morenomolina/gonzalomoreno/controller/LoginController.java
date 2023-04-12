package com.morenomolina.gonzalomoreno.controller;

import com.morenomolina.gonzalomoreno.entities.Usuario;
import com.morenomolina.gonzalomoreno.exception.DangerException;
import com.morenomolina.gonzalomoreno.helpers.PRG;
import com.morenomolina.gonzalomoreno.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping("c")
    public String cGet(ModelMap m) {
        m.put("view", "Login/c");
        return "_t/frame";
    }
    @GetMapping("register")
    public String register(ModelMap m){
        m.put("view","Login/register");
        return "_t/frame";
    }
    @PostMapping("c")
    public String cPost(ModelMap m,
                        @RequestParam(name = "nombreUsuario")String nombreUsuario,
                        @RequestParam(name ="password")String password) {
           Boolean validador=usuarioService.autenticarUsuario(nombreUsuario,password);
           if (validador){
               System.out.println("OK");
           }else {
               System.out.println("No ok");
           }
        return "redirect:/";
    }
}
