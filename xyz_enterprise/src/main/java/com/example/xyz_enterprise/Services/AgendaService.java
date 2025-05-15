package com.example.xyz_enterprise.Services;

import com.example.xyz_enterprise.Models.Agenda;
import com.example.xyz_enterprise.Repositories.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    public List<Agenda> listarTodas() {
        return agendaRepository.findAll();
    }

    public Agenda cadastrarAgenda(Agenda agenda) {
        // Validações de conflito e especialização podem ser adicionadas aqui
        return agendaRepository.save(agenda);
    }

    public Agenda atualizarResumo(int agendaId, String resumo) {
        Agenda agenda = agendaRepository.findById(agendaId)
                .orElseThrow(() -> new IllegalArgumentException("Agenda não encontrada."));
        agenda.setResumo(resumo);
        return agendaRepository.save(agenda);
    }
}