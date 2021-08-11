package br.com.letscode.service;

import br.com.letscode.exception.IdDoAlunoNaoExisteException;
import br.com.letscode.repository.AlunoRepository;
import br.com.letscode.repository.CursoRepository;
import br.com.letscode.request.update.AlunoReqAtualizar;
import br.com.letscode.request.AlunoRequest;
import br.com.letscode.response.AlunoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public List<AlunoResponse> buscarTodos() {
        var aluno = alunoRepository.findAll();
        return AlunoResponse.convert(aluno);
    }

    public List<AlunoResponse> buscarPorNome(String nome) {
        var aluno = alunoRepository.findByNome(nome);
        return AlunoResponse.convert(aluno);
    }
    public List<AlunoResponse> buscarPorNomeCurso(String nomeCurso) {
        var aluno = alunoRepository.findByCodigoCurso_NomeCurso(nomeCurso);
        return AlunoResponse.convert(aluno);
    }

    public List<AlunoResponse> buscarPorNomeCursoESobrenome(String nomeCurso, String sobrenome) {
        var aluno = alunoRepository.findByCodigoCursoNomeCursoAndSobrenome(nomeCurso, sobrenome);
        return AlunoResponse.convert(aluno);
    }

    public List<AlunoResponse> buscarPorDuracaoCurso(Integer duracaoCurso) {
        var aluno = alunoRepository.findByCodigoCursoDuracaoEquals(duracaoCurso);
        return AlunoResponse.convert(aluno);
    }

    public List<AlunoResponse> buscarPorAnoNascimento(Integer ano) {
        var aluno = alunoRepository.findByAnoNascimento(ano);
        return AlunoResponse.convert(aluno);
    }

    public AlunoResponse buscarPorId(int ra) {
        var aluno = alunoRepository.findById(ra).orElseThrow(() -> new IdDoAlunoNaoExisteException(ra));
        return new AlunoResponse(aluno);
    }

    public ResponseEntity<AlunoResponse> adicionarAluno(AlunoRequest alunoRequest, UriComponentsBuilder uriComponentsBuilder) {
        var aluno = alunoRequest.convert(cursoRepository);
        alunoRepository.save(aluno);
        var uri = uriComponentsBuilder.path("/alunos/buscarAlunos/{ra}").buildAndExpand(aluno.getRa()).toUri();
        return ResponseEntity.created(uri).body(new AlunoResponse(aluno));
    }

    public ResponseEntity<?> deletarAluno(int ra) {
        if(alunoRepository.findById(ra).isPresent()) {
            alunoRepository.deleteById(ra);
            return ResponseEntity.ok().build();
        } else {
            throw new IdDoAlunoNaoExisteException(ra);
        }
    }

    public ResponseEntity<AlunoResponse> atualizarAluno(AlunoReqAtualizar alunoReqAtualizar, int ra) {
        var alunoOptional = alunoRepository.findById(ra).orElseThrow(() -> new IdDoAlunoNaoExisteException(ra));
        if(alunoReqAtualizar.getNome() == null) {
            alunoReqAtualizar.setNome(alunoOptional.getNome());
        }
        if(alunoReqAtualizar.getSobrenome() == null) {
            alunoReqAtualizar.setSobrenome(alunoOptional.getSobrenome());
        }
        if(alunoReqAtualizar.getDataNascimento() == null) {
            alunoReqAtualizar.setDataNascimento(alunoOptional.getDataNascimento());
        }
        if(alunoReqAtualizar.getCodigoCurso() == null) {
            alunoReqAtualizar.setCodigoCurso(alunoOptional.getCodigoCurso().getCodigoCurso());
        }
        var aluno = alunoReqAtualizar.convert(cursoRepository, ra);
        alunoRepository.save(aluno);
        return ResponseEntity.ok(new AlunoResponse(aluno));
    }
}