package com.morenomolina.gonzalomoreno.repositories;

import com.morenomolina.gonzalomoreno.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
@EnableJpaRepositories
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
   public Usuario findByNombre(String nombreUsuario);
}
