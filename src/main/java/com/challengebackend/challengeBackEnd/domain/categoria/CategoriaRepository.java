package com.challengebackend.challengeBackEnd.domain.categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Categoria getReferenceByTitulo(String titulo);
}
