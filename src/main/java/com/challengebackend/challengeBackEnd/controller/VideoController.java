package com.challengebackend.challengeBackEnd.controller;

import com.challengebackend.challengeBackEnd.domain.DadosListagemTodosVideos;
import com.challengebackend.challengeBackEnd.domain.Video;
import com.challengebackend.challengeBackEnd.domain.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping
    public ResponseEntity<Page<DadosListagemTodosVideos>> listarTodosVideos(@PageableDefault(size=10) Pageable paginacao) {
        var page = videoRepository
                .findAll(paginacao)
                .map(DadosListagemTodosVideos::new);
        return ResponseEntity.ok(page);
    }

}
