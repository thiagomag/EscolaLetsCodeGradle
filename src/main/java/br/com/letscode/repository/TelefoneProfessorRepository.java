package br.com.letscode.repository;

import br.com.letscode.entity.Professor;
import br.com.letscode.entity.TelefoneProfessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneProfessorRepository extends JpaRepository<TelefoneProfessor, Integer> {

    TelefoneProfessor getTelefoneProfessorByRegistroProfessor(Professor professor);
}
