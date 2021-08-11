package br.com.letscode.controller;

import br.com.letscode.request.DisciplinaReqAtualizar;
import br.com.letscode.request.DisciplinaRequest;
import br.com.letscode.response.DisciplinaResponse;
import br.com.letscode.service.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("disciplina")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @GetMapping("/buscarDisciplina")
    private List<DisciplinaResponse> buscarDisciplinas() {
        return disciplinaService.buscarDisciplinas();
    }

    @GetMapping("/buscarDisciplina/{codigoDisciplina}")
    private DisciplinaResponse buscarPorId(@PathVariable Integer codigoDisciplina) {
        return disciplinaService.buscarPorId(codigoDisciplina);
    }

    @PostMapping("/adicionarDisciplina")
    private ResponseEntity<DisciplinaResponse> adicionarDisciplina(@RequestBody DisciplinaRequest disciplinaRequest,
                                                                   UriComponentsBuilder uriComponentsBuilder) {
        return disciplinaService.adicionarDisciplina(disciplinaRequest, uriComponentsBuilder);
    }

    @DeleteMapping("/deletarDisciplina/{codigoDisciplina}")
    private ResponseEntity<?> deletarDisciplina(@PathVariable Integer codigoDisciplina) {
        return disciplinaService.deletarDisciplina(codigoDisciplina);
    }

    @PatchMapping("/atualizarDisciplina/{codigoDisciplina}")
    private ResponseEntity<DisciplinaResponse> atualizarDisciplina(@RequestBody DisciplinaReqAtualizar disciplina,
                                                                   @PathVariable Integer codigoDisciplina) {
        return disciplinaService.atualizarDisciplina(disciplina, codigoDisciplina);
    }
}