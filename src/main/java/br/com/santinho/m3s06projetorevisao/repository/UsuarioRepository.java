package br.com.santinho.m3s06projetorevisao.repository;

import br.com.santinho.m3s06projetorevisao.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
