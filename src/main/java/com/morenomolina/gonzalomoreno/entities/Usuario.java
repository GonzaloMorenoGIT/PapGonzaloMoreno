package com.morenomolina.gonzalomoreno.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private  Long Id;
    @Column
private  String nombre;
    @Column
private  String correo;
@Column(unique = true)
private String contrasena;
}
