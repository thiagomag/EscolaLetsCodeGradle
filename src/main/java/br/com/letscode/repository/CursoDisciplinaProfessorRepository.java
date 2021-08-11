package br.com.letscode.repository;

import br.com.letscode.entity.Curso;
import br.com.letscode.entity.CursoDisciplinaProfessor;
import br.com.letscode.entity.Disciplina;
import br.com.letscode.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoDisciplinaProfessorRepository extends JpaRepository<CursoDisciplinaProfessor, Integer> {

    CursoDisciplinaProfessor findCursoDisciplinaProfessorByCodigoCurso(Curso curso);
    CursoDisciplinaProfessor findCursoDisciplinaProfessorByCodigoDisiciplina(Disciplina disciplina);
    CursoDisciplinaProfessor findCursoDisciplinaProfessorByRegistroProfessor(Professor professor);
}
