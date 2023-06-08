package br.com.santinho.m3s06projetorevisao.service;

import br.com.santinho.m3s06projetorevisao.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    // CRUD ( Create / Read / Update / Delete )

    // Create e Update
    Usuario salvar(Usuario usuario) throws Exception;

    // Read
    List<Usuario> buscar();
    Usuario buscar(Long id) throws Exception;

    // Delete
    boolean apagar(Long id) throws Exception;

}
