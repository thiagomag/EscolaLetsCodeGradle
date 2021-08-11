package br.com.letscode.repository;

import br.com.letscode.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    List<Aluno> findByNome(String nome);

    List<Aluno> findByCodigoCurso_NomeCurso(String nomeCurso);

    List<Aluno> findByCodigoCursoNomeCursoAndSobrenome(String nomeCurso, String sobrenome);

    List<Aluno> findByCodigoCursoDuracaoEquals(Integer duracaoCurso);

    @Query(value = "SELECT * FROM aluno WHERE YEAR (data_nascimento) = ?1", nativeQuery = true)
    List<Aluno> findByAnoNascimento(Integer ano);
}
