package br.com.letscode.repository;

import br.com.letscode.entity.Curso;
import br.com.letscode.response.CursoResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    Curso findByNomeCurso(String nome);
    List<Curso> findByDuracaoGreaterThan(Integer duracao);
}
