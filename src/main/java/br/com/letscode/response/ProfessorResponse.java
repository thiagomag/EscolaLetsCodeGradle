package br.com.letscode.response;

import br.com.letscode.entity.Professor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class ProfessorResponse {

    private Integer registroProfessor;
    private String nome;

    public ProfessorResponse(Professor professor) {
        this.registroProfessor = professor.getRegistroProfessor();
        this.nome = professor.getNome();
    }

    public static List<ProfessorResponse> convert(List<Professor> professor) {
        return professor.stream().map(ProfessorResponse::new).collect(Collectors.toList());
    }
}
