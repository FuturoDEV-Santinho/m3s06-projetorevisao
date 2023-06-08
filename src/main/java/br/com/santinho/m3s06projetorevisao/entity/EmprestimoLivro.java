package br.com.santinho.m3s06projetorevisao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@Entity
@Table(name = "emprestimo_livro")
public class EmprestimoLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emprestimo_livro_id")
    private Long id;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(name = "emprestimo_id", nullable = false)
    private Emprestimo emprestimo;

    @ManyToOne
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;

}
