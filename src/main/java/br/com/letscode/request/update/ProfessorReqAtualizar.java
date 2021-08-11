package br.com.letscode.request.update;

import br.com.letscode.entity.Professor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfessorReqAtualizar {

    private String nome;

    public Professor convert(Integer registroProfessor) {
        return Professor.builder()
                .registroProfessor(registroProfessor)
                .nome(this.nome)
                .build();
    }
}
