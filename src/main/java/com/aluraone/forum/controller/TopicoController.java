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

import com.aluraone.forum.domain.topico.DadosListagemTopicoDto;
import com.aluraone.forum.domain.topico.DadosTopicoDto;
import com.aluraone.forum.domain.topico.Topico;
import com.aluraone.forum.domain.topico.TopicoRepository;

@RestController
@RequestMapping("/topicos")

public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosTopicoDto topicoDto, UriComponentsBuilder uriBuilder){
        var topico = new Topico(topicoDto);
        repository.save(topico);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemTopicoDto(topico));
    }


    //só os topicos com status = true
    @GetMapping
    public ResponseEntity<Page<DadosListagemTopicoDto>> listar(@PageableDefault(size=10, sort = {"titulo"}) Pageable paginacao){
        var page = repository.findAllByStatusTrue(paginacao).map(DadosListagemTopicoDto::new);
         return ResponseEntity.ok(page);

    }

    //@GetMapping
    //public List<DadosListagemTopicoDto> listar() {
      //  return repository.findAll().stream().map(DadosListagemTopicoDto::new).toList();}

    /*@PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosListagemTopicoDto topicoDto ){
        var topico =  repository.getReferenceById(topicoDto.id());
        topico.atualizarInformacoes();
        return ResponseEntity.ok()

    }*/

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var topico = repository.getReferenceById(id);
        topico.inactivarTopico();
        return ResponseEntity.noContent().build();
    }


}
