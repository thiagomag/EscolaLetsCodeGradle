package br.com.letscode.service;

import br.com.letscode.entity.Disciplina;
import br.com.letscode.exception.IdDaDisciplinaNaoExisteException;
import br.com.letscode.repository.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public Iterable<Disciplina> buscarDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public Disciplina buscarPorId(Integer codigoDisciplina) {
        return disciplinaRepository.findById(codigoDisciplina)
                .orElseThrow(() -> new IdDaDisciplinaNaoExisteException(codigoDisciplina));
    }


    public Disciplina adicionarDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }


    public void deletarDisciplina(Integer codigoDisciplina) {
        if(disciplinaRepository.findById(codigoDisciplina).isPresent()) {
            disciplinaRepository.deleteById(codigoDisciplina);
        } else {
            throw new IdDaDisciplinaNaoExisteException(codigoDisciplina);
        }
    }


    public Disciplina atualizarDisciplina(Disciplina disciplina, Integer codigoDisciplina) {
        var disciplinaPesquisada = disciplinaRepository.findById(codigoDisciplina)
                .orElseThrow(() -> new IdDaDisciplinaNaoExisteException(codigoDisciplina));
        validarDisciplina(disciplina, disciplinaPesquisada);
        return disciplinaRepository.save(disciplinaPesquisada);
    }

    private void validarDisciplina(Disciplina disciplina, Disciplina disciplinaPesquisada) {
        if(disciplina.getNomeDisciplina() != null) {
            disciplinaPesquisada.setNomeDisciplina(disciplina.getNomeDisciplina());
        }
        if(disciplina.getCodigoDisciplina() != null) {
            disciplinaPesquisada.setCodigoDisciplina(disciplina.getCodigoDisciplina());
        }
        if(disciplina.getCargaPratica() != null) {
            disciplinaPesquisada.setCargaPratica(disciplina.getCargaPratica());
        }
        if(disciplina.getCargaTeorica() != null) {
            disciplinaPesquisada.setCargaTeorica(disciplina.getCargaTeorica());
        }
    }
}
