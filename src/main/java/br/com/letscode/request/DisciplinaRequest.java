package br.com.letscode.request;

import br.com.letscode.entity.Disciplina;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DisciplinaRequest {

    private Integer codigoDisciplina;
    private String nomeDisciplina;
    private Integer cargaPratica;
    private Integer cargaTeorica;

    public Disciplina convert() {
        return Disciplina.builder()
                .codigoDisciplina(codigoDisciplina)
                .nomeDisciplina(nomeDisciplina)
                .cargaPratica(cargaPratica)
                .cargaTeorica(cargaTeorica)
                .build();
    }
}