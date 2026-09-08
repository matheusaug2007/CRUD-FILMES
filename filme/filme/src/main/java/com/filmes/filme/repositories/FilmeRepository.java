package com.filmes.filme.repositories;

import com.filmes.filme.models.FilmeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<FilmeModel, Long> {

}
