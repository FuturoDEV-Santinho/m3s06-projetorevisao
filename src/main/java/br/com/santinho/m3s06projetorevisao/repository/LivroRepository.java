package br.com.santinho.m3s06projetorevisao.repository;

import br.com.santinho.m3s06projetorevisao.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
