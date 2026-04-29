package com.citasweb.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idPago;

    @OneToOne
    @JoinColumn(name = "cita_id", nullable = false,
                foreignKey = @ForeignKey(name = "FK_PAGO_CITA"))
    @JsonBackReference("cita-pago")
    @ToString.Exclude
    private Cita cita;

    @Column(nullable = false)
    private Double monto;

    @Column(length = 20)
    private String metodo;

    private LocalDate fechaPago;
}