package com.morenomolina.gonzalomoreno.services;

import com.morenomolina.gonzalomoreno.entities.Vuelo;
import com.morenomolina.gonzalomoreno.repositories.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VuelosService {
    @Autowired
    private VueloRepository vueloRepository;
    public void saveVuelo(String origen, String destino, Integer duracion) {
    Vuelo vuelo=new Vuelo();
    vuelo.setOrigen(origen);
    vuelo.setDestino(destino);
    vuelo.setDuracion(duracion);
    vueloRepository.saveAndFlush(vuelo);
    }

    public List<Vuelo> FindVuelos() {
        return vueloRepository.findAll();
    }
    public Vuelo FindVueloByID(int idVuelo){
        return vueloRepository.findVueloById(idVuelo);
    }
}
