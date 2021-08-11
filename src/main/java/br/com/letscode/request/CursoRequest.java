package br.com.letscode.request;

import br.com.letscode.entity.Curso;
import br.com.letscode.entity.Modalidade;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CursoRequest {

    private Integer codigoCurso;
    private String nomeCurso;
    private Integer duracao;
    private Integer numeroAlunos;

    public Curso convert() {
        return Curso.builder()
                .codigoCurso(codigoCurso)
                .nomeCurso(nomeCurso)
                .duracao(duracao)
                .numeroAlunos(numeroAlunos)
                .modalidade(Modalidade.PRESENCIAL)
                .build();
    }
}
