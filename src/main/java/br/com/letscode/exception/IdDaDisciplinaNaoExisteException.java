package br.com.letscode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdDaDisciplinaNaoExisteException extends RuntimeException {
    public IdDaDisciplinaNaoExisteException(Integer codigoDisciplina) {
        super("O código da disciplina " + codigoDisciplina + " pesquisado, não existe no banco de dados.");
    }
}