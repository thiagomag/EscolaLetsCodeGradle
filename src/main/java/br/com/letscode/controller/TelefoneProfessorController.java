package br.com.letscode.controller;

import br.com.letscode.entity.TelefoneProfessor;
import br.com.letscode.service.TelefoneProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("telefoneProfessor")
public class TelefoneProfessorController {

    private final TelefoneProfessorService telefoneProfessorService;

    @GetMapping
    private Iterable<TelefoneProfessor> buscarTelefones() {
        return telefoneProfessorService.buscarTelefones();
    }

    @GetMapping("{/idtelefone}")
    private TelefoneProfessor buscarTelefonePorId(Integer idTelefone) {
        return telefoneProfessorService.buscarTelefonePorId(idTelefone);
    }

    @GetMapping("/{registroProfessor}")
    private Iterable<TelefoneProfessor> buscarTelefonesProfessor(Integer registroProfessor) {
        return telefoneProfessorService.buscarTelefonesProfessor(registroProfessor);
    }

    @PostMapping
    private TelefoneProfessor cadastrarTelefone(@RequestBody TelefoneProfessor telefoneProfessor) {
        return telefoneProfessorService.cadastrarTelefone(telefoneProfessor);
    }

    @DeleteMapping("/{idTelefone}")
    private void deletarTelefone(Integer idTelefone) {
        telefoneProfessorService.deletarTelefone(idTelefone);
    }

    @PatchMapping("/{idTelefone}")
    private TelefoneProfessor atualizarTelefone(@RequestBody TelefoneProfessor telefone, @PathVariable Integer idTelefone) {
        return telefoneProfessorService.atualizarTelefone(telefone, idTelefone);
    }
}