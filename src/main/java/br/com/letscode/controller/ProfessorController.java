package br.com.letscode.controller;


import br.com.letscode.entity.Professor;
import br.com.letscode.service.ProfessorService;
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
@RequestMapping("professores")
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping
    private Iterable<Professor> buscarProfessores() {
        return professorService.buscarProfessores();
    }

    @GetMapping("/{registroProfessor}")
    private Professor buscarPorId(@PathVariable Integer registroProfessor) {
        return professorService.buscarPorId(registroProfessor);
    }

    @PostMapping
    private Professor adicionarProfessor(@RequestBody Professor professor) {
        return professorService.adicionarProfessor(professor);
    }

    @DeleteMapping("/{registroProfessor}")
    private void deletarProfessor(@PathVariable Integer registroProfessor) {
        professorService.deletarProfessor(registroProfessor);
    }

    @PatchMapping("/{registroProfessor}")
    private Professor atualizarProfessor(@RequestBody Professor professor, @PathVariable Integer registroProfessor) {
        return professorService.atualizarProfessro(professor, registroProfessor);
    }
}