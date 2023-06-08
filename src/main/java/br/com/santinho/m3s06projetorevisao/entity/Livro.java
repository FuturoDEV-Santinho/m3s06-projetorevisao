package br.com.santinho.m3s06projetorevisao.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "livro_id")
    private Long id;

    @Column(length = 100, nullable = false)
    private String titulo;

    private String subtitulo;

    @Column(length = 20, nullable = false)
    private String categoria;

    @Column(nullable = false)
    private Integer classificacaoEtaria;

    @Column(nullable = false)
    private Integer numeroPaginas;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @Column(length = 20, nullable = false)
    private String editora;

    @Column(nullable = false)
    private Integer quantidadeDisponivel = 0;

}
