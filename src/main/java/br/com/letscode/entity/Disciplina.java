package br.com.letscode.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "disciplina")
public class Disciplina {

    @Id
    @Column(name = "codigo_disciplina")
    private Integer codigoDisciplina;

    @Column(name = "nome_disciplina")
    private String nomeDisciplina;

    @Column(name = "carga_horaria_pratica")
    private Integer cargaPratica;

    @Column(name = "carga_horaria_teorica")
    private Integer cargaTeorica;
}