package br.com.letscode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdDoTelefoneNaoExisteException extends RuntimeException {
    public IdDoTelefoneNaoExisteException(Integer idTelefone) {
        super("O id do telefone " + idTelefone + " pesquisado, não existe no banco de dados.");
    }
}