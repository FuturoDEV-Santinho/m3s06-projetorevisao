package br.com.santinho.m3s06projetorevisao.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "emprestimo")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emprestimo_id")
    private Long id;

    @Column(nullable = false)
    private Date dataEmprestimo;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private Integer quantidadeLivros;

    @Column(nullable = false)
    private Date dataDevolucao;

    @Column(precision = 19, scale = 2, nullable = false)
    private BigDecimal valorMulta;

    @OneToMany(mappedBy = "emprestimo", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<EmprestimoLivro> itens = new ArrayList<>();

}
