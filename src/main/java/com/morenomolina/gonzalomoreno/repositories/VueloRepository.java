package com.morenomolina.gonzalomoreno.repositories;

import com.morenomolina.gonzalomoreno.entities.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueloRepository extends JpaRepository<Vuelo,Long> {
public Vuelo findVueloById(int idvuelo);
}
