package br.com.letscode.controller;

import br.com.letscode.entity.CursoDisciplinaProfessor;
import br.com.letscode.service.CursoDisciplinaProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("cursoDisciplinaProfessor")
public class CursoDisciplicaProfessorController {

    private final CursoDisciplinaProfessorService cursoDisciplinaProfessorService;

    @GetMapping
    private List<CursoDisciplinaProfessor> buscarCursosDisciplinaProfessor() {
        return cursoDisciplinaProfessorService.buscarCursosDisciplinaProfessor();
    }

    @GetMapping("/{codigoCurso}")
    private CursoDisciplinaProfessor buscarCursosDisciplinaProfessorPorCurso(@PathVariable Integer codigoCurso){
        return cursoDisciplinaProfessorService.buscarCursosDisciplinaProfessorPorCurso(codigoCurso);
    }

    @GetMapping("/{codigoDisiciplina}")
    private CursoDisciplinaProfessor buscarCursosDisciplinaProfessorPorDisciplina(@PathVariable Integer codigoDisiciplina) {
        return cursoDisciplinaProfessorService.buscarCursosDisciplinaProfessorPorDisciplina(codigoDisiciplina);
    }

    @GetMapping("/{registroProfessor}")
    private CursoDisciplinaProfessor buscarCursosDisciplinaProfessorPorProfessor(@PathVariable Integer registroProfessor) {
        return cursoDisciplinaProfessorService.buscarCursosDisciplinaProfessorPorProfessor(registroProfessor);
    }

    @PostMapping
    private CursoDisciplinaProfessor adicionar(@RequestBody CursoDisciplinaProfessor cursoDisciplinaProfessor) {
        return cursoDisciplinaProfessorService.adicionar(cursoDisciplinaProfessor);
    }

    @DeleteMapping("/{id}")
    private void deletar(@PathVariable Integer id) {
        cursoDisciplinaProfessorService.deletar(id);
    }

    @PatchMapping("/{id}")
    private CursoDisciplinaProfessor atualizar(@RequestBody CursoDisciplinaProfessor cursoDisciplinaProfessor, @PathVariable Integer id) {
        return cursoDisciplinaProfessorService.atualizar(cursoDisciplinaProfessor, id);
    }
}
