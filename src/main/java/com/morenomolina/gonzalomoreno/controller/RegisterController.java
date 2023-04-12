package com.morenomolina.gonzalomoreno.controller;

import com.morenomolina.gonzalomoreno.entities.Usuario;
import com.morenomolina.gonzalomoreno.services.UsuarioService;
import org.apache.tomcat.util.http.parser.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("register")
public class RegisterController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping("c")
    public String cGet(ModelMap m){
        m.put("view","Login/register");
        return "_t/frame";
    }
    @PostMapping("c")
    public String cPost(ModelMap m,
                        @RequestParam(required = false,  defaultValue = "NombreUsuario", name = "nombreUsuario")String nombreUsuario,
                        @RequestParam(required = false,  defaultValue = "correo@correo.com",name = "correo")String correo,
                        @RequestParam(required = false,  defaultValue = "contraseña", name = "contrasena")String contrasena){
        Usuario usuario=usuarioService.saveUsuario(nombreUsuario, correo, contrasena);
        System.out.println(usuario);
        return "redirect:/";
    }
}
