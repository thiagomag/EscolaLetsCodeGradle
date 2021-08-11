package br.com.letscode.response;

import br.com.letscode.entity.Professor;
import br.com.letscode.entity.TelefoneProfessor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class TelefoneProfessorResponse {

    private Integer id;
    private Integer numero;
    private Professor registroProfessor;

    public TelefoneProfessorResponse(TelefoneProfessor telefoneProfessor) {
        this.id = telefoneProfessor.getId();
        this.numero = telefoneProfessor.getNumero();
        this.registroProfessor = telefoneProfessor.getRegistroProfessor();
    }

    public static List<TelefoneProfessorResponse> convert(List<TelefoneProfessor> telefoneProfessor) {
        return telefoneProfessor.stream().map(TelefoneProfessorResponse::new).collect(Collectors.toList());
    }
}
