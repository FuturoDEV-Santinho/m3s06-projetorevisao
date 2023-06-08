package br.com.santinho.m3s06projetorevisao.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autor_id")
    private Long id;

    @Column(length = 15, nullable = false)
    private String nome;

    @Column(length = 30, nullable = false)
    private String sobrenome;

    private Date nascimento;

}
