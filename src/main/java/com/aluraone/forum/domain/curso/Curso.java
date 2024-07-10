package com.aluraone.forum.domain.curso;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import com.aluraone.forum.domain.topico.Topico;

@Entity(name="cursos")
@Table(name="cursos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;


    @OneToMany(mappedBy = "curso")
    private List<Topico> topicos = new ArrayList<>();


    public Curso(DadosCursoDto dto){
        this.nome = dto.nome();
    }

    public Curso(Long id, String nome){
        this.id = id;
        this.nome = nome;
    }


}
