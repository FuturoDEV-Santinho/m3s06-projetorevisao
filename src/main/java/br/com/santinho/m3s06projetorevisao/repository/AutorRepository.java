package br.com.santinho.m3s06projetorevisao.repository;

import br.com.santinho.m3s06projetorevisao.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
