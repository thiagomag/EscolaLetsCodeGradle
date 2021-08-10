package br.com.letscode.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @Column(name = "codigo_curso")
    private Integer codigoCurso;

    @Column(name = "nome_curso")
    private String nomeCurso;

    private Integer duracao;

    @Column(name = "numero_alunos")
    private Integer numeroAlunos;

    @Enumerated(EnumType.STRING)
    private Modalidade modalidade;
}