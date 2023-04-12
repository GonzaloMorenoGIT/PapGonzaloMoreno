package com.morenomolina.gonzalomoreno.controller;

import com.morenomolina.gonzalomoreno.entities.Usuario;
import com.morenomolina.gonzalomoreno.exception.DangerException;
import com.morenomolina.gonzalomoreno.helpers.PRG;
import com.morenomolina.gonzalomoreno.services.UsuarioService;
import jakarta.servlet.http.HttpSession;
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
                        @RequestParam(name ="password")String password,
                        HttpSession s) {
           Boolean validador=usuarioService.autenticarUsuario(nombreUsuario,password);
           String redireccionamiento="";
            Usuario usuario=usuarioService.mostrarUsuario(nombreUsuario);
           if (validador && nombreUsuario.contains("root")){
               s.setAttribute("usuario",usuario.getNombre());
               redireccionamiento="redirect:/root/";
           }else if(validador){
               System.out.println("OK");
               s.setAttribute("usuario",usuario.getNombre());
               redireccionamiento="redirect:/login/inicio";
           }
           else {
               s.invalidate();
               System.out.println("No ok");
               redireccionamiento="redirect:/";
           }
        return redireccionamiento;
    }
    @GetMapping("inicio")
    public String inicio(ModelMap m){
        m.put("view","Home/inicio");
        return "_t/frame";
    }
}
