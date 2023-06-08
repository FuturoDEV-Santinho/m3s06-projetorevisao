package br.com.santinho.m3s06projetorevisao.service;

import br.com.santinho.m3s06projetorevisao.entity.Livro;

import java.util.List;

public interface LivroService {

    // CRUD ( Create / Read / Update / Delete )

    // Create e Update
    Livro salvar(Livro livro) throws Exception;

    // Read
    List<Livro> buscar();
    Livro buscar(Long id) throws Exception;

    // Delete
    boolean apagar(Long id) throws Exception;

}
