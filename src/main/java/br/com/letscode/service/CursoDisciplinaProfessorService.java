package br.com.letscode.service;

import br.com.letscode.entity.CursoDisciplinaProfessor;
import br.com.letscode.exception.IdDoCursoDisciplinaProfessorNaoExisteException;
import br.com.letscode.repository.CursoDisciplinaProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoDisciplinaProfessorService {

    private final CursoDisciplinaProfessorRepository cursoDisciplinaProfessorRepository;
    private final CursoService cursoService;
    private final DisciplinaService disciplinaService;
    private final ProfessorService professorService;

    public Iterable<CursoDisciplinaProfessor> buscarCursosDisciplinaProfessor() {
        return cursoDisciplinaProfessorRepository.findAll();
    }

    public Iterable<CursoDisciplinaProfessor> buscarCursosDisciplinaProfessorPorCurso(Integer codigoCurso) {
        var curso = cursoService.buscarPorId(codigoCurso);
        return cursoDisciplinaProfessorRepository.findCursoDisciplinaProfessorByCodigoCurso(curso);
    }

    public Iterable<CursoDisciplinaProfessor> buscarCursosDisciplinaProfessorPorDisciplina(Integer codigoDisiciplina) {
        var disciplina = disciplinaService.buscarPorId(codigoDisiciplina);
        return cursoDisciplinaProfessorRepository.findCursoDisciplinaProfessorByCodigoDisiciplina(disciplina);
    }

    public Iterable<CursoDisciplinaProfessor> buscarCursosDisciplinaProfessorPorProfessor(Integer registroProfessor) {
        var professor = professorService.buscarPorId(registroProfessor);
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