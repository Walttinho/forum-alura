package com.aluraone.forum.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

import com.aluraone.forum.domain.curso.Curso;
import com.aluraone.forum.domain.usuario.Usuario;

@Entity(name="Topico")
@Table(name="topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;

    @Column(name="data_criacao")
    private LocalDateTime dataCriacao;

    private boolean status;

    @ManyToOne
    @JoinColumn(name="id_curso")//nome da coluna na tabela
    private Curso curso;

    @ManyToOne
    @JoinColumn(name="id_autor")//nome da coluna na tabela
    private Usuario autor;


    public Topico(DadosTopicoDto topicoDto){

        this.titulo = topicoDto.titulo();
        this.mensagem = topicoDto.mensagem();
        this.status = true;
        System.out.println(LocalDateTime.now());
        this.dataCriacao = LocalDateTime.now();
        this.setCurso(new Curso(topicoDto.curso().id(), topicoDto.curso().nome()));

    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void inactivarTopico(){
        this.status = false;
    }
}
