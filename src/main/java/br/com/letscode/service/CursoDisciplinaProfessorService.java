package br.com.letscode.service;

import br.com.letscode.entity.CursoDisciplinaProfessor;
import br.com.letscode.exception.IdDaDisciplinaNaoExisteException;
import br.com.letscode.exception.IdDoCursoDisciplinaProfessorNaoExisteException;
import br.com.letscode.exception.IdDoCursoNaoExisteException;
import br.com.letscode.exception.IdDoProfessorNaoExisteException;
import br.com.letscode.repository.CursoDisciplinaProfessorRepository;
import br.com.letscode.repository.CursoRepository;
import br.com.letscode.repository.DisciplinaRepository;
import br.com.letscode.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoDisciplinaProfessorService {

    private final CursoDisciplinaProfessorRepository cursoDisciplinaProfessorRepository;
    private final CursoRepository cursoRepository;
    private final DisciplinaRepository disciplinaRepository;
    private final ProfessorRepository professorRepository;

    public List<CursoDisciplinaProfessor> buscarCursosDisciplinaProfessor() {
        return cursoDisciplinaProfessorRepository.findAll();
    }

    public CursoDisciplinaProfessor buscarCursosDisciplinaProfessorPorCurso(Integer codigoCurso) {
        var curso = cursoRepository.findById(codigoCurso).orElseThrow(() ->
                new IdDoCursoNaoExisteException(codigoCurso));
        return cursoDisciplinaProfessorRepository.findCursoDisciplinaProfessorByCodigoCurso(curso);
    }

    public CursoDisciplinaProfessor buscarCursosDisciplinaProfessorPorDisciplina(Integer codigoDisiciplina) {
        var disciplina = disciplinaRepository.findById(codigoDisiciplina).orElseThrow(() ->
                new IdDaDisciplinaNaoExisteException(codigoDisiciplina));
        return cursoDisciplinaProfessorRepository.findCursoDisciplinaProfessorByCodigoDisiciplina(disciplina);
    }

    public CursoDisciplinaProfessor buscarCursosDisciplinaProfessorPorProfessor(Integer registroProfessor) {
        var professor = professorRepository.findById(registroProfessor).orElseThrow(() ->
                new IdDoProfessorNaoExisteException(registroProfessor));
        return cursoDisciplinaProfessorRepository.findCursoDisciplinaProfessorByRegistroProfessor(professor);
    }

    public CursoDisciplinaProfessor adicionar(CursoDisciplinaProfessor cursoDisciplinaProfessor) {
        return cursoDisciplinaProfessorRepository.save(cursoDisciplinaProfessor);
    }

    public void deletar(Integer id) {
        if(cursoDisciplinaProfessorRepository.findById(id).isPresent()) {
            cursoDisciplinaProfessorRepository.deleteById(id);
        } else {
            throw new IdDoCursoDisciplinaProfessorNaoExisteException(id);
        }
    }

    public CursoDisciplinaProfessor atualizar(CursoDisciplinaProfessor cursoDisciplinaProfessor, Integer id) {
        var cursoDisciplinaProfessorPesquisado = cursoDisciplinaProfessorRepository.findById(id)
                .orElseThrow(() -> new IdDoCursoDisciplinaProfessorNaoExisteException(id));
        if(cursoDisciplinaProfessor.getCodigoCurso() != null) {
            cursoDisciplinaProfessorPesquisado.setCodigoCurso(cursoDisciplinaProfessor.getCodigoCurso());
        }
        if(cursoDisciplinaProfessor.getRegistroProfessor() != null) {
            cursoDisciplinaProfessorPesquisado.setRegistroProfessor(cursoDisciplinaProfessor.getRegistroProfessor());
        }
        if(cursoDisciplinaProfessor.getCodigoDisiciplina() != null) {
            cursoDisciplinaProfessorPesquisado.setCodigoDisiciplina(cursoDisciplinaProfessor.getCodigoDisiciplina());
        }
        return cursoDisciplinaProfessorPesquisado;
    }
}