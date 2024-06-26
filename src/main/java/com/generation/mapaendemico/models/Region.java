package com.generation.mapaendemico.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "regiones")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private int numero;

    @Lob
    @Column(name = "imagenRegion", columnDefinition = "BLOB")
    private byte[] imagenRegion;

    @OneToMany(mappedBy = "parqueRegiones")
    private List<Region> regionesParque;
}
