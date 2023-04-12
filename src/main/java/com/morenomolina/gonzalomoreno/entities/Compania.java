package com.morenomolina.gonzalomoreno.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compania {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String nombre;
    @Column
    String Base;
    @Column
    @OneToMany
    private Vuelo vuelos;

}
