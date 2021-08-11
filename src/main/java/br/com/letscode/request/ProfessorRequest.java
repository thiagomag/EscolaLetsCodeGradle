package br.com.letscode.request;

import br.com.letscode.entity.Professor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProfessorRequest {

    private Integer registroProfessor;
    private String nome;

    public Professor convert() {
        return Professor.builder()
                .registroProfessor(registroProfessor)
                .nome(nome)
                .build();
    }
}
