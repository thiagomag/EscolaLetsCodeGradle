package br.com.letscode.repository;

import br.com.letscode.entity.Curso;
import br.com.letscode.entity.CursoDisciplinaProfessor;
import br.com.letscode.entity.Disciplina;
import br.com.letscode.entity.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoDisciplinaProfessorRepository extends CrudRepository<CursoDisciplinaProfessor, Integer> {

    Iterable<CursoDisciplinaProfessor> findCursoDisciplinaProfessorByCodigoCurso(Curso curso);
    Iterable<CursoDisciplinaProfessor> findCursoDisciplinaProfessorByCodigoDisiciplina(Disciplina disciplina);
    Iterable<CursoDisciplinaProfessor> findCursoDisciplinaProfessorByRegistroProfessor(Professor professor);
}
