package com.example.xyz_enterprise.Models;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private LocalTime horarioInicio;

    private LocalTime horarioFim;

    private String cidade;

    private String estado;

    private String cep;

    @Column(length = 500)
    private String resumo;
}
