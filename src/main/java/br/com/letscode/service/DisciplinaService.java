package br.com.letscode.service;

import br.com.letscode.exception.IdDaDisciplinaNaoExisteException;
import br.com.letscode.repository.DisciplinaRepository;
import br.com.letscode.request.update.DisciplinaReqAtualizar;
import br.com.letscode.request.DisciplinaRequest;
import br.com.letscode.response.DisciplinaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public List<DisciplinaResponse> buscarDisciplinas() {
        var disciplina = disciplinaRepository.findAll();
        return DisciplinaResponse.convert(disciplina);
    }

    public DisciplinaResponse buscarPorId(Integer codigoDisciplina) {
        var disciplina = disciplinaRepository.findById(codigoDisciplina)
                .orElseThrow(() -> new IdDaDisciplinaNaoExisteException(codigoDisciplina));
        return new DisciplinaResponse(disciplina);
    }


    public ResponseEntity<DisciplinaResponse> adicionarDisciplina(DisciplinaRequest disciplinaRequest,
                                                                  UriComponentsBuilder uriComponentsBuilder) {
        var disciplina = disciplinaRequest.convert();
        disciplinaRepository.save(disciplina);
        var uri = uriComponentsBuilder.path("/buscarDisciplina/{codigoDisciplina}").buildAndExpand(disciplina
                .getCodigoDisciplina()).toUri();
        return ResponseEntity.created(uri).body(new DisciplinaResponse(disciplina));
    }


    public ResponseEntity<?> deletarDisciplina(Integer codigoDisciplina) {
        if(disciplinaRepository.findById(codigoDisciplina).isPresent()) {
            disciplinaRepository.deleteById(codigoDisciplina);
            return ResponseEntity.ok().build();
        } else {
            throw new IdDaDisciplinaNaoExisteException(codigoDisciplina);
        }
    }


    public ResponseEntity<DisciplinaResponse> atualizarDisciplina(DisciplinaReqAtualizar disciplinaReqAtualizar,
                                                                  Integer codigoDisciplina) {
        var disciplinaOptional = disciplinaRepository.findById(codigoDisciplina).orElseThrow(() ->
                new IdDaDisciplinaNaoExisteException(codigoDisciplina));
        if(disciplinaReqAtualizar.getNomeDisciplina() == null) {
            disciplinaReqAtualizar.setNomeDisciplina(disciplinaOptional.getNomeDisciplina());
        }
        if(disciplinaReqAtualizar.getCargaPratica() == null) {
            disciplinaReqAtualizar.setCargaPratica(disciplinaOptional.getCargaPratica());
        }
        if(disciplinaReqAtualizar.getCargaTeorica() == null) {
            disciplinaReqAtualizar.setCargaTeorica(disciplinaOptional.getCargaTeorica());
        }
        var disciplina = disciplinaReqAtualizar.convert(codigoDisciplina);
        disciplinaRepository.save(disciplina);
        return ResponseEntity.ok(new DisciplinaResponse(disciplina));
    }
}
