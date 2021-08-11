package br.com.letscode.request;

import br.com.letscode.entity.Aluno;
import br.com.letscode.exception.IdDoCursoNaoExisteException;
import br.com.letscode.repository.CursoRepository;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class AlunoRequest {

    private Integer ra;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private Integer codigoCurso;

    public Aluno convert(CursoRepository cursoRepository) {
        var curso = cursoRepository.findById(codigoCurso).orElseThrow(() -> new IdDoCursoNaoExisteException(codigoCurso));
        return Aluno.builder()
                .ra(this.ra)
                .nome(this.nome)
                .sobrenome(this.sobrenome)
                .dataNascimento(this.dataNascimento)
                .codigoCurso(curso)
                .build();
    }
}
