package com.citasweb.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idHistoria;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false,
                foreignKey = @ForeignKey(name = "FK_HISTORIA_PACIENTE"))
    @JsonBackReference("paciente-historias")
    @ToString.Exclude
    private Paciente paciente;

    @Column(nullable = false, length = 500)
    private String descripcion;
}