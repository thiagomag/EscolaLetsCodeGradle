package br.com.letscode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdDoAlunoNaoExisteException extends RuntimeException {
    public IdDoAlunoNaoExisteException(int ra) {
        super("O RA " + ra + " pesquisado, não existe no banco de dados.");
    }
}