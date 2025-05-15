package com.example.xyz_enterprise.Controllers;

import com.example.xyz_enterprise.Models.Agenda;
import com.example.xyz_enterprise.Services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendas")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @GetMapping
    public List<Agenda> listarAgendas() {
        return agendaService.listarTodas();
    }

    @PostMapping
    public Agenda cadastrarAgenda(@RequestBody Agenda agenda) {
        return agendaService.cadastrarAgenda(agenda);
    }

    @PutMapping("/{id}/resumo")
    public Agenda atualizarResumo(@PathVariable int id, @RequestBody String resumo) {
        return agendaService.atualizarResumo(id, resumo);
    }
}