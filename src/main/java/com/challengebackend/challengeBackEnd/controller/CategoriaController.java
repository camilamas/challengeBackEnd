package com.challengebackend.challengeBackEnd.controller;

import com.challengebackend.challengeBackEnd.domain.categoria.*;
import com.challengebackend.challengeBackEnd.domain.video.VideoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping
    public ResponseEntity<Page<DadosListagemTodasCategorias>> listarTodosVideos(@PageableDefault(size = 10) Pageable paginacao) {
        var page = categoriaRepository.findAll(paginacao).map(DadosListagemTodasCategorias::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemCategoria> listarCategoria(@PathVariable Long id) {
        var categoria = categoriaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosListagemCategoria(categoria));
    }

    @GetMapping("/{id}/videos")
    public ResponseEntity<Page<DadosListagemVideosPorCategoria>> listarVideosPorCategoria(@PathVariable Long id, @PageableDefault(size = 10) Pageable paginacao) {
        var categoria = categoriaRepository.getReferenceById(id);
        var page = videoRepository.findByCategoriaId(paginacao, id).map((video) -> new DadosListagemVideosPorCategoria(video, categoria));
        return ResponseEntity.ok(page);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemCategoria> cadastrarCategoria(@RequestBody @Valid DadosCadastroCategoria dados, UriComponentsBuilder builder) {
        var categoria = new Categoria(dados);
        categoriaRepository.save(categoria);
        var uri = builder.path("categoria/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemCategoria(categoria));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosListagemCategoria> atualizarCategoria(@RequestBody @Valid DadosAtualizacaoCategoria dados) {
        var categoria = categoriaRepository.getReferenceById(dados.id());
        categoria.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemCategoria(categoria));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirCategoria(@PathVariable Long id) {
        var categoria = categoriaRepository.getReferenceById(id);
        categoriaRepository.delete(categoria);
        return ResponseEntity.noContent().build();
    }


}
