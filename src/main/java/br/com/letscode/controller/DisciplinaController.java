package br.com.letscode.controller;

import br.com.letscode.entity.Disciplina;
import br.com.letscode.service.DisciplinaService;
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
@RequestMapping("disciplina")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @GetMapping
    private Iterable<Disciplina> buscarDisciplinas() {
        return disciplinaService.buscarDisciplinas();
    }

    @GetMapping("/{codigoDisciplina}")
    private Disciplina buscarPorId(@PathVariable Integer codigoDisciplina) {
        return disciplinaService.buscarPorId(codigoDisciplina);
    }

    @PostMapping
    private Disciplina adicionarDisciplina(@RequestBody Disciplina disciplina) {
        return disciplinaService.adicionarDisciplina(disciplina);
    }

    @DeleteMapping("/{codigoDisciplina}")
    private void deletarDisciplina(@PathVariable Integer codigoDisciplina) {
        disciplinaService.deletarDisciplina(codigoDisciplina);
    }

    @PatchMapping("/{codigoDisciplina}")
    private Disciplina atualizarDisciplina(@RequestBody Disciplina disciplina, @PathVariable Integer codigoDisciplina) {
        return disciplinaService.atualizarDisciplina(disciplina, codigoDisciplina);
    }
}