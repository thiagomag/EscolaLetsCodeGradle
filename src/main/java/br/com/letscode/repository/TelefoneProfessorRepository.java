package br.com.letscode.repository;

import br.com.letscode.entity.Professor;
import br.com.letscode.entity.TelefoneProfessor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneProfessorRepository extends CrudRepository<TelefoneProfessor, Integer> {

    Iterable<TelefoneProfessor> getTelefoneProfessorByRegistroProfessor(Professor professor);
}
