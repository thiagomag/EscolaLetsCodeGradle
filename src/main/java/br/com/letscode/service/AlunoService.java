package br.com.letscode.service;

import br.com.letscode.entity.Aluno;
import br.com.letscode.exception.IdDoAlunoNaoExisteException;
import br.com.letscode.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public Iterable<Aluno> buscarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(int ra) {
        return alunoRepository.findById(ra)
                .orElseThrow(() -> new IdDoAlunoNaoExisteException(ra));
    }

    public Aluno adicionarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public void deletarAluno(int ra) {
        if(alunoRepository.findById(ra).isPresent()) {
            alunoRepository.deleteById(ra);
        } else {
            throw new IdDoAlunoNaoExisteException(ra);
        }
    }

    public Aluno atualizarAluno(Aluno aluno, int ra) {
        var alunoOptional = alunoRepository.findById(ra);
        if(alunoOptional.isPresent()) {
            if(aluno.getCodigoCurso() != null) {
                alunoOptional.get().setCodigoCurso(aluno.getCodigoCurso());
            }
            if(aluno.getNome() != null) {
                alunoOptional.get().setNome(aluno.getNome());
            }
            if(aluno.getSobrenome() != null) {
                alunoOptional.get().setSobrenome(aluno.getSobrenome());
            }
            if(aluno.getRa() != null) {
                alunoOptional.get().setRa(aluno.getRa());
            }
            if(aluno.getDataNascimento() != null) {
                alunoOptional.get().setDataNascimento(aluno.getDataNascimento());
            }
            return alunoRepository.save(alunoOptional.get());
        } else {
            throw new IdDoAlunoNaoExisteException(ra);
        }
    }
}
