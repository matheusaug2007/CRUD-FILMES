package com.matheus.ma.filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;


    @GetMapping
    public ResponseEntity<List<FilmeModel>> findAll() {

        List<FilmeModel> response = filmeService.findAll();

        return ResponseEntity.ok().body(response);
    }


    @PostMapping
    public ResponseEntity<FilmeModel> criarFilme(@RequestBody FilmeModel filmeModel) {

        FilmeModel response = filmeService.criarFilme(filmeModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarId(@PathVariable Long id) {

        filmeService.deletarFilme(id);

        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<FilmeModel> atualizarFilme(
            @PathVariable Long id,
            @RequestBody FilmeModel filmeModel) {

        FilmeModel response = filmeService.atualizarFilme(id, filmeModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<FilmeModel> buscarId(@PathVariable Long id) {

        FilmeModel response = filmeService.buscarPorId(id);

        return ResponseEntity.ok().body(response);
    }
}
