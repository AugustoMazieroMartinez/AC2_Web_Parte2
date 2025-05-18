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
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descricao;
    private int cargaHoraria;
    private String objetivos;
    private String ementa;

    @ManyToMany(mappedBy = "especializacoes")
    @JsonIgnore
    private List<Professor> professores;

    @OneToMany(mappedBy = "curso")
    @JsonIgnore
    private List<Agenda> agendas;
}
