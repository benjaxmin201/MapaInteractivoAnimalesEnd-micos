package com.generation.mapaendemico.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "centros")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Centro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String tipocentro;

    private String direccion;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region centroRegion;
}
