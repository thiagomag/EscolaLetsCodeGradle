package br.com.letscode.request;

import br.com.letscode.entity.Curso;
import br.com.letscode.entity.Modalidade;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CursoReqAtualizar {

    private String nomeCurso;
    private Integer duracao;
    private Integer numeroAlunos;

    public Curso convert(Integer codigoCurso) {
        return Curso.builder()
                .codigoCurso(codigoCurso)
                .nomeCurso(nomeCurso)
                .duracao(duracao)
                .numeroAlunos(numeroAlunos)
                .modalidade(Modalidade.PRESENCIAL)
                .build();
    }
}
