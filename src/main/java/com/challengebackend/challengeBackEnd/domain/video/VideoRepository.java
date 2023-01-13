package com.challengebackend.challengeBackEnd.domain.video;

import org.hibernate.annotations.Where;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {

    Page<Video> findAll(Pageable paginacao);

    Video getReferenceById(Long id);

    Page<Video> findByCategoriaId(Pageable paginacao, Long categoriaId);

    Page<Video> findAllById(Pageable paginacao, Long id);
}
