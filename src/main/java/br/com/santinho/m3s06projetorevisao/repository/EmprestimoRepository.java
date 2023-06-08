package br.com.santinho.m3s06projetorevisao.repository;

import br.com.santinho.m3s06projetorevisao.entity.Emprestimo;
import br.com.santinho.m3s06projetorevisao.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    /** DerivedQuery */
    List<Emprestimo> findByUsuarioIdOrderByDataEmprestimoDesc(Long usuarioId);

    /** JPQL */
    @Query("SELECT e FROM Emprestimo e WHERE e.usuario.id = :usuarioId ORDER BY e.dataEmprestimo DESC")
    List<Emprestimo> findByUsuario(Long usuarioId);

    /** Native Query */
    @Query(
        value = "SELECT e.* FROM emprestimo e WHERE e.usuario_id = :usuarioId ORDER BY e.data_emprestimo DESC",
        nativeQuery = true
    )
    List<Emprestimo> findByUsuarioId(Long usuarioId);

}
