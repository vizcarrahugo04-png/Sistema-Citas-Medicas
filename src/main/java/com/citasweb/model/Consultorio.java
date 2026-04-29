package com.citasweb.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Consultorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idConsultorio;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String ubicacion;

    @Column(nullable = false)
    private Integer capacidad;

    @OneToMany(mappedBy = "consultorio", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("consultorio")
    @ToString.Exclude
    private List<Medico> medicos;

    @OneToMany(mappedBy = "consultorio", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("consultorio")
    @ToString.Exclude
    private List<Cita> citas;
}