package br.com.letscode.response;


import br.com.letscode.entity.Curso;
import br.com.letscode.entity.Modalidade;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class CursoResponse {

    private Integer codigoCurso;
    private String nomeCurso;
    private Integer duracao;
    private Integer numeroAlunos;
    private Modalidade modalidade;

    public CursoResponse(Curso curso) {
        this.codigoCurso = curso.getCodigoCurso();
        this.nomeCurso = curso.getNomeCurso();
        this.duracao = curso.getDuracao();
        this.numeroAlunos = curso.getNumeroAlunos();
        this.modalidade = curso.getModalidade();
    }

    public static List<CursoResponse> convert(List<Curso> curso) {
        return curso.stream().map(CursoResponse::new).collect(Collectors.toList());
    }
}
