package br.com.letscode.controller;

import br.com.letscode.entity.Aluno;
import br.com.letscode.service.AlunoService;
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
@RequestMapping("alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping
    private Iterable<Aluno> buscarAlunos() {
        return alunoService.buscarTodos();
    }

    @GetMapping("/{ra}")
    private Aluno buscarPorId(@PathVariable Integer ra) {
        return alunoService.buscarPorId(ra);
    }

    @PostMapping
    private Aluno adicionarAluno(@RequestBody Aluno aluno) {
        return alunoService.adicionarAluno(aluno);
    }

    @DeleteMapping("/{ra}")
    private void deletarAluno(@PathVariable Integer ra) {
        alunoService.deletarAluno(ra);
    }

    @PatchMapping("/{ra}")
    private Aluno atualizarAluno(@RequestBody Aluno aluno, @PathVariable Integer ra) {
        return alunoService.atualizarAluno(aluno, ra);
    }
}