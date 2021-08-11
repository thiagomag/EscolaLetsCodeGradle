package br.com.letscode.response;

import br.com.letscode.entity.Disciplina;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class DisciplinaResponse {

    private Integer codigoDisciplina;
    private String nomeDisciplina;
    private Integer cargaPratica;
    private Integer cargaTeorica;

    public DisciplinaResponse(Disciplina disciplina) {
        this.codigoDisciplina = disciplina.getCodigoDisciplina();
        this.nomeDisciplina = disciplina.getNomeDisciplina();
        this.cargaPratica = disciplina.getCargaPratica();
        this.cargaTeorica = disciplina.getCargaTeorica();
    }

    public static List<DisciplinaResponse> convert(List<Disciplina> disciplina) {
        return disciplina.stream().map(DisciplinaResponse::new).collect(Collectors.toList());
    }
}
