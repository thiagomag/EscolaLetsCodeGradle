package br.com.letscode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdDoCursoNaoExisteException extends RuntimeException {
    public IdDoCursoNaoExisteException(int codigoCurso) {
        super("O código do curso " + codigoCurso + " pesquisado, não existe no banco de dados.");
    }
}