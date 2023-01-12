package com.challengebackend.challengeBackEnd.domain.video;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VideoRepository extends JpaRepository<Video, Long> {

    Page<Video> findAll(Pageable paginacao);

    Video getReferenceById(Long id);

    Page<Video> findAllByCategoriaId(Pageable paginacao, Long id);

    Page<Video> findAllById(Pageable paginacao, Long id);
}
