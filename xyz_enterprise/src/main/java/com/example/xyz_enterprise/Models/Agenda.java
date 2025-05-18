package com.example.xyz_enterprise.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private LocalDate dataInicio;
    private LocalDate dataFim;

    @Column(columnDefinition = "TIME")
    private LocalTime horarioInicio;

    @Column(columnDefinition = "TIME")
    private LocalTime horarioFim;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    private String cidade;
    private String estado;
    private String cep;
    private String resumo;
}
