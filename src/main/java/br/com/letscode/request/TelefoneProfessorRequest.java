package br.com.letscode.request;

import br.com.letscode.entity.TelefoneProfessor;
import br.com.letscode.exception.IdDoProfessorNaoExisteException;
import br.com.letscode.repository.ProfessorRepository;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TelefoneProfessorRequest {

    private Integer id;
    private Integer numero;
    private Integer registroProfessor;

    public TelefoneProfessor convert(ProfessorRepository professorRepository) {
        var professor = professorRepository.findById(registroProfessor).orElseThrow(() -> new IdDoProfessorNaoExisteException(registroProfessor));
        return TelefoneProfessor.builder()
                .id(id)
                .numero(numero)
                .registroProfessor(professor)
                .build();
    }
}
