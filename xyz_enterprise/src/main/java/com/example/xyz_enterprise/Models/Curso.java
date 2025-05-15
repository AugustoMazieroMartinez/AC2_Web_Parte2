package com.example.xyz_enterprise.Models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descricao;

    private int cargaHoraria;

    @Column(length = 1000)
    private String objetivos;

    @Column(length = 2000)
    private String ementa;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Agenda> agendas;

    @ManyToMany(mappedBy = "especializacoes")
    private List<Professor> professores;
}
