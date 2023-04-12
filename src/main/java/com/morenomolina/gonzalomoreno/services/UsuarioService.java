package com.morenomolina.gonzalomoreno.services;

import com.morenomolina.gonzalomoreno.entities.Usuario;
import com.morenomolina.gonzalomoreno.helpers.PRG;
import com.morenomolina.gonzalomoreno.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuario() {
        return usuarioRepository.findAll();
    }

    public Usuario saveUsuario(String nombreUsuario, String correo, String contrasena) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombreUsuario);
        usuario.setCorreo(correo);
        usuario.setContrasena((new BCryptPasswordEncoder()).encode(contrasena));
        usuarioRepository.saveAndFlush(usuario);
        return usuario;
    }

    public Boolean autenticarUsuario(String nombreUsuario, String password) {
        Usuario usuario = null;
        boolean validador=false;
            usuario = usuarioRepository.findByNombre(nombreUsuario);
            if (usuario != null && usuario.getNombre().equals(nombreUsuario) && (new BCryptPasswordEncoder()).matches(password, usuario.getContrasena())) {
                    validador=true;
            }else{
                    validador=false;
            }
            return  validador;
    }
    public Usuario mostrarUsuario(String nombreUsuario){
        return usuarioRepository.findByNombre(nombreUsuario);
    }
}

