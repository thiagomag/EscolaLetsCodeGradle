package br.com.letscode.response;

import br.com.letscode.entity.Aluno;
import br.com.letscode.entity.Curso;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class AlunoResponse {

    private Integer ra;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private Curso curso;

    public AlunoResponse(Aluno aluno) {
        this.ra = aluno.getRa();
        this.nome = aluno.getNome();
        this.sobrenome = aluno.getSobrenome();
        this.dataNascimento = aluno.getDataNascimento();
        this.curso = aluno.getCodigoCurso();
    }

    public static List<AlunoResponse> convert(List<Aluno> alunos) {
        return alunos.stream().map(AlunoResponse::new).collect(Collectors.toList());
    }
}
