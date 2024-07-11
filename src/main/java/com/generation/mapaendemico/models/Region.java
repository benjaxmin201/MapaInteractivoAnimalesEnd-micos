package com.generation.mapaendemico.models;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "regiones")
@Data
@NoArgsConstructor
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String numero;
    @Lob
    private byte[] imagenRegion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "region")
    private List<Parque> parques;

    @OneToMany(mappedBy = "region")
    private List<Centro> centros;
}
