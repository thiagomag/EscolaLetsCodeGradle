package br.com.letscode.controller;


import br.com.letscode.request.ProfessorReqAtualizar;
import br.com.letscode.request.ProfessorRequest;
import br.com.letscode.response.ProfessorResponse;
import br.com.letscode.service.ProfessorService;
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
@RequestMapping("professores")
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping("/buscarProfessor")
    private List<ProfessorResponse> buscarProfessores() {
        return professorService.buscarProfessores();
    }

    @GetMapping("/buscarProfessor/{registroProfessor}")
    private ProfessorResponse buscarPorId(@PathVariable Integer registroProfessor) {
        return professorService.buscarPorId(registroProfessor);
    }

    @PostMapping("/adicionarProfessor")
    private ResponseEntity<ProfessorResponse> adicionarProfessor(@RequestBody ProfessorRequest professor,
                                              UriComponentsBuilder uriComponentsBuilder) {
        return professorService.adicionarProfessor(professor, uriComponentsBuilder);
    }

    @DeleteMapping("/deletarProfessor/{registroProfessor}")
    private ResponseEntity<?> deletarProfessor(@PathVariable Integer registroProfessor) {
        return professorService.deletarProfessor(registroProfessor);
    }

    @PatchMapping("/atualizarProfessor/{registroProfessor}")
    private ResponseEntity<ProfessorResponse> atualizarProfessor(@RequestBody ProfessorReqAtualizar professor,
                                                                 @PathVariable Integer registroProfessor) {
        return professorService.atualizarProfessor(professor, registroProfessor);
    }
}