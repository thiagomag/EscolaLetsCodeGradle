package br.com.letscode.service;

import br.com.letscode.exception.IdDoProfessorNaoExisteException;
import br.com.letscode.repository.ProfessorRepository;
import br.com.letscode.request.ProfessorReqAtualizar;
import br.com.letscode.request.ProfessorRequest;
import br.com.letscode.response.ProfessorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;


    public List<ProfessorResponse> buscarProfessores() {
        var professor = professorRepository.findAll();
        return ProfessorResponse.convert(professor);
    }

    public ProfessorResponse buscarPorId(Integer registroProfessor) {
        var professor = professorRepository.findById(registroProfessor)
                .orElseThrow(() -> new IdDoProfessorNaoExisteException(registroProfessor));
        return new ProfessorResponse(professor);
    }

    public ResponseEntity<ProfessorResponse> adicionarProfessor(ProfessorRequest professorRequest,
                                                                UriComponentsBuilder uriComponentsBuilder) {
        var professor = professorRequest.convert();
        professorRepository.save(professor);
        var uri = uriComponentsBuilder.path("/buscarProfessor/{registroProfessor}").buildAndExpand(
                professor.getRegistroProfessor()).toUri();
        return ResponseEntity.created(uri).body(new ProfessorResponse(professor));
    }

    public ResponseEntity<?> deletarProfessor(Integer registroProfessor) {
        if(professorRepository.findById(registroProfessor).isPresent()) {
            professorRepository.deleteById(registroProfessor);
            return ResponseEntity.ok().build();
        } else {
            throw new IdDoProfessorNaoExisteException(registroProfessor);
        }
    }

    public ResponseEntity<ProfessorResponse> atualizarProfessor(ProfessorReqAtualizar professorReqAtualizar,
                                                                Integer registroProfessor) {
        var professor = professorReqAtualizar.convert(registroProfessor);
        professorRepository.save(professor);
        return ResponseEntity.ok(new ProfessorResponse(professor));
    }
}