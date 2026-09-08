package com.filmes.filme.controllers;

import com.filmes.filme.models.FilmeModel;
import com.filmes.filme.services.FilmeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/filmes")
public class FilmeController {

    @Autowired
    private FilmeServices filmeServices;

    @GetMapping
    public ResponseEntity<List<FilmeModel>> findAll() {

        List<FilmeModel> response = filmeServices.findAll();

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeModel> buscarPorId(@PathVariable Long id) {

        FilmeModel response = filmeServices.buscarPorId(id);

        if (response == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<FilmeModel> criarFilme(
            @RequestBody FilmeModel filmeModel) {

        FilmeModel response = filmeServices.criarFilme(filmeModel);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFilme(
            @PathVariable Long id) {

        filmeServices.deletarFilme(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmeModel> atualizarFilme(
            @PathVariable Long id,
            @RequestBody FilmeModel filmeModel) {

        FilmeModel response =
                filmeServices.atualizarFilme(id, filmeModel);

        if (response == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}