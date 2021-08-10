package br.com.letscode.service;

import br.com.letscode.entity.Professor;
import br.com.letscode.exception.IdDoProfessorNaoExisteException;
import br.com.letscode.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;


    public Iterable<Professor> buscarProfessores() {
        return professorRepository.findAll();
    }

    public Professor buscarPorId(Integer registroProfessor) {
        return professorRepository.findById(registroProfessor)
                .orElseThrow(() -> new IdDoProfessorNaoExisteException(registroProfessor));
    }

    public Professor adicionarProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public void deletarProfessor(Integer registroProfessor) {
        if(professorRepository.findById(registroProfessor).isPresent()) {
            professorRepository.deleteById(registroProfessor);
        } else {
            throw new IdDoProfessorNaoExisteException(registroProfessor);
        }
    }

    public Professor atualizarProfessro(Professor professor, Integer registroProfessor) {
        var professorPesquisado = professorRepository.findById(registroProfessor)
                .orElseThrow(() -> new IdDoProfessorNaoExisteException(registroProfessor));
        if(professor.getRegistroProfessor() != null) {
            professorPesquisado.setRegistroProfessor(professor.getRegistroProfessor());
        }
        if(professor.getNome() != null) {
            professorPesquisado.setNome(professor.getNome());
        }
        return professorRepository.save(professorPesquisado);
    }
}