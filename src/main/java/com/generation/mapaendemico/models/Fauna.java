package com.generation.mapaendemico.models;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "fauna")
@Data
@NoArgsConstructor
public class Fauna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombreCientifico;
    private String nombreComun;
    @Lob
    private byte[] imagen;
    @Lob
    private byte[] imghuella;
    private String clase;
    private String orden;
    private String familia;
    private String regiones;
    private String amenaza;
    private String vertebradoInvertebrado;
    private String descripcion;
    private Long peso;
    private Long altura;

    @ManyToOne
    @JoinColumn(name = "parque_id")
    private Parque parque;
}
