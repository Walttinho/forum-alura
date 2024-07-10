package com.aluraone.forum.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.aluraone.forum.domain.curso.Curso;
import com.aluraone.forum.domain.curso.CursoRepository;
import com.aluraone.forum.domain.curso.DadosCursoDto;
import com.aluraone.forum.domain.curso.DadosListagemCursoDto;
import com.aluraone.forum.domain.topico.DadosTopicoDto;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCursoDto cursoDto, UriComponentsBuilder uriBuilder){
     var curso = new Curso(cursoDto);
        repository.save(curso);

        var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemCursoDto(curso));

    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCursoDto>> listar(@PageableDefault(size  =  10,sort= {"id"}) Pageable paginacao) {
            var page = repository.findAll(paginacao).map(DadosListagemCursoDto::new);
            return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity mostrarDetalhesCurso(@PathVariable Long id) {
        var curso = repository.getReferenceById(id);
        var cursoDto = new DadosListagemCursoDto(curso);
        return ResponseEntity.ok(cursoDto);
    }  //fazer novo Dto para mostrar detalles de un curso en especifico ->  DadosDetalhamentoCursoDto



    //exclusão fisica
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
         repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}


