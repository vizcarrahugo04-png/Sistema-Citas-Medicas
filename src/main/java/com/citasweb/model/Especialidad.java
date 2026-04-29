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
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idEspecialidad;

    @Column(nullable = false, length = 50, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "especialidad", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("especialidad")
    @ToString.Exclude
    private List<Medico> medicos;
}