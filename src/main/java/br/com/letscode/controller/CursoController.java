package br.com.letscode.controller;

import br.com.letscode.request.update.CursoReqAtualizar;
import br.com.letscode.request.CursoRequest;
import br.com.letscode.response.CursoResponse;
import br.com.letscode.service.CursoService;
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
@RequestMapping("cursos")
public class CursoController {

    private final CursoService cursoService;

    @GetMapping("/buscarCursos")
    private List<CursoResponse> buscarCursos() {
        return cursoService.buscarCursos();
    }

    @GetMapping("/buscarCursos/buscarPorId/{codigoCurso}")
    private CursoResponse buscarPorId(@PathVariable Integer codigoCurso) {
        return cursoService.buscarPorId(codigoCurso);
    }

    @GetMapping("/buscarCursos/buscaPorNome/{nome}")
    private CursoResponse buscarPorNome(@PathVariable String nome) {
        return cursoService.buscarPorNome(nome);
    }

    @GetMapping("/buscarCursos/buscarPorDuracao/{duracao}")
    private List<CursoResponse> buscarPorDuracaoMaiorQue(@PathVariable Integer duracao) {
        return cursoService.buscarPorDuracaoMaiorQue(duracao);
    }

    @PostMapping("/adicionarCurso")
    private ResponseEntity<CursoResponse> adicionarCurso(@RequestBody CursoRequest cursoRequest,
                                         UriComponentsBuilder uriComponentsBuilder) {
        return cursoService.adicionarCurso(cursoRequest, uriComponentsBuilder);
    }

    @DeleteMapping("/deletarCurso/{codigoCurso}")
    private ResponseEntity<?> deletarCurso(@PathVariable Integer codigoCurso) {
        return cursoService.deletarCurso(codigoCurso);
    }

    @PatchMapping("/atualizarCurso/{codigoCurso}")
    private ResponseEntity<CursoResponse> atualizarCurso(@RequestBody CursoReqAtualizar cursoReqAtualizar,
                                                         @PathVariable Integer codigoCurso) {
        return cursoService.atualizarCurso(cursoReqAtualizar, codigoCurso);
    }
}

