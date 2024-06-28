package com.generation.mapaendemico.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "parques")
@NoArgsConstructor
@Data
public class Parque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
    private String regiones_Id;


}
