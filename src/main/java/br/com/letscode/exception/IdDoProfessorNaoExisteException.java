package br.com.letscode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdDoProfessorNaoExisteException extends RuntimeException {
    public IdDoProfessorNaoExisteException(Integer registroProfessor) {
        super("O registro do professor " + registroProfessor + " pesquisado, não existe no banco de dados.");
    }
}