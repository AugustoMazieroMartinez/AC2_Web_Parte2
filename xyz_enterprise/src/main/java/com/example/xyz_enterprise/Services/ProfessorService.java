package com.example.xyz_enterprise.Services;

import com.example.xyz_enterprise.Models.Professor;
import com.example.xyz_enterprise.Models.Agenda;
import com.example.xyz_enterprise.Repositories.ProfessorRepository;
import com.example.xyz_enterprise.Repositories.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AgendaRepository agendaRepository;

    public List<Professor> listarTodos() {
        return professorRepository.findAll();
    }

    public List<Agenda> listarAgendasPorProfessor(int professorId) {
        return agendaRepository.findAgendasByProfessor(professorId);
    }

    public Professor cadastrarProfessor(Professor professor) {
        return professorRepository.save(professor);
    }
}