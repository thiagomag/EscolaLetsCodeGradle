package br.com.letscode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdDoCursoDisciplinaProfessorNaoExisteException extends RuntimeException {
    public IdDoCursoDisciplinaProfessorNaoExisteException(Integer id) {
        super("O id " + id + " pesquisado, não existe no banco de dados.");
    }
}