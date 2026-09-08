package com.filmes.filme.services;

import com.filmes.filme.models.FilmeModel;
import com.filmes.filme.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeServices {

    @Autowired
    FilmeRepository filmeRepository;

    public List<FilmeModel> findAll() {
        return filmeRepository.findAll();
    }

    public FilmeModel buscarPorId(Long id) {
        return filmeRepository.findById(id).orElse(null);
    }

    public FilmeModel criarFilme(FilmeModel filmeModel) {
        return filmeRepository.save(filmeModel);
    }

    public void deletarFilme(Long id) {
        filmeRepository.deleteById(id);
    }

    public FilmeModel atualizarFilme(Long id, FilmeModel filmeModel) {

        FilmeModel filmeEncontrado = filmeRepository.findById(id).orElse(null);

        if (filmeEncontrado == null) {
            return null;
        }

        filmeEncontrado.setNome(filmeModel.getNome());
        filmeEncontrado.setGenero(filmeModel.getGenero());
        filmeEncontrado.setDiretor(filmeModel.getDiretor());
        filmeEncontrado.setEstudio(filmeModel.getEstudio());

        return filmeRepository.save(filmeEncontrado);
    }
}