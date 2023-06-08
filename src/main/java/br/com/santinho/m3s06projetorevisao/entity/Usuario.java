package br.com.santinho.m3s06projetorevisao.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Date nascimento;

    @Column(length = 15, nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String email;

}
