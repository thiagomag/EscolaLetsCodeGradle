package br.com.letscode.request.update;

import br.com.letscode.entity.Aluno;
import br.com.letscode.exception.IdDoCursoNaoExisteException;
import br.com.letscode.repository.CursoRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AlunoReqAtualizar {

    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private Integer codigoCurso;

    public Aluno convert(CursoRepository cursoRepository, Integer ra) {
        var curso = cursoRepository.findById(this.codigoCurso).orElseThrow(() -> new IdDoCursoNaoExisteException(this.codigoCurso));
        return Aluno.builder()
                .ra(ra)
                .nome(this.nome)
                .sobrenome(this.sobrenome)
                .dataNascimento(this.dataNascimento)
                .codigoCurso(curso)
                .build();
    }
}
