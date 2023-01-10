package com.challengebackend.challengeBackEnd.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

public interface VideoRepository extends JpaRepository<Video, Long> {

    Page<Video> findAll(Pageable paginacao);

}
