package com.challengebackend.challengeBackEnd.domain.video;

import com.challengebackend.challengeBackEnd.domain.video.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

public interface VideoRepository extends JpaRepository<Video, Long> {

    Page<Video> findAll(Pageable paginacao);
    Video getReferenceById(Long id);

}
