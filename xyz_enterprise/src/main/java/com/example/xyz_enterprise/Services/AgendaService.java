package com.example.xyz_enterprise.services;

import com.example.xyz_enterprise.models.Agenda;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AgendaService {
    Optional<Agenda> findById(Integer id);
    List<Agenda> findAll();
    Agenda save(Agenda agenda);
    void deleteById(Integer id);
    Agenda putById(Integer id, Agenda agenda);

    List<Agenda> findByProfessorId(Integer professorId);
    List<Agenda> findProfessorLivre(Integer professorId, LocalDate dataInicio, LocalDate dataFim);
    List<Agenda> findByCursoId(Integer cursoId);
}
