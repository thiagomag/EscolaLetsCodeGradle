package br.com.letscode.request.update;

import br.com.letscode.entity.Disciplina;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DisciplinaReqAtualizar {

    private String nomeDisciplina;
    private Integer cargaPratica;
    private Integer cargaTeorica;

    public Disciplina convert(Integer condigoDisciplina) {
        return Disciplina.builder()
                .codigoDisciplina(condigoDisciplina)
                .nomeDisciplina(nomeDisciplina)
                .cargaTeorica(cargaTeorica)
                .cargaPratica(cargaPratica)
                .build();
    }
}
