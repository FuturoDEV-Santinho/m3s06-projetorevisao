package br.com.santinho.m3s06projetorevisao.service;

import br.com.santinho.m3s06projetorevisao.entity.Autor;

import java.util.List;

public interface AutorService {

    // CRUD ( Create / Read / Update / Delete )

    // Create e Update
    Autor salvar(Autor autor) throws Exception;

    // Read
    List<Autor> buscar();
    Autor buscar(Long id) throws Exception;

    // Delete
    boolean apagar(Long id) throws Exception;

}
