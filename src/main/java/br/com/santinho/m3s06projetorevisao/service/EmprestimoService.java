package br.com.santinho.m3s06projetorevisao.service;

import br.com.santinho.m3s06projetorevisao.entity.Emprestimo;

import java.util.List;

public interface EmprestimoService {

    Emprestimo buscar(Long id) throws Exception;
    List<Emprestimo> buscarPorUsuario(Long usuarioId);

    Emprestimo criar(Emprestimo emprestimo) throws Exception;

}
