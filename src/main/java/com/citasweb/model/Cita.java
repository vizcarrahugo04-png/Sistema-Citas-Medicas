package com.citasweb.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCita;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false,
                foreignKey = @ForeignKey(name = "FK_CITA_PACIENTE"))
    @JsonBackReference("paciente-citas")
    @ToString.Exclude
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false,
                foreignKey = @ForeignKey(name = "FK_CITA_MEDICO"))
    @JsonBackReference("medico-citas")
    @ToString.Exclude
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "consultorio_id", nullable = false,
                foreignKey = @ForeignKey(name = "FK_CITA_CONSULTORIO"))
    @JsonBackReference("consultorio-citas")
    @ToString.Exclude
    private Consultorio consultorio;

    @Column(nullable = false)
    private String fecha;

    @OneToOne(mappedBy = "cita", cascade = CascadeType.ALL)
    @JsonManagedReference("cita-pago")
    @ToString.Exclude
    private Pago pago;
}