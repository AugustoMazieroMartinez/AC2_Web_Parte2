package com.example.xyz_enterprise.services;

import com.example.xyz_enterprise.models.Agenda;
import com.example.xyz_enterprise.repositories.AgendaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository agendaRepository;

    public AgendaServiceImpl(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    @Override
    public Optional<Agenda> findById(Integer id) {
        return agendaRepository.findById(id);
    }

    @Override
    public List<Agenda> findAll() {
        return agendaRepository.findAll();
    }

    @Override
    public Agenda save(Agenda agenda) {
        // Verifica se o professor já está ocupado nesse período
        List<Agenda> conflitos = agendaRepository.findProfessorLivre(
            agenda.getProfessor().getId(),
            agenda.getDataInicio(),
            agenda.getDataFim()
        );
        if (!conflitos.isEmpty()) {
            throw new IllegalArgumentException("Professor já possui agenda nesse período.");
        }
        return agendaRepository.save(agenda);
    }

    @Override
    public void deleteById(Integer id) {
        agendaRepository.deleteById(id);
    }

    @Override
    public Agenda putById(Integer id, Agenda agenda) {
        // Verifica se o professor já está ocupado nesse período, exceto pela própria agenda
        List<Agenda> conflitos = agendaRepository.findProfessorLivre(
            agenda.getProfessor().getId(),
            agenda.getDataInicio(),
            agenda.getDataFim()
        );
        // Remove o próprio agendamento da lista de conflitos (caso esteja editando)
        conflitos.removeIf(a -> a.getId() == id);
        if (!conflitos.isEmpty()) {
            throw new IllegalArgumentException("Professor já possui agenda nesse período.");
        }
        agenda.setId(id);
        return agendaRepository.save(agenda);
    }

    @Override
    public List<Agenda> findByProfessorId(Integer professorId) {
        return agendaRepository.findByProfessorId(professorId);
    }

    @Override
    public List<Agenda> findProfessorLivre(Integer professorId, LocalDate dataInicio, LocalDate dataFim) {
        return agendaRepository.findProfessorLivre(professorId, dataInicio, dataFim);
    }

    @Override
    public List<Agenda> findByCursoId(Integer cursoId) {
        return agendaRepository.findByCursoId(cursoId);
    }
}
