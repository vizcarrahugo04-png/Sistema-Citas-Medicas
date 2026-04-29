package com.citasweb.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idMedico;

    @Column(nullable = false, length = 10, unique = true)
    private String cmp;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(length = 15)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "especialidad_id", nullable = false,
                foreignKey = @ForeignKey(name = "FK_MEDICO_ESPECIALIDAD"))
    @JsonIgnoreProperties("medicos")
    @ToString.Exclude
    private Especialidad especialidad;

    @ManyToOne
    @JoinColumn(name = "consultorio_id", nullable = false,
                foreignKey = @ForeignKey(name = "FK_MEDICO_CONSULTORIO"))
    @JsonIgnoreProperties("medicos")
    @ToString.Exclude
    private Consultorio consultorio;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    @JsonManagedReference("medico-citas")
    @ToString.Exclude
    private List<Cita> citas;
}