package com.example.xyz_enterprise.Models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String cpf;

    private String rg;

    private String endereco;

    private String celular;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<Agenda> agendas;

    @ManyToMany
    @JoinTable(
        name = "professor_curso",
        joinColumns = @JoinColumn(name = "professor_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> especializacoes;
}
