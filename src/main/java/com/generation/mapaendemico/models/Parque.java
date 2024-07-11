package com.generation.mapaendemico.models;

import jakarta.persistence.*;
import lombok.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "parques")
@Data
@NoArgsConstructor
public class Parque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "parque")
    private List<Fauna> faunas;
}
