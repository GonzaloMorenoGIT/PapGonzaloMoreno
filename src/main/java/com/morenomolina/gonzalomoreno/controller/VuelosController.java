package com.morenomolina.gonzalomoreno.controller;

import com.morenomolina.gonzalomoreno.entities.Vuelo;
import com.morenomolina.gonzalomoreno.services.VuelosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("vuelos")
public class VuelosController {
    @Autowired
    private VuelosService vuelosService;
@GetMapping("c")
    public String cGet(ModelMap m){
    m.put("view","Vuelos/c");
    return "_t/frame";
}
@PostMapping("c")
    public String cPost(@RequestParam(name = "origen")String origen,
                        @RequestParam(name= "destino")String destino,
                        @RequestParam(name="duracion")Integer duracion){
    vuelosService.saveVuelo(origen,destino,duracion);
    return "redirect:/root/";
}
@GetMapping("r")
    public String rGet(ModelMap m){
    m.put("view","Vuelos/r");
    m.put("vuelos",vuelosService.FindVuelos());
    return "_t/frame";
}
//TODO Hacer el caso u
@GetMapping("u")
    public String u(ModelMap m){
    m.put("vuelos",vuelosService.FindVuelos());
    m.put("view","Vuelos/u");
    return "_t/frame";
}
@PostMapping("u")
    public String uPost(ModelMap m,
                        @RequestParam(required = false , name="id") int id){
    Vuelo vuelo=vuelosService.FindVueloByID(id);
    m.put("view","Vuelos/uPost");
    return "_t/frame";
}
}
