package br.com.letscode.service;

import br.com.letscode.exception.IdDoCursoNaoExisteException;
import br.com.letscode.repository.CursoRepository;
import br.com.letscode.request.update.CursoReqAtualizar;
import br.com.letscode.request.CursoRequest;
import br.com.letscode.response.CursoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;

    public List<CursoResponse> buscarCursos() {
        var cursos = cursoRepository.findAll();
        return CursoResponse.convert(cursos);
    }

    public CursoResponse buscarPorId(Integer codigoCurso) {
        var curso = cursoRepository.findById(codigoCurso)
                .orElseThrow(() -> new IdDoCursoNaoExisteException(codigoCurso));
        return new CursoResponse(curso);
    }

    public CursoResponse buscarPorNome(String nome) {
        var curso = cursoRepository.findByNomeCurso(nome);
        return new CursoResponse(curso);
    }

    public List<CursoResponse> buscarPorDuracaoMaiorQue(Integer duracao) {
        var cursos = cursoRepository.findByDuracaoGreaterThan(duracao);
        return CursoResponse.convert(cursos);
    }

    public ResponseEntity<CursoResponse> adicionarCurso(CursoRequest cursoRequest,
                                                        UriComponentsBuilder uriComponentsBuilder) {
        var curso = cursoRequest.convert();
        cursoRepository.save(curso);
        var uri = uriComponentsBuilder.path("/buscarCursos/{codigoCurso}").buildAndExpand(curso
                .getCodigoCurso()).toUri();
        return ResponseEntity.created(uri).body(new CursoResponse(curso));

    }

    public ResponseEntity<?> deletarCurso(Integer codigoCurso) {
        if(cursoRepository.findById(codigoCurso).isPresent()) {
            cursoRepository.deleteById(codigoCurso);
            return ResponseEntity.ok().build();
        } else {
            throw new IdDoCursoNaoExisteException(codigoCurso);
        }
    }

    public ResponseEntity<CursoResponse> atualizarCurso(CursoReqAtualizar cursoReqAtualizar, Integer codigoCurso) {
        var cursoOptional = cursoRepository.findById(codigoCurso).orElseThrow(() -> new IdDoCursoNaoExisteException(codigoCurso));
        if(cursoReqAtualizar.getNomeCurso() == null) {
            cursoReqAtualizar.setNomeCurso(cursoOptional.getNomeCurso());
        }
        if(cursoReqAtualizar.getDuracao() == null) {
            cursoReqAtualizar.setDuracao(cursoOptional.getDuracao());
        }
        if(cursoReqAtualizar.getNumeroAlunos() == null) {
            cursoReqAtualizar.setNumeroAlunos(cursoOptional.getNumeroAlunos());
        }
        var curso = cursoReqAtualizar.convert(codigoCurso);
        cursoRepository.save(curso);
        return ResponseEntity.ok(new CursoResponse(curso));
    }


}
