package com.matheus.ma.filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public List<FilmeModel> findAll() {
        return filmeRepository.findAll();
    }

    public FilmeModel buscarPorId(Long id) {
        return filmeRepository.findById(id).get();
    }

    public FilmeModel criarFilme(FilmeModel filmeModel) {
        return filmeRepository.save(filmeModel);
    }

    public void deletarFilme(Long id) {
        filmeRepository.deleteById(id);
    }

    public FilmeModel atualizarFilme(Long id, FilmeModel filmeNew) {

        FilmeModel filmeModel = filmeRepository.findById(id).get();

        filmeModel.setNome(filmeNew.getNome());
        filmeModel.setGenero(filmeNew.getGenero());
        filmeModel.setDiretor(filmeNew.getDiretor());
        filmeModel.setAno(filmeNew.getAno());

        return filmeRepository.save(filmeModel);
    }
}