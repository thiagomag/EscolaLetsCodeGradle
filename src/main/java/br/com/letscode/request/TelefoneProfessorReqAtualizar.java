package br.com.letscode.request;

import br.com.letscode.entity.TelefoneProfessor;
import br.com.letscode.exception.IdDoProfessorNaoExisteException;
import br.com.letscode.repository.ProfessorRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TelefoneProfessorReqAtualizar {

    private Integer numero;
    private Integer registroProfessor;

    public TelefoneProfessor convert(ProfessorRepository professorRepository, Integer id) {
        var professor = professorRepository.findById(this.registroProfessor).orElseThrow(() -> new IdDoProfessorNaoExisteException(registroProfessor));
        return TelefoneProfessor.builder()
                .id(id)
                .numero(numero)
                .registroProfessor(professor)
                .build();
    }
}
