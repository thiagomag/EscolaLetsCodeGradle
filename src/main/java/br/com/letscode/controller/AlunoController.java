package br.com.letscode.controller;

import br.com.letscode.request.AlunoReqAtualizar;
import br.com.letscode.request.AlunoRequest;
import br.com.letscode.response.AlunoResponse;
import br.com.letscode.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping("/buscarAluno")
    private List<AlunoResponse> buscarAlunos() {
        return alunoService.buscarTodos();
    }

    @GetMapping("/buscarAluno/buscaPorNome/{nome}")
    private List<AlunoResponse> buscarPorNome(@PathVariable String nome) {
        return alunoService.buscarPorNome(nome);
    }

    @GetMapping("/buscarAluno/nomeCurso/{nomeCurso}")
    private List<AlunoResponse> buscarPorNomeCurso(@PathVariable String nomeCurso) {
        return alunoService.buscarPorNomeCurso(nomeCurso);
    }

    @GetMapping("/buscarAluno/sobrenomeENomeCurso/{nomeCurso}")
    private List<AlunoResponse> buscarPorNomeCursoESobrenome(@RequestBody String sobrenome, @PathVariable String nomeCurso) {
        return alunoService.buscarPorNomeCursoESobrenome(nomeCurso, sobrenome);
    }

    @GetMapping("/buscarAluno/duracaoCurso")
    private List<AlunoResponse> buscarPorDuracaoCurso(@RequestParam Integer duracao) {
        return alunoService.buscarPorDuracaoCurso(duracao);
    }

    @GetMapping("/buscarAluno/nascimentoAluno")
    private List<AlunoResponse> buscarPorAnoNascimento(@RequestParam Integer ano) {
        return alunoService.buscarPorAnoNascimento(ano);
    }

    @GetMapping("/buscarAluno/buscaPorRA/{ra}")
    private AlunoResponse buscarPorId(@PathVariable Integer ra) {
        return alunoService.buscarPorId(ra);
    }

    @PostMapping("/adcionarAluno")
    private ResponseEntity<AlunoResponse> adicionarAluno(@RequestBody AlunoRequest alunoRequest,
                                                         UriComponentsBuilder uriComponentsBuilder) {
        return alunoService.adicionarAluno(alunoRequest, uriComponentsBuilder);
    }

    @DeleteMapping("deletarAluno/{ra}")
    private ResponseEntity<?> deletarAluno(@PathVariable Integer ra) {
        return alunoService.deletarAluno(ra);
    }

    @PatchMapping("atualizarAluno/{ra}")
    private ResponseEntity<AlunoResponse> atualizarAluno(@RequestBody AlunoReqAtualizar alunoReqAtualizar, @PathVariable Integer ra) {
        return alunoService.atualizarAluno(alunoReqAtualizar, ra);
    }
}