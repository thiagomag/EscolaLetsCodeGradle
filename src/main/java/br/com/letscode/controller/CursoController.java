package br.com.letscode.controller;

import br.com.letscode.entity.Curso;
import br.com.letscode.service.CursoService;
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
@RequestMapping("cursos")
public class CursoController {

    private final CursoService cursoService;

    @GetMapping
    private Iterable<Curso> buscarCursos() {
        return cursoService.buscarCursos();
    }

    @GetMapping("/{codigoCurso}")
    private Curso buscarPorId(@PathVariable Integer codigoCurso) {
        return cursoService.buscarPorId(codigoCurso);
    }

    @PostMapping
    private Curso adicionarCurso(@RequestBody Curso curso) {
        return cursoService.adicionarCurso(curso);
    }

    @DeleteMapping("/{codigoCurso}")
    private void deletarCurso(@PathVariable Integer codigoCurso) {
        cursoService.deletarCurso(codigoCurso);
    }

    @PatchMapping("/{codigoCurso}")
    private Curso atualizarCurso(@RequestBody Curso curso, @PathVariable Integer codigoCurso) {
        return cursoService.atualizarCurso(curso, codigoCurso);
    }
}

