package com.morenomolina.gonzalomoreno.services;

import com.morenomolina.gonzalomoreno.entities.Compania;
import com.morenomolina.gonzalomoreno.repositories.CompaniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompaniaService {
@Autowired
CompaniaRepository companiaRepository;
public Compania SaveCompania(String nombreCompania,String base){
    Compania compania=new Compania();
    compania.setNombre(nombreCompania);
    compania.setBase(base);
    companiaRepository.saveAndFlush(compania);
    return compania;
}
}
