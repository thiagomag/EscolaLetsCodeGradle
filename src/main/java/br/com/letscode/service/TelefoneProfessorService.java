package br.com.letscode.service;

import br.com.letscode.exception.IdDoProfessorNaoExisteException;
import br.com.letscode.exception.IdDoTelefoneNaoExisteException;
import br.com.letscode.repository.ProfessorRepository;
import br.com.letscode.repository.TelefoneProfessorRepository;
import br.com.letscode.request.TelefoneProfessorReqAtualizar;
import br.com.letscode.request.TelefoneProfessorRequest;
import br.com.letscode.response.TelefoneProfessorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TelefoneProfessorService {

    private final TelefoneProfessorRepository telefoneProfessorRepository;
    private final ProfessorRepository professorRepository;

    public List<TelefoneProfessorResponse> buscarTelefones() {
        var telefoneProfessor = telefoneProfessorRepository.findAll();
        return TelefoneProfessorResponse.convert(telefoneProfessor);
    }

    public TelefoneProfessorResponse buscarTelefonesProfessor(Integer registroProfessor) {
        var professor = professorRepository.findById(registroProfessor).orElseThrow(() ->
                new IdDoProfessorNaoExisteException(registroProfessor));
        var telefoneProfessor =  telefoneProfessorRepository
                .getTelefoneProfessorByRegistroProfessor(professor);
        return new TelefoneProfessorResponse(telefoneProfessor);
    }

    public ResponseEntity<TelefoneProfessorResponse> cadastrarTelefone(TelefoneProfessorRequest telefoneProfessorRequest,
                                                               UriComponentsBuilder uriComponentsBuilder) {
        var telefoneProfessor = telefoneProfessorRequest.convert(professorRepository);
        telefoneProfessorRepository.save(telefoneProfessor);
        var uri = uriComponentsBuilder.path("/buscarTelefone/{idtelefone}").buildAndExpand(
                telefoneProfessor.getId()).toUri();
        return ResponseEntity.created(uri).body(new TelefoneProfessorResponse(telefoneProfessor));
    }

    public TelefoneProfessorResponse buscarTelefonePorId(Integer idTelefone) {
        var telefoneProfessor = telefoneProfessorRepository.findById(idTelefone)
                .orElseThrow(() -> new IdDoTelefoneNaoExisteException(idTelefone));
        return new TelefoneProfessorResponse(telefoneProfessor);
    }

    public ResponseEntity<?> deletarTelefone(Integer idTelefone) {
        if(telefoneProfessorRepository.findById(idTelefone).isPresent()) {
            telefoneProfessorRepository.deleteById(idTelefone);
            return ResponseEntity.ok().build();
        } else {
            throw new IdDoTelefoneNaoExisteException(idTelefone);
        }
    }

    public ResponseEntity<TelefoneProfessorResponse> atualizarTelefone(
            TelefoneProfessorReqAtualizar telefoneProfessorReqAtualizar, Integer idTelefone) {
        var telefoneOptional = telefoneProfessorRepository.findById(idTelefone).orElseThrow(() ->
                new IdDoTelefoneNaoExisteException(idTelefone));
        if(telefoneProfessorReqAtualizar.getRegistroProfessor() == null) {
            telefoneProfessorReqAtualizar.setRegistroProfessor(telefoneOptional.getRegistroProfessor()
                    .getRegistroProfessor());
        }
        if(telefoneProfessorReqAtualizar.getNumero() == null) {
            telefoneProfessorReqAtualizar.setNumero(telefoneOptional.getNumero());
        }
        var telefoneProfessor = telefoneProfessorReqAtualizar.convert(professorRepository, idTelefone);
        telefoneProfessorRepository.save(telefoneProfessor);
        return ResponseEntity.ok(new TelefoneProfessorResponse(telefoneProfessor));
    }
}