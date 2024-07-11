package com.generation.mapaendemico.models;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "centros")
@Data
@NoArgsConstructor
public class Centro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String tipo;
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
}
