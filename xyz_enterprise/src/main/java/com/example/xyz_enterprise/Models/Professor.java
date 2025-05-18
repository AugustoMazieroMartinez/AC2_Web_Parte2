package com.example.xyz_enterprise.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private String celular;

    @ManyToMany
    @JoinTable(
        name = "professor_curso",
        joinColumns = @JoinColumn(name = "professor_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> especializacoes;

    @OneToMany(mappedBy = "professor")
    @JsonIgnore
    private List<Agenda> agendas;
}
