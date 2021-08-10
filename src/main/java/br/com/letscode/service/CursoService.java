package br.com.letscode.service;

import br.com.letscode.entity.Curso;
import br.com.letscode.exception.IdDoCursoNaoExisteException;
import br.com.letscode.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;

    public Iterable<Curso> buscarCursos() {
        return cursoRepository.findAll();
    }

    public Curso buscarPorId(int codigoCurso) {
        return cursoRepository.findById(codigoCurso)
                .orElseThrow(() -> new IdDoCursoNaoExisteException(codigoCurso));
    }

    public Curso adicionarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void deletarCurso(int codigoCurso) {
        if(cursoRepository.findById(codigoCurso).isPresent()) {
            cursoRepository.deleteById(codigoCurso);
        } else {
            throw new IdDoCursoNaoExisteException(codigoCurso);
        }
    }

    public Curso atualizarCurso(Curso curso, int codigoCurso) {
        var cursoPesquisado = cursoRepository.findById(codigoCurso)
                .orElseThrow(() -> new IdDoCursoNaoExisteException(codigoCurso));
        validarCurso(curso, cursoPesquisado);
        return cursoRepository.save(cursoPesquisado);
    }

    private void validarCurso(Curso curso, Curso cursoPesquisado) {
        if(curso.getNomeCurso() != null) {
            cursoPesquisado.setNomeCurso(curso.getNomeCurso());
        }
        if(curso.getDuracao() != null) {
            cursoPesquisado.setDuracao(curso.getDuracao());
        }
        if(curso.getModalidade() != null) {
            cursoPesquisado.setModalidade(curso.getModalidade());
        }
        if(curso.getCodigoCurso() != null) {
            cursoPesquisado.setCodigoCurso(curso.getCodigoCurso());
        }
        if(curso.getNumeroAlunos() != null) {
            cursoPesquisado.setNumeroAlunos(curso.getNumeroAlunos());
        }
    }
}
